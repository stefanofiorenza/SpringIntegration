package corso.spring.intgr.endpoints.demo.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;

import corso.spring.intgr.common.beans.Order;
import corso.spring.intgr.endpoints.demo.services.OrderRouter;

@MessageEndpoint
public class OrderRouterInt {

	@Autowired
	private OrderRouter orderRouter;
		
	@Router(inputChannel="filteredOrdersChannel")
	public String route(Order item) {
		return orderRouter.route(item);
	}
}
