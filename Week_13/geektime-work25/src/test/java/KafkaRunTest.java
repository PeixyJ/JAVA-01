import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.peixinyi.kafka.ApplicationRun;
import pers.peixinyi.kafka.client.KafkaConsumer;
import pers.peixinyi.kafka.client.KafkaProducer;

/**
 * @author peixinyi
 * @version 0.0.0.0
 * @date 2021-04-15 16:43
 * @describe none
 */
@SpringBootTest(classes = ApplicationRun.class)
public class KafkaRunTest {

    @Autowired
    KafkaConsumer kafkaConsumer;

    @Autowired
    KafkaProducer kafkaProducer;

    @Test
    public void runTest() {
        kafkaProducer.send("topic1","Hello");
    }
}
