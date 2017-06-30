package corso.spring.intgr.endpoints.demo.services;

import java.math.BigDecimal;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import corso.spring.intgr.common.beans.Order;

@Service("stockProcessor")
@Slf4j
public class StockProcessor {

	public Order processStockMessage(Order order){
		log.info("***[BondProcessor]: Starting price "+order.getPrice());
		BigDecimal newPrice=order.getPrice().subtract(new BigDecimal("50"));
		order.setPrice(newPrice);
		log.info("***[BondProcessor]: new price "+order.getPrice());
		return order;
	}
}
