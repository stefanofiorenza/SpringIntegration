package corso.spring.intgr.channels.demo.services;

import java.util.Random;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import org.apache.log4j.Logger;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import corso.spring.intgr.channels.demo.helpers.TicketRDAMockGenerator;
import corso.spring.intgr.channels.demo.model.TicketRDA;


@Slf4j
public class TicketRdaProducer {

	
	@Getter
	@Setter
	private MessageChannel outputChannel;
	

	@Getter
	@Setter
	private long delay;
	

	
	public void sendMessageOnChannel(int quantiMessaggi){
		
		for (int i=0; i<quantiMessaggi; i++){
			TicketRDA ticket=TicketRDAMockGenerator.createTicket();
			try {
				Random rnd = new Random();
				int delayRnd=rnd.nextInt((int)this.delay);
				Thread.sleep((long)delayRnd);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			log.info("invio messaggio con TicketID: "+ticket.getId()+"..");
			outputChannel.send(MessageBuilder.withPayload(ticket).build());
			log.info("inviato messaggio con TicketID: "+ticket.getId());
		}
		
	}
}
