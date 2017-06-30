package corso.spring.intgr.endpoints.demo.services;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import corso.spring.intgr.common.beans.Order;

@Service("derivatiService")
@Slf4j
public class DerivatiService {
	
	public void executeDerivatiLogic(Order order){		
		log.info("******[DerivatiService]: Deleted Order: "+order);
		log.info("*******FINE ELABORAZIONE*******");			
	}
}
