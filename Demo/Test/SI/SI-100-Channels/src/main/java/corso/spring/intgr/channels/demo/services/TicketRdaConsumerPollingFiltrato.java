package corso.spring.intgr.channels.demo.services;

import java.util.List;
import java.util.Random;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import org.apache.log4j.Logger;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import corso.spring.intgr.channels.demo.model.TicketRDA;

@Slf4j
public class TicketRdaConsumerPollingFiltrato {


	public static final long RECEIVING_TIMEOUT = 1000L;
	
	@Getter
	@Setter
	private QueueChannel inputChannel;
	
	@Getter
	@Setter
	private long delay;
	
	@Getter
	@Setter
	private MessageSelector messageSelector;
	
		
	
	public void consumeMessage(){
		
		while(true){ //esce per timeout quando non ci sono piu messaggi
			List<Message<?>> messages=this.inputChannel.purge(this.messageSelector);
			for (Message<?> messaggio : messages){
				if(messaggio==null) break;
				TicketRDA ticket= (TicketRDA)messaggio.getPayload();
				try {
					Random rnd = new Random();
					int delayRnd=rnd.nextInt((int)this.delay/1000);
					Thread.sleep((long)delayRnd*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				log.info("ricevuto Messaggio!: "+ticket);
			}
			

		}
	}
}
