package pers.peixinyi.thread;

/**
 * @Description:
 * @Author: PeiXy
 * @Date: 2021-01-24 16:18
 */
public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread thread = Thread.currentThread();
                System.out.println("当前线程是:" + thread.getName());
            }
        };
        Thread demo = new Thread(runnable);
        demo.setName("Demo1");
        demo.setDaemon(true);
        demo.start();
        demo.join();

        String s = new String();
        s.wait();
        s.notify();
    }
}