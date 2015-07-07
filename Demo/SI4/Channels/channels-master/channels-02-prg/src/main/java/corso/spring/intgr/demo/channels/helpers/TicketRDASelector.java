package corso.spring.intgr.demo.channels.helpers;


import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;

import corso.spring.intgr.demo.channels.model.TicketRDA;

public class TicketRDASelector implements MessageSelector{

	@Override
	public boolean accept(Message<?> message) {
		TicketRDA ticket=(TicketRDA)message.getPayload();
		if(ticket.getPriority().getNumero()<3){
			return false;
		}else{
			return true;
		}		
	}

}
