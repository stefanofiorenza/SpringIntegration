package corso.spring.integration.stocks.endpoints;

import org.springframework.stereotype.Component;

import corso.spring.integration.stocks.model.MarketItem;

@Component
public class BondService {

	
	public void executeBondLogic(MarketItem marketItem){
		
		System.out.println("******[BondService]: processa "+marketItem);
		System.out.println("*******FINE ELABORAZIONE*******");		
		
	}
}
