package corso.spring.intgr.common.services;

import corso.spring.intgr.common.beans.Order;
import corso.spring.intgr.common.beans.OrderOutcome;

public interface OrderService {

	OrderOutcome processOrder(Order order);
}
