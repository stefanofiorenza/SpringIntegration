package corso.spring.integration.stocks.endpoints;

import org.springframework.stereotype.Component;

import corso.spring.integration.stocks.model.MarketItem;

public interface MarketItemSystemGateway {

	public void dispatchMarketItem(MarketItem item);

}
