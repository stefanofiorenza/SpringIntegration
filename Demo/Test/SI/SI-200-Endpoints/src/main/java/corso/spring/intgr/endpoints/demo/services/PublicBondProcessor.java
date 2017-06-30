package corso.spring.intgr.endpoints.demo.services;

import java.math.BigDecimal;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import corso.spring.intgr.common.beans.Order;

@Service("publicBondProcessor")
@Slf4j
public class PublicBondProcessor {

	public Order processPublicBondMessage(Order order){
		
		log.info("***[PublicBondProcessor]: Starting price "+order.getPrice());
		BigDecimal newPrice=order.getPrice().subtract(new BigDecimal("100"));
		order.setPrice(newPrice);
		log.info("***[PublicBondProcessor]: new price "+order.getPrice());
		return order;
	}
}
