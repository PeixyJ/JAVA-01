# 第11周

## 第22课

1、(选做)命令行下练习操作Redis的各种基本数据结构和命令。

2、(选做)分别基于jedis，RedisTemplate，Lettuce，Redission实现redis基本操作 的demo，可以使用spring-boot集成上述工具。

3、(选做)spring集成练习: 

    1)实现update方法，配合@CachePut 

    2)实现delete方法，配合@CacheEvict 

    3)将示例中的spring集成Lettuce改成jedis或redisson。 

4、(必做)基于Redis封装分布式数据操作: 

    1)在Java中实现一个简单的分布式锁; 

    [DistributedLock.java](geektime-work22/src/main/java/pers/peixinyi/geektime/work22/DistributedLock.java)

    2)在Java中实现一个分布式计数器，模拟减库存。 

    [DistributedInventory.java](geektime-work22/src/main/java/pers/peixinyi/geektime/work22/DistributedInventory.java)


5、基于Redis的PubSub实现订单异步处理

    [PubSub.java](geektime-work22/src/main/java/pers/peixinyi/geektime/work22/PubSub.java)
