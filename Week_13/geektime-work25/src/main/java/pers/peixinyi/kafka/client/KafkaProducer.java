package pers.peixinyi.kafka.client;

import org.springframework.stereotype.Component;

/**
 * @author peixinyi
 * @version 0.0.0.0
 * @date 2021-04-15 16:26
 * @describe none
 */
public interface KafkaProducer {

    void send(String topic, String message);

}
