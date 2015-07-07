package corso.spring.integration.stocks.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import corso.spring.integration.stocks.model.MarketItem;

public class TestStocks01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context =new ClassPathXmlApplicationContext("corso/spring/integration/stocks/config/stocks-integration-context.xml");
			MessageChannel channel =
			context.getBean("marketItemChannel", MessageChannel.class);
			List<MarketItem> marketItems =MarketItemCreator.getMarketItems(10);
			for (MarketItem marketItem : marketItems) {
				channel.send(MessageBuilder.withPayload(marketItem).build());
			}

	}

}
