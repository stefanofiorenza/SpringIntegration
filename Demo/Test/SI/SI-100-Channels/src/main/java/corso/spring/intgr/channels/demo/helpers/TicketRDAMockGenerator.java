package corso.spring.intgr.channels.demo.helpers;

import java.util.Date;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;

import org.apache.log4j.Logger;

import corso.spring.intgr.channels.demo.model.TicketRDA;

@Slf4j
public class TicketRDAMockGenerator {

	private static final int PRIORITY_LOW=0;
	private static final int PRIORITY_MEDIUM=1;
	private static final int PRIORITY_HIGH=2;
	private static final int PRIORITY_EMERGENCY=3;	
		
	public static int contatore=0;
	
	public static TicketRDA createTicket() {
		contatore++;
		TicketRDA nuovoTicket = new TicketRDA();
		nuovoTicket.setId(new Long(contatore));
		nuovoTicket.setDescrizioneProblema("problema "+contatore);
		nuovoTicket.setDataAcquisto(getDataAcquistoCasuale());
		nuovoTicket.setModello("Asus "+contatore);
		nuovoTicket.setNumeroDocumentoAcquisto("ADBN34234"+contatore+"23"+contatore+"435"+contatore);
		nuovoTicket.setNumeroMatricola("1234242"+contatore);
		nuovoTicket.setPriority(getPriorityCasuale());	
		log.debug("[TicketRDAHelper]: produce Ticket: "+nuovoTicket.toString());
		return nuovoTicket;
	}
	
private static TicketRDA.Priority getPriorityCasuale(){
		
		TicketRDA.Priority priorita=null;
		
		Random rnd = new Random();
		int prioritaCasualeInt =rnd.nextInt(4); //numero da zero a tre
		
		switch (prioritaCasualeInt){		
			case PRIORITY_LOW: priorita=TicketRDA.Priority.low;break;
			case PRIORITY_MEDIUM: priorita=TicketRDA.Priority.medium;break;
			case PRIORITY_HIGH: priorita=TicketRDA.Priority.high;break;
			case PRIORITY_EMERGENCY: priorita=TicketRDA.Priority.emergency;break;			
		}
		
		return priorita;
	} 
	
	private static Date getDataAcquistoCasuale(){
		
		Random rnd = new Random();
		int giornoCasuale =rnd.nextInt(28); 
		int meseCasuale=rnd.nextInt(11);
		
		// per considerare anche i valori zero
		giornoCasuale++;
		meseCasuale++;
		
		// anno acquisto sempre 2010..
		return new Date(110,meseCasuale,giornoCasuale);
		
	}
}
