package corso.spring.intgr.endpoints.demo.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;

import corso.spring.intgr.common.beans.Order;
import corso.spring.intgr.endpoints.demo.services.StockProcessor;

@MessageEndpoint
public class StockProcessorInt {

	
	@Autowired
	private StockProcessor stockProcessor;
	
	@Transformer(inputChannel="routerToStockChannel",outputChannel="trasformerStocksChannel")
	public Order processStockMessage(Order order){	
		return stockProcessor.processStockMessage(order);
	}
}
