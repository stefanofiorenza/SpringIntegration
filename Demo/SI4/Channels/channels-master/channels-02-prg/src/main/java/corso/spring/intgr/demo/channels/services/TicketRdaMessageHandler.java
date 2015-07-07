package corso.spring.intgr.demo.channels.services;

import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

import corso.spring.intgr.demo.channels.model.TicketRDA;

public class TicketRdaMessageHandler implements MessageHandler{

	private static Logger logger = Logger.getLogger(TicketRdaMessageHandler.class);
	private long delay;
	
	
	@Override
	public void handleMessage(Message<?> message) throws MessagingException {

		TicketRDA ticket= (TicketRDA)message.getPayload();
		logger.info("ricevuto Messaggio!: "+ticket);
		try {
			Random rnd = new Random();
			int delayRnd=rnd.nextInt((int)this.delay/1000);
			Thread.sleep((long)delayRnd*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("messaggio con ID: "+ticket.getId()+" processato con successo");	
	}
	
	public long getDelay() {
		return delay;
	}

	public void setDelay(long delay) {
		this.delay = delay;
	}

}
