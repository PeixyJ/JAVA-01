package pers.peixinyi.work7;

import java.util.concurrent.*;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-01-28 10:58
 * 使用FutureTask获取
 */
public class Demo8FutureTask extends Fibo {

    private static volatile Integer value = null;

    private void sum() {
        value = fibo(36);
    }

    private Integer get() {
        return value;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        Demo8FutureTask demo = new Demo8FutureTask();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> {
            demo.sum();
            return demo.get();
        });

        new Thread(futureTask).start();

        int result = futureTask.get();
        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }
}