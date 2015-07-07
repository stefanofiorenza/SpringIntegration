package corso.spring.integration.stocks.endpoints;

import org.springframework.stereotype.Component;

import corso.spring.integration.stocks.model.MarketItem;

@Component
public class StockService {

	
	public void executeStockLogic(MarketItem marketItem){
		
		System.out.println("******[StockService]: processa "+marketItem);
		System.out.println("*******FINE ELABORAZIONE*******");		
	
	}
}
