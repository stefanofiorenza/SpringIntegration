package corso.spring.intgr.channels.demo.threads;

import lombok.extern.slf4j.Slf4j;
import corso.spring.intgr.channels.demo.services.TicketRdaConsumerPolling;

@Slf4j
public class PollingConsumerThread implements Runnable{

	
	private TicketRdaConsumerPolling poller;
	
	public PollingConsumerThread(TicketRdaConsumerPolling poller){
		this.poller=poller;
	}
	
	@Override
	public void run() {		
		
		long start = System.currentTimeMillis();
		
		poller.consumeAllMessages();
		
		long end = System.currentTimeMillis();
		double tempoTrascorso=(double)(end-start)/1000;
		log.info("\n\nConsumer terminato in "+tempoTrascorso+" secondi\n");
	}

}
