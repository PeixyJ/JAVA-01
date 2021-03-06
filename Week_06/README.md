# 学习笔记 Week6
## 第12节课作业 
* 基于电商交易场景(用户、商品、订单)，设计一套简单的表结构，提交DDL 的 SQL 文件到 Github(后面2周的作业依然要是用到这个表结构)。

![](电商交易.png)

```sql
/**创建消费者表**/
drop table consumer;
create table consumer
(
    id              int auto_increment comment 'ID' primary key,
    email           varchar(320) default '' comment '用户登陆邮箱',
    mobile_phone_no varchar(14)  default '' comment '手机号码',
    nickname        varchar(14)  default '' comment '用户昵称',
    password        varchar(256) default '' comment '用户密码',
    old_password    varchar(256) default '' comment '用户历史密码',
    profile_photo   varchar(256) default '' comment '头像',
    remove_tag      int          default 0 comment '-1删除,0 不删除',
    state           int(1)       default 0 comment '用户状态,-1为停封,0为正常',
    update_time     timestamp comment '修改时间',
    create_time     timestamp comment '创建时间',
    note            varchar(64)  default '' comment '备注'
) comment '消费者表' charset 'utf8mb4';
/**创建消费者详细信息表**/
drop table consumer_info;
create table consumer_info
(
    id          int comment 'ID' primary key,
    username    varchar(14) default '' comment '用户名称',
    age         int(3)      default 0 comment '用户年龄',
    gender      int(1)      default 0 comment '性别 0为未知,1为男,2为女',
    height      int(3)      default 0 comment '身高',
    weight      int(4)      default 0 comment '体重',
    married     int(1)      default 0 comment '婚姻 -1 未婚,0未知,1 已婚',
    remove_tag  int         default 0 comment '-1删除,0 不删除',
    update_time timestamp comment '修改时间',
    create_time timestamp comment '创建时间',
    note        varchar(64) default '' comment '备注'
) comment '消费者详细信息表' charset 'utf8mb4';
/**创建消费者登陆信息表**/
drop table consumer_login;
create table consumer_login
(
    id          int auto_increment comment 'ID' primary key,
    consumer_id int          default 0 comment '用户id',
    user_ip     varchar(128) default '' comment '用户登陆ip',
    countries   varchar(32)  default '' comment '登陆国家',
    provinces   varchar(32)  default '' comment '省',
    city        varchar(32)  default '' comment '市',
    area        varchar(64)  default '' comment '区',
    create_time timestamp comment '创建时间',
    note        varchar(64)  default '' comment '备注'
) comment '用户登录信息' charset 'utf8mb4';
/**创建消费者常登陆信息表**/
drop table normal_login_address;
create table normal_login_address
(
    consumer_id int comment '用户id' primary key,
    countries   varchar(32) default '' comment '登陆国家',
    provinces   varchar(32) default '' comment '省',
    city        varchar(32) default '' comment '市',
    area        varchar(64) default '' comment '区',
    update_time timestamp comment '修改时间',
    create_time timestamp comment '创建时间',
    note        varchar(64) default '' comment '备注'
) comment '用户常登陆地址' charset 'utf8mb4';
/**创建收货地址信息表**/
drop table receives_address;
create table receives_address
(
    id          int auto_increment comment 'id' primary key,
    consumer_id int comment 'userid',
    countries   varchar(32)  default '' comment '登陆国家',
    provinces   varchar(32)  default '' comment '省',
    city        varchar(32)  default '' comment '市',
    area        varchar(64)  default '' comment '区',
    detail      varchar(255) default '' comment '详细地址',
    update_time timestamp comment '修改时间',
    create_time timestamp comment '创建时间',
    note        varchar(64)  default '' comment '备注'
) comment '收货地址' charset 'utf8mb4';
/**创建商品信息表**/
drop table goods;
create table goods
(
    id          int auto_increment comment 'id' primary key,
    img         varchar(255) default '' comment '商品图片',
    title       varchar(64)  default '' comment '商品标题',
    price       int comment '商品价格/分',
    shelves     int          default -1 comment '-1下架,0上架',
    remove_tag  int          default 0 comment '-1删除,0 不删除',
    update_time timestamp comment '修改时间',
    create_time timestamp comment '创建时间',
    note        varchar(64)  default '' comment '备注'
) comment '商品信息' charset 'utf8mb4';
/**创建订单信息表**/
drop table orders;
CREATE TABLE `orders` (
  `id` varchar(64) NOT NULL,
  `consumer_id` int DEFAULT NULL COMMENT '消费者id',
  `countries` varchar(32) DEFAULT '' COMMENT '国家',
  `provinces` varchar(32) DEFAULT '' COMMENT '省',
  `city` varchar(32) DEFAULT '' COMMENT '市',
  `area` varchar(64) DEFAULT '' COMMENT '区',
  `detail` varchar(255) DEFAULT '' COMMENT '详细地址',
  `order_amount` int DEFAULT '0' COMMENT '订单总价/分',
  `logistics_fees` int DEFAULT '0' COMMENT '订单总价/分',
  `logistics_status` int DEFAULT '0' COMMENT '物流状态',
  `order_status` int DEFAULT '0' COMMENT '0未付款,-1关闭,1已付款,2已发货,3已签收,4以退款',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `note` varchar(64) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品信息'
/**创建订单商品关联表**/
drop table orders_goods;
create table orders_goods
(
    id          int auto_increment comment 'id' primary key,
    goods_id    int comment '商品id',
    amount      int comment '商品数量',
    price       int comment '单价/分',
    total       int comment '总价/分',
    snapshot    json null comment '商品快照JSON',
    update_time timestamp comment '修改时间',
    create_time timestamp comment '创建时间',
    note        varchar(64) default '' comment '备注'
)comment '商品信息' charset 'utf8mb4';
```