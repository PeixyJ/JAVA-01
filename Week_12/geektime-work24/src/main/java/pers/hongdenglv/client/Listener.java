package pers.hongdenglv.client;

import org.apache.activemq.transport.nio.SelectorManager;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author peixinyi
 * @version 0.0.0.0
 * @date 2021-04-05 16:01
 * @describe none
 */
public class Listener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println(System.currentTimeMillis() + "Get Message -> " + ((TextMessage) message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
