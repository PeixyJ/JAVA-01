package pers.peixinyi.thread;

import io.netty.channel.pool.FixedChannelPool;

import java.util.concurrent.*;

/**
 * @Description:
 * @Author: PeiXy
 * @Date: 2021-01-24 21:05
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        BlockingQueue blockingQueue = new LinkedBlockingQueue<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 8, 1, TimeUnit.SECONDS, workQueue);
    }
}
