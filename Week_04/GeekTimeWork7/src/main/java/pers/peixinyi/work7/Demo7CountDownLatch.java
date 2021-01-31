package pers.peixinyi.work7;

import java.util.concurrent.CountDownLatch;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-01-29 14:43
 */
public class Demo7CountDownLatch extends Fibo{
    private static volatile int value = 0;
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    private Integer get() throws InterruptedException {
        countDownLatch.await();
        return value;
    }
    private void sum() {
        value = fibo(36);
        countDownLatch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        Demo7CountDownLatch demo = new Demo7CountDownLatch();

        new Thread(() -> {
            demo.sum();
        }).start();

        int result = demo.get();
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }
}
