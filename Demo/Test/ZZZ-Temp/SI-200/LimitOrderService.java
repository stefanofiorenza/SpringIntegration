package corso.spring.intgr.endpoints.demo.services;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import corso.spring.intgr.common.beans.Order;

@Service("limitOrderService")
@Slf4j
public class LimitOrderService {
	
	public void executeStockLogic(Order order){		
		log.info("******[limitOrderService]: processa "+order);
		log.info("*******FINE ELABORAZIONE*******");			
	}
}
