package corso.spring.intgr.common.services;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import corso.spring.intgr.common.beans.Order;
import corso.spring.intgr.common.beans.OrderOutcome;
import corso.spring.intgr.common.utils.OrderUtils;


@Service("orderService")
@Slf4j
public class OrderServiceImpl implements OrderService{

	@Override
	public OrderOutcome processOrder(Order order) {
		log.info("Processing Order#{} ", order.getOrderId());
		OrderOutcome outcome= OrderUtils.evaluateOrder(order);	
		log.info("Processed Order#{}. Result is Outcome with Status: {}", order.getOrderId(), outcome.getStatus());
		return outcome;
	}
	
	
	

}
