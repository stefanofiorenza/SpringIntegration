package corso.spring.intgr.channels.demo.services;

import java.util.Random;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

import corso.spring.intgr.channels.demo.model.TicketRDA;

@Slf4j
public class TicketRdaMessageHandler implements MessageHandler{


	@Getter
	@Setter
	private long delay;
	
	@Getter
	private int messageConsumed;
	
	@Override
	public void handleMessage(Message<?> message) throws MessagingException {

		TicketRDA ticket= (TicketRDA)message.getPayload();
		log.info("ricevuto Messaggio!: "+ticket);
		try {
			Random rnd = new Random();
			int delayRnd=rnd.nextInt((int)this.delay);
			Thread.sleep((long)delayRnd);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		messageConsumed++;
		log.info("messaggio con ID: "+ticket.getId()+" processato con successo");	
	}
	


}
