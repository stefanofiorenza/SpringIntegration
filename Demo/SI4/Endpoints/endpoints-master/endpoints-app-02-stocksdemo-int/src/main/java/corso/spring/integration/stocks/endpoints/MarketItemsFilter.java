package corso.spring.integration.stocks.endpoints;

import org.springframework.stereotype.Component;

import corso.spring.integration.stocks.model.MarketItem;

@Component
public class MarketItemsFilter {

	public static int scartati=0;
	public static int processati=0;
	
	public boolean filterMarketItems(MarketItem marketItem){
		System.out.println("\n\n*****************************************");
		System.out.println("[MarketItemsFilter]: "+marketItem);
		if(marketItem.getPrice()<300){
			System.out.println("[MarketItemsFilter]: "+marketItem.getPrice()+" verra scartato!!");
			scartati++;
			System.out.println("[MarketItemsFilter]: scartati: "+scartati);
			System.out.println("*******FINE ELABORAZIONE*******");		
			return false;
		}else{
			processati++;
			return true;
		}
		
	}
}
