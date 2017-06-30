package corso.spring.intgr.endpoints.demo.endpoints.gateway;

import corso.spring.intgr.common.beans.Order;

//@MessagingGateway(name = "cargoGateway", defaultRequestChannel = "cargoGWDefaultRequestChannel")
public interface OrderSystemGateway {

	//@Gateway
	public void dispatchOrder(Order item);

}
