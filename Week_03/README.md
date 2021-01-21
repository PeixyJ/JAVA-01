# netty-gateway
功能列表

1. 过滤器
2. 实现GET路由分发
   1. 可配置去掉路由前缀
3. 负载均衡 
   1. 轮询
   2. 权重负载
   3. 随机负载
    
## 调用范例
```text
curl "http://127.0.0.1/baidu/s?wd=123"
curl "http://127.0.0.1/api/hello"
```
/baidu/s?wd=123 -> http://www.baidu.com/s?wd=123

/api/hello 默认指向-> 127.0.0.1:8088/api/hello
    
## ChangeLog
2021年1月21日 22:46:49

Peixy - 完成基础功能

## TODO LIST
1. 优化配置
2. 添加POST调用
3. 添加转发调用包含参数