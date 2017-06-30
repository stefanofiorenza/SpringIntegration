package corso.spring.intgr.endpoints.demo.services;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import corso.spring.intgr.common.beans.Order;

@Service("updateOrderService")
@Slf4j
public class UpdateOrderService {
	
	public void executeUpdateOrderLogic(Order order){		
		log.info("******[UpdateOrderService]: updated Order: "+order);
		log.info("*******FINE ELABORAZIONE*******");			
	}
}
