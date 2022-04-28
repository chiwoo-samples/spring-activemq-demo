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
import java.util.stream.IntStream;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class HelloProducerBunchesTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private HelloProducer producer;

    private HelloTestConsumer consumer; // test 객체

    @MockBean
    private HelloConsumer helloConsumer;

    @Autowired
    public HelloProducerBunchesTest(HelloProducer producer, HelloTestConsumer consumer) {
        this.producer = producer;
        this.consumer = consumer;
    }

    @Test
    public void testSendMessages() {

        consumer.clear();
        final int LIMIT = 100;
        IntStream.range(1, LIMIT + 1).forEach(i -> {
            final HelloRequest request = new HelloRequest();
            request.setName("symplesims");
            request.setGreeting("Hello index: " + i);
            producer.sendMsg(request);
        });

        // consumer 에서 메시지를 다 수신한다는 보장이 없음, network 레이턴시에 의존적인 테스트 임
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }

        Assertions.assertEquals(LIMIT, consumer.getHolder().size());
    }


}
