# Week12

## Work23

1、(必做)配置redis的主从复制，sentinel高可用，Cluster集群。 

[配置redis的主从复制，sentinel高可用，Cluster集群](e6a78394c99547d3bca914eb6d9a8fab.md)

2、(选做)练习示例代码里下列类中的作业题:08cache/redis/src/main/java/io/kimmking/cache/RedisApplication.java 

3、(选做☆)练习redission的各种功能; 4、(选做☆☆)练习hazelcast的各种功能;

5、(选做☆☆☆)搭建hazelcast 3节点集群，写入100万数据到一个map，模拟和演 示高可用;

## Work24

1、(必做)搭建ActiveMQ服务，基于JMS，写代码分别实现对于queue和topic的消息 生产和消费，代码提交到github。
[Queue操作](geektime-work24/src/main/java/pers/hongdenglv/RunApplication.java)
[Topic操作](geektime-work24/src/main/java/pers/hongdenglv/RunApplicationTopic.java)


2、(选做)基于数据库的订单表，模拟消息队列处理订单: 1)一个程序往表里写新订单，标记状态为未处理(status=0);

2)另一个程序每隔100ms定时从表里读取所有status=0的订单，打印一下订单数据， 然后改成完成status=1;

3)(挑战☆)考虑失败重试策略，考虑多个消费程序如何协作。 3、(选做)将上述订单处理场景，改成使用ActiveMQ发送消息处理模式。

4)(选做)使用java代码，创建一个ActiveMQ Broker Server，并测试它。