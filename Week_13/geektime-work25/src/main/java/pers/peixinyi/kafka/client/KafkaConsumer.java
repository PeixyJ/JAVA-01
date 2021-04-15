package pers.peixinyi.kafka.client;

import org.apache.kafka.clients.consumer.ConsumerRecord;

/**
 * @author HongDengLv - PeiXy
 * @version 0.0.0.0
 * @date 2021-04-15 16:24
 * @describe none
 */
public interface KafkaConsumer {

    public void listen(ConsumerRecord<?, ?> record);

}
