package corso.spring.intgr.demo.channels.services;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import corso.spring.intgr.demo.channels.model.TicketRDA;

public class TicketRdaConsumerPollingFiltrato {

	private static Logger logger = Logger.getLogger(TicketRdaConsumerPollingFiltrato.class);
	public static final long RECEIVING_TIMEOUT = 1000L;
	
	private QueueChannel inputChannel;
	private long delay;
	private MessageSelector messageSelector;
	
	public MessageSelector getMessageSelector() {
		return messageSelector;
	}

	public void setMessageSelector(MessageSelector messageSelector) {
		this.messageSelector = messageSelector;
	}

	public long getDelay() {
		return delay;
	}

	public void setDelay(long delay) {
		this.delay = delay;
	}
	public MessageChannel getInputChannel() {
		return inputChannel;
	}

	public void setInputChannel(QueueChannel inputChannel) {
		this.inputChannel = inputChannel;
	}
	
	
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
				logger.info("ricevuto Messaggio!: "+ticket);
			}
			

		}
	}
}
