package pers.peixinyi.kafka.notice;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pers.peixinyi.kafka.client.KafkaConsumer;
import pers.peixinyi.kafka.client.KafkaProducer;

/**
 * @author peixinyi
 * @version 0.0.0.0
 * @date 2021-04-15 17:32
 * @describe none
 */
@Component
public class EmailNotice implements KafkaConsumer {

    @KafkaListener(id = "myId2", topics = {RegisterNotice.registerTopic})
    public void listen(ConsumerRecord<?, ?> record) {
        System.out.println("------------------------------");
        System.out.println("发送欢迎邮件至->" + record.value());
        System.out.println("------------------------------");
    }
}
