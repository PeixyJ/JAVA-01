package pers.peixinyi.kafka.client;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author peixinyi
 * @version 0.0.0.0
 * @date 2021-04-15 16:26
 * @describe none
 */
@Component
public class KafkaConsumerImpl implements KafkaConsumer {

    @KafkaListener(id = "myId1", topics = {"topic1"})
    public void listen(ConsumerRecord<?, ?> record) {
        System.out.println("----------------");
        System.out.println(record.toString());
        System.out.println("----------------");
    }
}
