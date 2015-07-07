package corso.spring.intgr.demo.channels.test;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.AbstractPollableChannel;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.MessageChannel;

import corso.spring.intgr.demo.channels.services.TicketRdaConsumerPolling;
import corso.spring.intgr.demo.channels.services.TicketRdaProducer;


public class Test01PollingChannels {

	private static Logger logger = Logger.getLogger(Test01PollingChannels.class);
	
	public static void main(String[] args) {

		logger.info("Logger collegato");
		
		// DEMO CONFIG:
		//********************************************************************************
		int quantiMessaggi=5;
		long producerDelay=100L;
		long consumerDelay=3000L;
		MessageChannel messageChannel = getQueueChannel();
		
		//********************************************************************************
	
		
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:corso/spring/intgr/demo/channels/config/channels-110-basics.xml");
		context.start();

		//Polling Channels:
		
		TicketRdaConsumerPolling consumer=context.getBean(TicketRdaConsumerPolling.class);
		consumer.setDelay(consumerDelay);
		consumer.setInputChannel((AbstractPollableChannel)messageChannel);
		
		
		TicketRdaProducer producer = context.getBean(TicketRdaProducer.class);
		producer.setDelay(producerDelay);
		producer.setOutputChannel(messageChannel);
		producer.sendMessageOnChannel(10);
		
		consumer.consumeMessage();
		logger.info("Conclusione demo");
	}
	
	private static DirectChannel getDirectChannel(){
		DirectChannel directChannel = new DirectChannel();
		return directChannel;
	}
	
	
	
	private static QueueChannel getQueueChannel(){
		QueueChannel queueChannel = new QueueChannel();
		return queueChannel;
	}

}
