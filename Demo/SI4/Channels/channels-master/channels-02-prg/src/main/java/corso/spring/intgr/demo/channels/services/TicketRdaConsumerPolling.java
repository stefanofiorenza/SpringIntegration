package corso.spring.intgr.demo.channels.services;

import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.integration.channel.AbstractPollableChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import corso.spring.intgr.demo.channels.model.TicketRDA;

public class TicketRdaConsumerPolling {

	public static final long RECEIVING_TIMEOUT = 1000L;
	private AbstractPollableChannel inputChannel;
	private static Logger logger = Logger.getLogger(TicketRdaConsumerPolling.class);
	private long delay;
	
	public long getDelay() {
		return delay;
	}

	public void setDelay(long delay) {
		this.delay = delay;
	}
	public MessageChannel getInputChannel() {
		return inputChannel;
	}

	public void setInputChannel(AbstractPollableChannel inputChannel) {
		this.inputChannel = inputChannel;
	}
	
	
	public void consumeMessage(){
		
		while(true){ //esce per timeout quando non ci sono piu messaggi
			Message<TicketRDA> messaggio=(Message<TicketRDA>)this.inputChannel.receive(RECEIVING_TIMEOUT);
			if(messaggio==null) break;
			TicketRDA ticket= messaggio.getPayload();
			try {
				Random rnd = new Random();
				int delayRnd=rnd.nextInt((int)this.delay/1000);
				Thread.sleep((long)delayRnd*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			logger.info("ricevuto Messaggio!: "+ticket);

		}
	}
}
