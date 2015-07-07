package corso.spring.integration.stocks.endpoints;

import org.springframework.stereotype.Component;

import corso.spring.integration.stocks.model.MarketItem;

@Component
public class BondProcessor {

	public MarketItem processBondMessage(MarketItem marketItem){
		System.out.print("***[BondProcessor]: price "+marketItem.getPrice());
		double price=marketItem.getPrice();
		price=price-100.0;
		marketItem.setPrice(price);
		System.out.println(" ;new price "+marketItem.getPrice());
		return marketItem;
	}
}
