package corso.spring.intgr.endpoints.demo.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import corso.spring.intgr.common.beans.Order;
import corso.spring.intgr.endpoints.demo.services.PublicBondProcessor;
import corso.spring.intgr.endpoints.demo.services.BondService;

@MessageEndpoint
public class BondServiceInt {

	@Autowired
	private BondService bondService;
	
	@ServiceActivator(inputChannel = "trasformerBondChannel")
	public void executeBondLogic(Order order){		
		bondService.executeBondLogic(order);			
	}
}
