package pers.hongdenglv;

import pers.hongdenglv.client.ActiveMessageQueueClient;
import pers.hongdenglv.client.QueueClient;

/**
 * @author peixinyi
 * @version 0.0.0.0
 * @date 2021-04-05 16:42
 * @describe none
 */
public class RunApplicationTopic {
    private static ActiveMessageQueueClient activeMessageQueueClient;
    private static QueueClient queueClient;
    private static String topic = "A.TOPIC";

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
        queueClient.createQueue(topic);
        queueClient.sendMessage(topic, "Hi,I'm Tom , I send a message at " + System.currentTimeMillis() + " - topic");
    }

    public static void getMessage() {
        queueClient.getMessage(topic);
    }
}
