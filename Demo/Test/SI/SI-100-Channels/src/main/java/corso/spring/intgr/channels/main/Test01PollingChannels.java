package corso.spring.intgr.channels.main;

import lombok.extern.slf4j.Slf4j;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.AbstractPollableChannel;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.MessageChannel;

import corso.spring.intgr.channels.demo.config.SI100ChannelsConfig;
import corso.spring.intgr.channels.demo.services.TicketRdaConsumerEventDriven;
import corso.spring.intgr.channels.demo.services.TicketRdaConsumerPolling;
import corso.spring.intgr.channels.demo.services.TicketRdaProducer;
import corso.spring.intgr.channels.demo.threads.PerformanceLogger;
import corso.spring.intgr.channels.demo.threads.PollingConsumerThread;
import corso.spring.intgr.channels.demo.threads.ProducerThread;

@Slf4j
public class Test01PollingChannels {

	//private static Logger logger = Logger.getLogger(Test01PollingChannels.class);
	
	
	private static TicketRdaConsumerPolling consumerPolling;
	private static TicketRdaProducer producer;
	private static TicketRdaConsumerEventDriven consumerEventDriven;
	
	private static AnnotationConfigApplicationContext ctx;
	
	private static final int qoMessaggi=10;
	
	public static void main(String[] args) {

		
		 //runPollingTestTemplateSingleThread();
		 
		//runPollingTestTemplateMultiThread("queueChannel");
		//runPollingTestTemplateMultiThread("priorityChannel");
		//runPollingTestTemplateMultiThread("rendezvousChannel");
		
		
		runEventDrivenTestTemplateMultiThread("publishSubscribeChannel");
		//runEventDrivenTestTemplateMultiThread("executorChannel");
	
	}
	
	private static void runPollingTestTemplateSingleThread(){
		
		setup("queueChannel",false);		
		
		producer.sendMessageOnChannel(qoMessaggi);		
		
		//Poll and consume one by one
		consumerPolling.consumeSingleMessage();
		consumerPolling.consumeSingleMessage();
		consumerPolling.consumeSingleMessage();
		
		//consumer.consumeAllMessages();
		
		log.info("Conclusione demo");
	}
	
	
	
	private static void runPollingTestTemplateMultiThread(String channelQualifier){		
		
		setup(channelQualifier,false);		
		startProducerThread();
		startConsumerThread();
	
	}
	
	
	private static void runEventDrivenTestTemplateMultiThread(String channelQualifier){
		setup(channelQualifier,true);
		addPerformanceLogger();
		startProducerThread();		
		
	}

	
	
	private static void setup(String channelQualifier, boolean eventDriven){
		
		ctx = new AnnotationConfigApplicationContext();
		ctx.register(SI100ChannelsConfig.class);
		ctx.refresh();
		
		MessageChannel messageChannel=(MessageChannel)ctx.getBean(channelQualifier);	
		
		if(eventDriven){
			consumerEventDriven=ctx.getBean(TicketRdaConsumerEventDriven.class);	
			consumerEventDriven.setInputChannel(messageChannel);
			
		}else{
			consumerPolling=ctx.getBean(TicketRdaConsumerPolling.class);	
			consumerPolling.setInputChannel((AbstractPollableChannel)messageChannel);
		}
			
		producer = ctx.getBean(TicketRdaProducer.class);	
		producer.setOutputChannel(messageChannel);
	}

	
	private static void startProducerThread(){
		Runnable producerRunnable = new ProducerThread(producer, qoMessaggi);		
		Thread threadProducer= new Thread(producerRunnable);
		threadProducer.start();
	}
	
	private static void startConsumerThread(){
		
		Runnable consumerRunnable = new PollingConsumerThread(consumerPolling);		
		Thread threadConsumer= new Thread(consumerRunnable);		
		threadConsumer.start();	
	}
	
	private static void addPerformanceLogger(){
			
			
			//1) Thread per statistiche inizializzato sul tempo corrente		
			PerformanceLogger loggerJvm= new PerformanceLogger();	
			
			
			//2) PerformanceLogger (Runnable) inserito in un Thread che andra in run alla chiusura della JVM
			Thread threadShutDownHook= new Thread(loggerJvm);
			
			//3) Il Thread di 2) viene registrato tra gli shutDown Hooks Thread. 
			//  Vedi docs per maggiori dettagli
			Runtime.getRuntime().addShutdownHook(threadShutDownHook);
	}
}
