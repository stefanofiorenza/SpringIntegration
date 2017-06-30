package corso.spring.intgr.endpoints.demo.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.MessageEndpoint;

import corso.spring.intgr.common.beans.Order;
import corso.spring.intgr.endpoints.demo.services.OrderFilter;

@MessageEndpoint
public class OrderFilterInt {

	@Autowired
	private OrderFilter orderFilter;
	
	@Filter(inputChannel="orderMainInputChannel",outputChannel="filteredOrdersChannel")
	public boolean filterMarketItems(Order order){
		return orderFilter.filterOrders(order);		
	}
}
