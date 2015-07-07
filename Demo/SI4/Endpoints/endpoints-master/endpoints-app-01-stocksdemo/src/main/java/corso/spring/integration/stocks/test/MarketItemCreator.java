package corso.spring.integration.stocks.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import corso.spring.integration.stocks.model.MarketItem;



public class MarketItemCreator {

	private static int FACTOR=800;
	private static double LESS=4.5;
	
	public static List<MarketItem> getMarketItems(int quanti) {
		List<MarketItem> marketItems = new ArrayList<MarketItem>();
		
		for (int i=0; i<quanti; i++){
			MarketItem marketItem=null;
			if(i%2==0){
				marketItem=createMockMarketItem("IBM","International Business Machines","stock");
			}else{
				marketItem=createMockMarketItem("BOT","Buoni Ordinari Tesoro","bond");
			}
			 
			marketItems.add(marketItem);
		}		
		return marketItems;
	}
	
	
	private static MarketItem createMockMarketItem(String simbol,String descrizione,String type ){
		MarketItem marketItem = new MarketItem();
		marketItem.setSymbol(simbol);
		marketItem.setDescription(descrizione);
		Random random= new Random();
		double openPrice=random.nextDouble()*FACTOR;
		double price=openPrice-(openPrice*LESS/100);
		marketItem.setOpenPrice(openPrice);
		marketItem.setPrice(price);
		marketItem.setType(type);
		return marketItem;		
	}
	

}
