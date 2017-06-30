package corso.spring.intgr.endpoints.demo.services.gateway;

import corso.spring.intgr.common.beans.Order;

public interface OrderSystemGateway {

	public void dispatchOrder(Order item);

}
