package corso.spring.integration.stocks.endpoints;

import org.springframework.stereotype.Component;

import corso.spring.integration.stocks.model.MarketItem;

@Component
public class StockProcessor {

	public MarketItem processStockMessage(MarketItem marketItem){
		System.out.print("***[StockProcessor]: price: "+marketItem.getPrice());
		double price=marketItem.getPrice();
		price=price-100.0;
		marketItem.setPrice(price);
		System.out.println(" ;new price "+marketItem.getPrice());
		return marketItem;
	}
}
