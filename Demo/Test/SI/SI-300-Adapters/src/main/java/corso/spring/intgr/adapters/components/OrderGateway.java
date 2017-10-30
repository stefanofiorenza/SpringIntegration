package corso.spring.intgr.adapters.components;

import corso.spring.intgr.common.beans.Order;
import corso.spring.intgr.common.beans.OrderOutcome;

public interface OrderGateway {

	OrderOutcome processOrder(Order order);	
}
