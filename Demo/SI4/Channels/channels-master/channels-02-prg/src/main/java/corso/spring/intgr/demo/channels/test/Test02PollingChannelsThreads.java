package corso.spring.intgr.demo.channels.test;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.AbstractPollableChannel;
import org.springframework.integration.channel.PriorityChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.channel.RendezvousChannel;
import org.springframework.messaging.MessageChannel;

import corso.spring.intgr.demo.channels.helpers.PriorityComparator;
import corso.spring.intgr.demo.channels.services.TicketRdaConsumerPolling;
import corso.spring.intgr.demo.channels.services.TicketRdaProducer;
import corso.spring.intgr.demo.channels.threads.PollingConsumerThread;
import corso.spring.intgr.demo.channels.threads.ProducerThread;


public class Test02PollingChannelsThreads {

	private static Logger logger = Logger.getLogger(Test02PollingChannelsThreads.class);
	
	public static void main(String[] args) {

		logger.info("Logger collegato");
		
		// DEMO CONFIG:
		//********************************************************************************
		int quantiMessaggi=5;
		long producerDelay=100L;
		long consumerDelay=3000L;
		MessageChannel messageChannel = getRendezvousChannel();
		//********************************************************************************
		
		
		
		
		//ESECUZIONE
		//********************************************************************************
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:corso/spring/intgr/demo/channels/config/channels-110-basics.xml");
		context.start();
		
		TicketRdaProducer producer = context.getBean(TicketRdaProducer.class);
		TicketRdaConsumerPolling consumer=context.getBean(TicketRdaConsumerPolling.class);
		
		producer.setDelay(producerDelay);
		producer.setOutputChannel(messageChannel);
		consumer.setInputChannel((AbstractPollableChannel)messageChannel);
		consumer.setDelay(consumerDelay);
		
		ProducerThread producerRunnable = new ProducerThread(producer, quantiMessaggi);
		PollingConsumerThread consumerRunnable = new PollingConsumerThread(consumer);
		Thread threadProducer= new Thread(producerRunnable);
		Thread threadConsumer= new Thread(consumerRunnable);
		threadProducer.start();
		threadConsumer.start();
		//********************************************************************************
		
		logger.info("Conclusione demo");
	}
	
	private static QueueChannel getQueueChannel(){
		QueueChannel queueChannel = new QueueChannel();
		return queueChannel;
	}
	
	private static PriorityChannel getPriorityChannel(){
		PriorityChannel priorityChannel= new PriorityChannel(new PriorityComparator());
		return priorityChannel;
	}
	
	private static RendezvousChannel getRendezvousChannel(){
		RendezvousChannel rendezvoudChannel = new RendezvousChannel();
		return rendezvoudChannel;
	}
	
	
}
