package corso.spring.intgr.endpoints.demo.endpoints;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import corso.spring.intgr.common.beans.Order;

@MessagingGateway(name = "orderMainGateway", 
	defaultRequestChannel = "orderMainInputChannel")
public interface OrderGatewayI {

	@Gateway
	public void dispatchOrder(Order order);
}
