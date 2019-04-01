package corso.spring.intgr.channels.demo.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.ExecutorChannel;
import org.springframework.integration.channel.PriorityChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.channel.RendezvousChannel;

import corso.spring.intgr.channels.demo.helpers.PriorityComparator;
import corso.spring.intgr.channels.demo.services.TicketRdaConsumerEventDriven;
import corso.spring.intgr.channels.demo.services.TicketRdaConsumerPolling;
import corso.spring.intgr.channels.demo.services.TicketRdaMessageHandler;
import corso.spring.intgr.channels.demo.services.TicketRdaProducer;

@Configuration
public class SI100ChannelsConfig {


	
	@Bean
	public TicketRdaProducer ticketProducer(){
		TicketRdaProducer producer = new TicketRdaProducer();
		producer.setDelay(SI100DemoConsts.producerDelay);			
		return producer;
	}
	
	@Bean
	public TicketRdaConsumerPolling ticketRdaConsumerPolling(){
		TicketRdaConsumerPolling consumer=new TicketRdaConsumerPolling();
		consumer.setDelay(SI100DemoConsts.consumerDelay);		
		return consumer;
	}
	
	@Bean
	public TicketRdaConsumerEventDriven ticketRdaConsumerEventDriven(){		
		TicketRdaConsumerEventDriven consumer=new TicketRdaConsumerEventDriven();		
		consumer.setMessageHandler(messageHandler());
		return consumer;
	}
	
	@Bean
	@Qualifier("messageHandler")
	public TicketRdaMessageHandler messageHandler(){
		TicketRdaMessageHandler messageHandler= new TicketRdaMessageHandler();
		messageHandler.setDelay(SI100DemoConsts.consumerDelay);
		return messageHandler;
	}
		
	@Bean
	@Qualifier("directChannel")
	public DirectChannel directChannel(){
		return new DirectChannel();
	}
	
	@Bean
	@Qualifier("queueChannel")
	public QueueChannel queueChannel(){
		return new QueueChannel();
	}
	
	@Bean	
	@Qualifier("priorityChannel")
	public PriorityChannel priorityChannel(){
		return  new PriorityChannel(new PriorityComparator());	
	}
	
	@Bean
	@Qualifier("rendezvousChannel")
	public RendezvousChannel rendezvousChannel(){
		return new RendezvousChannel();		
	}
	
	@Bean
	@Qualifier("executorChannel")
	public ExecutorChannel executorChannel(){
		ExecutorService executorService = Executors.newFixedThreadPool(SI100DemoConsts.threadPoolSize);
		ExecutorChannel executorChannel= new ExecutorChannel(executorService);
		return executorChannel;
	}
	
	
	@Bean
	@Qualifier("publishSubscribeChannel")
	public PublishSubscribeChannel publishSubscribeChannel(){
			/** From docs: will invoke the handlers in the message sender's thread. */
			return new PublishSubscribeChannel();		
	}
}
