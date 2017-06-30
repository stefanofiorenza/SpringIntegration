package corso.spring.intgr.channels.demo.threads;

import org.apache.log4j.Logger;

import corso.spring.intgr.channels.demo.services.TicketRdaProducer;

public class ProducerThread implements Runnable{

	private static Logger logger = Logger.getLogger(ProducerThread.class);
	
	private TicketRdaProducer producerService;
	private int quantiMessaggi;
	
	public ProducerThread (TicketRdaProducer producerService, int quantiMessaggi){
		this.producerService=producerService;
		this.quantiMessaggi=quantiMessaggi;
	}
	
	
	@Override
	public void run() {
		long start = System.currentTimeMillis();
		
		this.producerService.sendMessageOnChannel(this.quantiMessaggi);
		
		long end = System.currentTimeMillis();
		double tempoTrascorso=(double)(end-start)/1000;
		logger.info("\n\nProducer terminato in "+tempoTrascorso+" secondi\n");
	}

}
