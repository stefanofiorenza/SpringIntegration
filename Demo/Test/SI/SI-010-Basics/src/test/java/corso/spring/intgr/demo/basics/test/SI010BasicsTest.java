package corso.spring.intgr.demo.basics.test;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;

import corso.spring.intgr.demo.basics.config.SI010BasicsConfig;
import corso.spring.intgr.demo.basics.model.User;

@Slf4j
public class SI010BasicsTest {

	
	//@Test
	public void testBasicDemoXml(){
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SI-010-Basics.xml");
		context.start();
		testTemplate(context);
				
	}
	
	@Test
	public void testBasicDemoAnnotationsSI(){
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(SI010BasicsConfig.class);
		ctx.refresh();
		
		testTemplate(ctx);
		
	}
	
	
	private void testTemplate(ApplicationContext context){
		
		MessageChannel inputChannel = context.getBean("inputChannel",MessageChannel.class);
		PollableChannel outputChannel = context.getBean("outputChannel",PollableChannel.class);
		
		User nuovoUser = new User();
		nuovoUser.setNome("Stefano");
		nuovoUser.setCognome("Fiorenza");
		nuovoUser.setEmail("stefanofiorenza@email.com");
		nuovoUser.setTelefono("0612345678");
				
		inputChannel.send(new GenericMessage<User>(nuovoUser));
		User ricevuto = (User)outputChannel.receive(0).getPayload();
		log.info("==> Basic Demo: " + ricevuto);
	}
	

	
}
