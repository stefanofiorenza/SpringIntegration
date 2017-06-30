package corso.spring.intgr.endpoints.demo.services;

import java.math.BigDecimal;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import corso.spring.intgr.common.beans.Order;

@Service("privateBondProcessor")
@Slf4j
public class PrivateBondProcessor {

	public Order processPrivateBondMessage(Order order){
		
		log.info("***[PrivateBondProcessor]: Starting price "+order.getPrice());
		BigDecimal newPrice=order.getPrice().add(new BigDecimal("200"));
		order.setPrice(newPrice);
		log.info("***[PrivateBondProcessor]: new price "+order.getPrice());
		return order;
	}
}
