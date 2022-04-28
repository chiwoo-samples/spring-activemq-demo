package demo.example.app.consumer;

import demo.example.app.message.HelloRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class HelloConsumer {

    private static final Logger logger = LoggerFactory.getLogger(HelloConsumer.class);

    @JmsListener(destination = "${spring.jms.template.default-destination}")
    public void receiveMessage(HelloRequest message) {
        logger.info("Received: {}", message);
    }
}
