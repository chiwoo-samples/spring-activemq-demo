package demo.example.app;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.jupiter.api.Test;
import org.messaginghub.pooled.jms.JmsPoolConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringActivemqDemoApplicationTests {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

//	@Autowired
//	private ActiveMQConnectionFactory jmsConnectionFactory;

	@Autowired
	private JmsPoolConnectionFactory jmsConnectionFactory;

	@Test
	void contextLoads() {
		final Object object = jmsConnectionFactory.getConnectionFactory();
		if (object instanceof ActiveMQConnectionFactory) {
			ActiveMQConnectionFactory factory=  (ActiveMQConnectionFactory) object;
			logger.info("factory.isUseAsyncSend(): {}", factory.isUseAsyncSend());
		}
		logger.info("jmsConnectionFactory.isUseAsyncSend(): {}", jmsConnectionFactory.getConnectionFactory().getClass());
	}


}
