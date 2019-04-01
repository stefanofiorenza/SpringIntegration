package corso.spring.intgr.channels.demo.services;

import lombok.Getter;
import lombok.Setter;

import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.SubscribableChannel;



public class TicketRdaConsumerEventDriven {

	@Getter
	private MessageChannel inputChannel;
	
	@Getter
	@Setter
	private MessageHandler messageHandler;	
	
	
	public void setInputChannel(MessageChannel inputChannel) {
		this.inputChannel = inputChannel;
		SubscribableChannel innerChannel =(SubscribableChannel)this.inputChannel ;
		innerChannel.subscribe(this.messageHandler);
	}
	
}
