package corso.spring.intgr.demo.channels.services;

import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import corso.spring.intgr.demo.channels.helpers.TicketRDAHelper;
import corso.spring.intgr.demo.channels.model.TicketRDA;


public class TicketRdaProducer {

	private MessageChannel outputChannel;
	private static Logger logger = Logger.getLogger(TicketRdaProducer.class);
	private long delay;
	
	public long getDelay() {
		return delay;
	}

	public void setDelay(long delay) {
		this.delay = delay;
	}

	public MessageChannel getOutputChannel() {
		return outputChannel;
	}

	public void setOutputChannel(MessageChannel inputChannel) {
		this.outputChannel = inputChannel;
	}
	
	public void sendMessageOnChannel(int quantiMessaggi){
		
		for (int i=0; i<quantiMessaggi; i++){
			TicketRDA ticket=TicketRDAHelper.createTicket();
			try {
				Random rnd = new Random();
				int delayRnd=rnd.nextInt((int)this.delay);
				Thread.sleep((long)delayRnd);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			logger.info("invio messaggio con TicketID: "+ticket.getId()+"..");
			outputChannel.send(MessageBuilder.withPayload(ticket).build());
			logger.info("inviato messaggio con TicketID: "+ticket.getId());
		}
		
	}
}
