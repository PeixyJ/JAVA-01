package pers.peixinyi.work7;

import java.util.concurrent.CompletableFuture;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-01-31 15:21
 * TODO 需要再理解下该Future
 */
public class Demo10CompletableFuture extends Fibo {

    private static int sum() {
        return fibo(36);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Integer result = CompletableFuture.supplyAsync(() -> sum()).join();
        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }
}
