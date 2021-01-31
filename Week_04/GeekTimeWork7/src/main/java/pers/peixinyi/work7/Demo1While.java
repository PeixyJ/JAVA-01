package pers.peixinyi.work7;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-01-28 10:54
 * 通过自循环判断进行获取value
 */
public class Demo1While extends Fibo {

    public volatile static Integer value = 0;

    private void sum() {
        value = fibo(36);
    }

    private Integer get() {
        while (true) {
            if (value != null) {
                return value;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();

        Demo1While demo = new Demo1While();

        new Thread(() -> {
            demo.sum();
        }).start();

        int result = demo.get();
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

    }

}
