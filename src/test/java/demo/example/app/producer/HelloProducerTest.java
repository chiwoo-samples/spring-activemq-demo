package demo.example.app.producer;

import demo.example.app.consumer.HelloConsumer;
import demo.example.app.message.HelloRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.concurrent.TimeUnit;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class HelloProducerTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private HelloProducer producer;

    private HelloTestConsumer consumer; // test 객체

    @MockBean
    private HelloConsumer helloConsumer;

    @Autowired
    public HelloProducerTest(HelloProducer producer, HelloTestConsumer consumer) {
        this.producer = producer;
        this.consumer = consumer;
    }

    @Test
    public void testSendMsg() {
        consumer.clear();

        HelloRequest request = new HelloRequest();
        request.setName("symplesims");
        request.setGreeting("Hello");
        producer.sendMsg(request);

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
        Assertions.assertEquals(request, consumer.getHolder().get(0));
    }


}
