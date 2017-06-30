package corso.spring.intgr.endpoints.demo.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import corso.spring.intgr.common.beans.Order;
import corso.spring.intgr.endpoints.demo.services.BondService;
import corso.spring.intgr.endpoints.demo.services.StockService;

@MessageEndpoint
public class StockServiceInt {

	
	@Autowired
	private StockService stockService;
	
	@ServiceActivator(inputChannel = "trasformerStocksChannel")
	public void executeStockLogic(Order order){
		stockService.executeStockLogic(order);	
	}
}
