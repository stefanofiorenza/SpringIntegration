package corso.spring.intgr.channels.demo.helpers;

import java.util.Comparator;



import org.springframework.messaging.Message;

import corso.spring.intgr.channels.demo.model.TicketRDA;

public class PriorityComparator implements Comparator<Message<?>>{

	@Override
	public int compare(Message<?> primo, Message<?> secondo) {

		int numeroPrioritaPrimo=((TicketRDA)primo.getPayload()).getPriority().getNumero();
		int numeroPrioritaSecondo=((TicketRDA)secondo.getPayload()).getPriority().getNumero();
			
		if (numeroPrioritaPrimo==numeroPrioritaSecondo){
			return 0;
		}else if (numeroPrioritaPrimo>numeroPrioritaSecondo){
			
			return -1;
		}else{
			return 1;
		}
		
	}

}
