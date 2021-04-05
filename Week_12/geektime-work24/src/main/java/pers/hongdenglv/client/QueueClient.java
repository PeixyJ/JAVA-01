package pers.hongdenglv.client;

import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @author peixinyi
 * @version 0.0.0.0
 * @date 2021-04-05 16:45
 * @describe none
 */
public class QueueClient {

    ActiveMessageQueueClient queueClient;

    public QueueClient(ActiveMessageQueueClient queueClient) {
        this.queueClient = queueClient;
    }

    public void createQueue(String queueName) {
        System.out.println("ActiveMQ Create Queue -> " + queueName);
        try {
            queueClient.getSession().createQueue(queueName);
        } catch (JMSException e) {
            System.out.println("创建队列 -> " + queueName + "失败!");
        }
    }

    public void sendMessage(String queueName, String message) {
        try {
            TextMessage textMessage = queueClient.getSession().createTextMessage(message);
            queueClient.getSession().createProducer(new ActiveMQQueue(queueName)).send(textMessage);
        } catch (JMSException e) {
            System.out.println("发送消息->" + message + "失败");
        }
    }

    public void getMessage(String queueName) {
        try {
            queueClient.getSession().createConsumer(new ActiveMQQueue(queueName)).setMessageListener(new Listener());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
