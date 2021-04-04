package pers.peixinyi.geektime.work22;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-04-02 17:07
 */
public class PubSub {

    private static RedissonClient client;

    static {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        client = Redisson.create(config);
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable target = new ListenRunnable();
        new Thread(target).run();
    }
}
