package corso.spring.intgr.endpoints.demo.services;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import corso.spring.intgr.common.beans.Order;

@Service("bondService")
@Slf4j
public class BondService {

	
	public void executeBondLogic(Order order){
		
		log.info("******[BondService]: processa "+order);
		log.info("*******FINE ELABORAZIONE*******");		
		
	}
}
