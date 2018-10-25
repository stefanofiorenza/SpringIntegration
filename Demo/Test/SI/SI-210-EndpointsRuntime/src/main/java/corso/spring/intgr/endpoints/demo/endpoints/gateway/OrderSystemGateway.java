package corso.spring.intgr.endpoints.demo.endpoints.gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import corso.spring.intgr.common.beans.Order;

@MessagingGateway(name = "orderSystemGateway", defaultRequestChannel = "orderMainInputChannel")
public interface OrderSystemGateway {

	@Gateway
	public void dispatchOrder(Order item);

}
