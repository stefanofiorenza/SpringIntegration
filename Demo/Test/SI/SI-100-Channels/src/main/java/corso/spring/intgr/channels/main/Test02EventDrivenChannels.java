package corso.spring.intgr.channels.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.ExecutorChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.MessageChannel;

import corso.spring.intgr.channels.demo.services.TicketRdaConsumerEventDriven;
import corso.spring.intgr.channels.demo.services.TicketRdaMessageHandler;
import corso.spring.intgr.channels.demo.services.TicketRdaProducer;
import corso.spring.intgr.channels.demo.threads.PerformanceLogger;
import corso.spring.intgr.channels.demo.threads.ProducerThread;

@Slf4j
public class Test02EventDrivenChannels {

	private static Logger logger = Logger.getLogger(Test02EventDrivenChannels.class);
	
	public static void main(String[] args) {

				
		// DEMO CONFIG:
		//********************************************************************************
		int quantiMessaggi=50;
		long producerDelay=100L;
		long consumerDelay=6000L;
		MessageChannel messageChannel = getPublishSubscribeChannel();
		//********************************************************************************
		
	
		
		//ESECUZIONE
		//********************************************************************************
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:corso/spring/intgr/demo/channels/config/channels-110-basics.xml");
		context.start();
		
		TicketRdaProducer producer = context.getBean(TicketRdaProducer.class);
		producer.setDelay(producerDelay);
		producer.setOutputChannel(messageChannel);
		
		TicketRdaConsumerEventDriven consumer=context.getBean(TicketRdaConsumerEventDriven.class);
		TicketRdaMessageHandler messageHandler= new TicketRdaMessageHandler();
		messageHandler.setDelay(consumerDelay);
		consumer.setMessageHandler(messageHandler);
		consumer.setInputChannel(messageChannel);		
		
		ProducerThread producerRunnable = new ProducerThread(producer, quantiMessaggi);
		Thread threadProducer= new Thread(producerRunnable);
		threadProducer.start();
		//********************************************************************************
		
		logger.info("Conclusione demo");
	}
	
		
	private static DirectChannel getDirectChannel(){
		return new DirectChannel();
	}
	
	private static ExecutorChannel getExecutorChannel(){
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		ExecutorChannel executorChannel= new ExecutorChannel(executorService);
		return executorChannel;
	}
	
	
	
	private static PublishSubscribeChannel getPublishSubscribeChannel(){
			return new PublishSubscribeChannel();		
	}
	
	
	private static void addPerformanceLogger(){
		
		//PERFORMANCES MEASURE:
		//********************************************************************************
//		Long startExecution= System.currentTimeMillis();
//		PerformanceLogger loggerJvm= new PerformanceLogger(startExecution);
//		Thread threadShutDown= new Thread(loggerJvm);
//		Runtime.getRuntime().addShutdownHook(threadShutDown);
		
		/*
		FutureTask<Long> task =new FutureTask<Long>(listenerJvm);
		
		Thread threadShutDown= new Thread(task);
		Runtime.getRuntime().addShutdownHook(threadShutDown);
		Long endExecution=0L;
		try {
			endExecution = task.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		double totalExecutionTimeInSeconds=(double)endExecution-startExecution/1000;
		*/
		//********************************************************************************
		
		
	}
	
	
}
