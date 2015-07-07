package corso.spring.intgr.demo.basic.test;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.MessageChannel;
//import org.springframework.integration.core.PollableChannel;
//import org.springframework.integration.message.GenericMessage;

import corso.spring.intgr.demo.basic.model.User;

public class TestBasicDemo {

	
	private static Logger logger = Logger.getLogger(TestBasicDemo.class);
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		logger.info("Logger collegato");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:corso/spring/intgr/demo/basic/config/spring-integration-basic.xml");
		context.start();

		MessageChannel inputChannel = context.getBean("inputChannel",MessageChannel.class);
		PollableChannel outputChannel = context.getBean("outputChannel",PollableChannel.class);
		
		User nuovoUser = new User();
		nuovoUser.setNome("Stefano");
		nuovoUser.setCognome("Fiorenza");
		nuovoUser.setEmail("stefanofiorenza@email.com");
		nuovoUser.setTelefono("0612345678");
		
		
		inputChannel.send(new GenericMessage<User>(nuovoUser));
		User ricevuto = (User)outputChannel.receive(0).getPayload();
		logger.info("==> Basic Demo: " + ricevuto);		
		


	}

}
