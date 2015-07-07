package corso.spring.integration.stocks.endpoints;

import org.springframework.stereotype.Component;

import corso.spring.integration.stocks.model.MarketItem;

@Component
public class MarketItemsRouter {

	public String route(MarketItem item) {
		System.out.println("*[MarketItemsRouter]: ricevuto nuovo: "+item.getType());
		String channelId = item.getType();
		return channelId;
	}
}
