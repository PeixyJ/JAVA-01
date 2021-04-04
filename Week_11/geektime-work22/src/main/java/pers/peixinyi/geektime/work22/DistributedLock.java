package pers.peixinyi.geektime.work22;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-03-31 20:04
 */
public class DistributedLock {
    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://192.168.10.155:6379");

        RedissonClient client = Redisson.create(config);

        RLock rLock = client.getLock("lock");

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                rLock.lock();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " - " + System.currentTimeMillis());
                rLock.unlock();
            });
        }
    }
}
