# 第13周

## 第25课

1、(必做)搭建一个3节点Kafka集群，测试功能和性能;实现spring kafka下对kafka集群 的操作，将代码提交到github。

### 修改配置文件

修改配置文件 `/config/server.properties`,因为我们需要以集群的方式进行启动.所以我们要拷贝4份配置文件.3份作为启动,1份作为备份.

#### 需要修改的内容

`[broker.id](http://broker.id)` 必须要按序填写否则无法启动

`listeners`=PLAINTEXT://:9092  → PLAINTEXT 为安全协议 9092 为暴露的端口

`log.dirs` 日志文件,只能每个服务使用独立的一个

`zookeeper.connect`  设置zookeeper的地址

#### 启动Zookeeper

```docker
docker run -idt --name zookeeper -p 2181:2181 zookeeper
```

#### 启动服务

当前目录为 bin 目录下

```docker
./kafka-server-start.sh ../config/server0.properties
./kafka-server-start.sh ../config/server1.properties
./kafka-server-start.sh ../config/server2.properties
```

[代码实现](geektime-work25)

2、(选做)安装kafka-manager工具，监控kafka集群状态。 3、(挑战☆)演练本课提及的各种生产者和消费者特性。

4、(挑战☆☆☆)Kafka金融领域实战:在证券或者外汇、数字货币类金融核心交易系统里， 对于订单的处理，大概可以分为收单、定序、撮合、清算等步骤。其中我们一般可以用mq来 实现订单定序，然后将订单发送给撮合模块。

1)收单:请实现一个订单的rest接口，能够接收一个订单Order对象;

2)定序:将Order对象写入到kafka集群的order.usd2cny队列，要求数据有序并且不丢失;

3)撮合:模拟撮合程序(不需要实现撮合逻辑)，从kafka获取order数据，并打印订单信息， 要求可重放, 顺序消费, 消息仅处理一次。