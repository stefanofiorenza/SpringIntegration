package corso.spring.intgr.demo.channels.services;

import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.SubscribableChannel;



public class TicketRdaConsumerEventDriven {

	private MessageChannel inputChannel;
	private MessageHandler messageHandler;	
	
	
	public MessageHandler getMessageHandler() {
		return messageHandler;
	}

	public void setMessageHandler(MessageHandler messageHandler) {
		this.messageHandler = messageHandler;	
	}
	
	public MessageChannel getInputChannel() {
		return inputChannel;
	}

	public void setInputChannel(MessageChannel inputChannel) {
		this.inputChannel = inputChannel;
		SubscribableChannel innerChannel =(SubscribableChannel)this.inputChannel ;
		innerChannel.subscribe(this.messageHandler);
	}
	
}
