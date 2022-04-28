package demo.example.app.producer;

import demo.example.app.message.HelloRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class HelloTestConsumer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ReentrantLock mutex = new ReentrantLock();

    private final List<HelloRequest> holder = new LinkedList();

    public void clear() {
        this.holder.clear();
    }

    public List<HelloRequest> getHolder() {
        return holder;
    }

    @JmsListener(destination = "${spring.jms.template.default-destination}")
    public void receiveMessage(HelloRequest message) {
        try {
            mutex.lock();
            this.holder.add(message);
            logger.info("Received message: {}, size: {}", message, this.holder.size());
        } finally {
            mutex.unlock();
        }
    }

}
