package corso.spring.intgr.common.utils;

import java.util.Date;

import corso.spring.intgr.common.beans.Order;
import corso.spring.intgr.common.beans.OrderOutcome;
import corso.spring.intgr.common.beans.OrderStatus;


public class OrderUtils {

	public static OrderOutcome evaluateOrder(Order order){
		OrderOutcome outcome = defaultOutcome(order);
		
		if(order.getQuantity()%7==0){ //mock criteria
			outcome.setAccepted(false);
			outcome.setRejectionReason("Stock Closed");
			outcome.setStatus(OrderStatus.REJECTED);
		}else{
			outcome.setAccepted(true);
			outcome.setStatus(OrderStatus.ACCEPTED);
		}	
		
		return outcome;
	}
	
	public static OrderOutcome defaultOutcome(Order order){
		OrderOutcome outcome = new OrderOutcome();
		outcome.setOrderDate(new Date());
		outcome.setOrderId(order.getOrderId());
		outcome.setStockAgentId(order.getStockAgentId());
		outcome.setStockAgentName(order.getStockAgentName());	
		outcome.setAccepted(false);
		outcome.setStatus(OrderStatus.REJECTED);		
		return outcome;
	}
}
