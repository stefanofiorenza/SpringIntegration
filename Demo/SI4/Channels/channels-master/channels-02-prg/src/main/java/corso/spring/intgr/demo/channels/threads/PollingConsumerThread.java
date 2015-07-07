package corso.spring.intgr.demo.channels.threads;

import corso.spring.intgr.demo.channels.services.TicketRdaConsumerPolling;

public class PollingConsumerThread implements Runnable{

	
	private TicketRdaConsumerPolling poller;
	
	public PollingConsumerThread(TicketRdaConsumerPolling poller){
		this.poller=poller;
	}
	
	@Override
	public void run() {
		poller.consumeMessage();		
	}

}
