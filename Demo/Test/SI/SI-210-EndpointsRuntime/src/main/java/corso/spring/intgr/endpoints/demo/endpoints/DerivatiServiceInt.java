package corso.spring.intgr.endpoints.demo.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import corso.spring.intgr.common.beans.Order;
import corso.spring.intgr.endpoints.demo.services.DerivatiService;

@MessageEndpoint
public class DerivatiServiceInt {
	
	@Autowired
	private DerivatiService derivatiService;
	
	@ServiceActivator(inputChannel = "routerToDerivatiChannel")
	public void executeDerivatiLogic(Order order){		
		derivatiService.executeDerivatiLogic(order);
	}
}
