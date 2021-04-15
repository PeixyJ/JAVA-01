package pers.peixinyi.kafka.server;

/**
 * @author peixinyi
 * @version 0.0.0.0
 * @date 2021-04-15 17:14
 * @describe 用topic 模拟一个用户注册推送的场景
 */
public interface UserRegisteredService {
    /**
     * @param username 用户名称
     * @author peixinyi
     * @version 0.0.0.0
     * @date 2021/4/15 17:21
     * @describe 用户注册
     */
    public String register(String username);

}
