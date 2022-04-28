package demo.example.app.producer;

import demo.example.app.message.HelloRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class HelloProducer {

    private static final Logger logger = LoggerFactory.getLogger(HelloProducer.class);

    private JmsTemplate jmsTemplate;

    public HelloProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMsg(HelloRequest request) {
        logger.info("msg: {}", request);
        jmsTemplate.convertAndSend(request);
        logger.info("Sending message to : {}", request);
    }
}
