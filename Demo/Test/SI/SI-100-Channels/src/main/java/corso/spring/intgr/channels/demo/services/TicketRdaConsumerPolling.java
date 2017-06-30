package corso.spring.intgr.channels.demo.services;

import java.util.Random;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import org.apache.log4j.Logger;
import org.springframework.integration.channel.AbstractPollableChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import corso.spring.intgr.channels.demo.model.TicketRDA;

@Slf4j
public class TicketRdaConsumerPolling {

	public static final long RECEIVING_TIMEOUT = 1000L;
	
	@Setter
	@Getter
	private AbstractPollableChannel inputChannel;
	
	@Setter
	@Getter
	private long delay;
	
	
	
	
	public void consumeAllMessages(){
		
		while(true){ 
			
			if(!consumeSingleMessage()){
				break;				
			}
			
			applyRandomDelay();
			
			
		}
	}
	
	public boolean consumeSingleMessage(){
		
		//Quando quando non ci sono piu messaggi va in timeout e restituisce null
		Message<TicketRDA> messaggio=(Message<TicketRDA>)this.inputChannel.receive(RECEIVING_TIMEOUT);
		
		if(messaggio!=null) {
			TicketRDA ticket= messaggio.getPayload();
			log.info("ricevuto Messaggio!: "+ticket);
			return true;
		}
		
		return false;		
	}
	
	private void applyRandomDelay(){
		try {
			Random rnd = new Random();
			int delayRnd=rnd.nextInt((int)this.delay/1000);
			Thread.sleep((long)delayRnd*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
