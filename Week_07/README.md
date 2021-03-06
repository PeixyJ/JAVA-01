# 第13节 性能与 SQL 优化
## 作业

1、（选做）用今天课上学习的知识，分析自己系统的 SQL 和表结构
2、（必做）按自己设计的表结构，插入100万订单模拟数据，测试不同方式的插入效率。
3、（选做）按自己设计的表结构，插入1000万订单模拟数据，测试不同方式的插入效率。
4、（选做）使用不同的索引或组合，测试不同方式查询效率。
5、（选做）调整测试数据，使得数据尽量均匀，模拟1年时间内的交易，计算一年的销售报表：销售总额，订单数，客单价，每月销售量，前十的商品等等（可以自己设计更多指标）
6、（选做）尝试自己做一个 ID 生成器（可以模拟 Seq 或 Snowflake）。
7、（选做）尝试实现或改造一个非精确分页的程序。

![](WeChat3a2d40ac9883f5a6ca8fc7e385e19f4b.png)

在多线程时已经无法增加效率,疑似本机Mysql性能问题.
TODO检查Mysql

# 第14节 
## 作业
1、(选做)配置一遍异步复制，半同步复制、组复制。
2、(必做)读写分离-动态切换数据源版本1.0
3、(必做)读写分离-数据库框架版本2.0
4、(选做)读写分离-数据库中间件版本3.0
5、(选做)配置 MHA，模拟 master 宕机6、(选做)配置 MGR，模拟 master 宕机7、(选做)配置 Orchestrator，模拟 master 宕机，演练 UI 调整拓扑结构

### 第二题 读写分离-动态切换数据源版本1.0

[动态切换数据源版本1.0 实现源码](./geektime-work14/base-mysql-proxy/src/test/java/DataConfigTest.java)

### 第三题

[读写分离-数据库框架版本2.0 实现源码](./geektime-work14/framework-mysql-proxy/src/test/java/DataConfigTest.java)

### 第一题

创建两个Docker mysql,本来想在本机启动两个sql实例,但是一直起不来所以使用了该方法.

```bash
docker run -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 -v ./db0:/etc/mysql/conf.d --name db0  -d mysql
docker run -p 3316:3306 -e MYSQL_ROOT_PASSWORD=123456 -v ./db1:/etc/mysql/conf.d --name db1  -d mysql
```

## Mysql配置文件

在默认情况下,.`/db0` 路径会有 `docker.cnf`,`mysql.cnf`两个文件,修改docker.cnf

有个小坑,原先我的server-id 设置为0会提示  Last_IO_Error: Got fatal error 1236 from master when reading data from binary log: 'Misconfigured master - master server_id is 0' 错误修改后正常

### db0

```bash
[mysqld]
skip-host-cache
skip-name-resolve
server-id = 10

sql_mode=NO_ENGINE_SUBSTITUTION,STRICT_TRANS_TABLES
log_bin=mysql-bin
binlog-format=Row
```

## db1

```bash
[mysqld]
skip-host-cache
skip-name-resolve
server-id = 11

sql_mode=NO_ENGINE_SUBSTITUTION,STRICT_TRANS_TABLES
log_bin=mysql-bin
binlog-format=Row
```

然后 启动 Docker.

## 配置主节点

```bash
mysql -hxxx.xxx.xxx.xxx -P3306 -uroot
```

首先在 `master` 上创建同步用户,设置登陆地址,刷新.

```sql
CREATE USER 'repl'@'%' IDENTIFIED BY '123456';
GRANT REPLICATION SLAVE ON *.* TO 'repl'@'%';
flush privileges;
```

再查看 主库状态 `show master status;` 记录 `File` 和 `Position`;

```sql
+------------------+----------+--------------+------------------+-------------------+
| File             | Position | Binlog_Do_DB | Binlog_Ignore_DB | Executed_Gtid_Set |
+------------------+----------+--------------+------------------+-------------------+
| mysql-bin.000002 |      156 |              |                  |                   |
+------------------+----------+--------------+------------------+-------------------+
```

## 配置从节点

```bash
mysql -hxxx.xxx.xxx.xxx -P3316 -uroot
```

修改`Master` MASTER_LOG_FILE,MASTER_LOG_POS要填上方记录的东西.

```bash
CHANGE MASTER TO
    MASTER_HOST='xxx.xxx.xxx.xxx',  
    MASTER_PORT = 3306,
    MASTER_USER='repl',      
    MASTER_PASSWORD='123456',   
    MASTER_LOG_FILE='mysql-bin.000002',
    MASTER_LOG_POS=156;
```

然后启动 slave;

```sql
start slave;
--查看slave状态
show slave status\G

*************************** 1. row ***************************
               Slave_IO_State: Waiting for master to send event
                  Master_Host: 192.168.10.155
                  Master_User: repl
                  Master_Port: 3306
                Connect_Retry: 60
              Master_Log_File: mysql-bin.000002
          Read_Master_Log_Pos: 289422037
               Relay_Log_File: 53866893b733-relay-bin.000004
                Relay_Log_Pos: 289422252
        Relay_Master_Log_File: mysql-bin.000002
             Slave_IO_Running: Yes
            Slave_SQL_Running: Yes
              Replicate_Do_DB:
          Replicate_Ignore_DB:
           Replicate_Do_Table:
       Replicate_Ignore_Table:
      Replicate_Wild_Do_Table:
  Replicate_Wild_Ignore_Table:
                   Last_Errno: 0
                   Last_Error:
                 Skip_Counter: 0
          Exec_Master_Log_Pos: 289422037
              Relay_Log_Space: 289422636
              Until_Condition: None
               Until_Log_File:
                Until_Log_Pos: 0
           Master_SSL_Allowed: No
           Master_SSL_CA_File:
           Master_SSL_CA_Path:
              Master_SSL_Cert:
            Master_SSL_Cipher:
               Master_SSL_Key:
        Seconds_Behind_Master: 0
Master_SSL_Verify_Server_Cert: No
                Last_IO_Errno: 0
                Last_IO_Error:
               Last_SQL_Errno: 0
               Last_SQL_Error:
  Replicate_Ignore_Server_Ids:
             Master_Server_Id: 10
                  Master_UUID: 456d800a-7ca9-11eb-8d11-0242ac110005
             Master_Info_File: mysql.slave_master_info
                    SQL_Delay: 0
          SQL_Remaining_Delay: NULL
      Slave_SQL_Running_State: Slave has read all relay log; waiting for more updates
           Master_Retry_Count: 86400
                  Master_Bind:
      Last_IO_Error_Timestamp:
     Last_SQL_Error_Timestamp:
               Master_SSL_Crl:
           Master_SSL_Crlpath:
           Retrieved_Gtid_Set:
            Executed_Gtid_Set:
                Auto_Position: 0
         Replicate_Rewrite_DB:
                 Channel_Name:
           Master_TLS_Version:
       Master_public_key_path:
        Get_master_public_key: 0
            Network_Namespace:
```

注意看 `Slave_IO_Running` & `Slave_SQL_Running` 是否都是Yes.如果不是yes可以查看 `Last_IO_Error` 进行排查.

我遇到了以下错误

```sql
Last_IO_Error: Got fatal error 1236 from master when reading data from binary log: 'Misconfigured master - master server_id is 0'
```

解决方案,修改了server-id 从原先的 1 → 改为了10