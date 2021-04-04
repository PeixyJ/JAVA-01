package pers.peixinyi.geektime.work22;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-04-02 16:10
 */
public class DistributedInventory {

    private static RedissonClient client;
    private static RLock rLock;
    private static String goodsKey = "goods:";

    static {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.10.155:6379");
        client = Redisson.create(config);
        rLock = client.getLock("reduceGoodsLock");
    }

    public static String getGoodsKey(Goods goods) {
        return goodsKey + goods.getId();
    }

    public void createGoods(Goods goods) throws Exception {
        String key = getGoodsKey(goods);

        if (client.getAtomicLong(key).isExists()) {
            throw new Exception("商品已经存在");
        }

        client.getAtomicLong(key).set(goods.getInventory());
    }

    public void reduceGoods(Goods goods) throws Exception {
        String key = getGoodsKey(goods);
        try {
            rLock.lock();
            if (client.getAtomicLong(key).get() > 0) {
                client.getAtomicLong(key).decrementAndGet();
            } else {
                throw new Exception("库存少于1");
            }
        } finally {
            rLock.unlock();
        }
    }

    public static void main(String[] args) {
        DistributedInventory distributedInventory = new DistributedInventory();
        Goods goods = new Goods(1, 100000);
        try {
            distributedInventory.createGoods(goods);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ExecutorService executorService = Executors.newFixedThreadPool(16);

        for (int i = 0; i < 100000; i++) {
            executorService.execute(() -> {
                try {
                    distributedInventory.reduceGoods(goods);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("商品数量不足");
                }
            });
        }
        executorService.shutdown();
        System.out.println(1000000);
        try {
            executorService.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        client.shutdown();
    }
}
