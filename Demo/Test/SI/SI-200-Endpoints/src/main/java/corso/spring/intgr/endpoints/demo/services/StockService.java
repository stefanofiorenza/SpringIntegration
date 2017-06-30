package corso.spring.intgr.endpoints.demo.services;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import corso.spring.intgr.common.beans.Order;

@Service("stockService")
@Slf4j
public class StockService {

	
	public void executeStockLogic(Order marketItem){
		
		log.info("******[StockService]: processa "+marketItem);
		log.info("*******FINE ELABORAZIONE*******");		
	
	}
}
