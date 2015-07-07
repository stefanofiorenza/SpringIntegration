package corso.spring.integration.stocks.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import corso.spring.integration.stocks.endpoints.MarketItemSystemGateway;
import corso.spring.integration.stocks.model.MarketItem;

public class TestStocks02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context =new ClassPathXmlApplicationContext("corso/spring/integration/stocks/config/stocks-integration-context.xml");
		
		//1) applicazione non "vede" api Spring Integration:
			/*
			MessageChannel channel =context.getBean("marketItemChannel", MessageChannel.class);
			*/
		
		//2) Uso interfaccia Gateway (da configurazione marco il metodo come input-channel del bus)
		// che maschera conversione MarketItem in Message<MarketItem> ed inoltro su bus
		
		MarketItemSystemGateway serviceGateway=context.getBean("myMarketItemSystemGateway", MarketItemSystemGateway.class);
		List<MarketItem> marketItems =MarketItemCreator.getMarketItems(10);
			
		for (MarketItem marketItem : marketItems) {
			serviceGateway.dispatchMarketItem(marketItem);
			//channel.send(MessageBuilder.withPayload(marketItem).build());
		}
		
		

	}

}
