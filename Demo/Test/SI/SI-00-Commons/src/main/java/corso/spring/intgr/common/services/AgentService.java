package corso.spring.intgr.common.services;

import java.util.List;

import corso.spring.intgr.common.beans.Order;

public interface AgentService {

	List<Order> createOrders(int quantity);
	
	
}
