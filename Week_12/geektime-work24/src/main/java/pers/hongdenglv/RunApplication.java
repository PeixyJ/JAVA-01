package pers.hongdenglv;

import pers.hongdenglv.client.ActiveMessageQueueClient;
import pers.hongdenglv.client.QueueClient;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-04-04 21:46
 */
public class RunApplication {
    private static ActiveMessageQueueClient activeMessageQueueClient;
    private static QueueClient queueClient;
    private static String queueName = "EQ.S00.BS10009.GET";


    static {
        activeMessageQueueClient = new ActiveMessageQueueClient
                .Builder()
                .setUrl("tcp://localhost:55006")
                .build();
        queueClient = activeMessageQueueClient.getQueueClient();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread putThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                putMessage();
            }
        });

        Thread getThread = new Thread(() -> {
            getMessage();
        });
        System.out.println("开始发送消息");
        putThread.start();
        System.out.println("开始接收消息");
        getThread.start();

        while (putThread.isAlive()) {

        }

        activeMessageQueueClient.disConnect();
    }

    public static void putMessage() {
        queueClient.createQueue(queueName);
        queueClient.sendMessage(queueName, "Hi,I'm Tom , I send a message at " + System.currentTimeMillis());
    }

    public static void getMessage() {
        queueClient.getMessage(queueName);
    }
}
