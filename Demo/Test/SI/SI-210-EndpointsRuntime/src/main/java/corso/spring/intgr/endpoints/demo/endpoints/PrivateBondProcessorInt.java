package corso.spring.intgr.endpoints.demo.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;

import corso.spring.intgr.common.beans.Order;
import corso.spring.intgr.endpoints.demo.services.PrivateBondProcessor;

@MessageEndpoint
public class PrivateBondProcessorInt {

	@Autowired
	private PrivateBondProcessor bondProcessor;
	
	@Transformer(inputChannel="routerToPvtBondChannel",outputChannel="trasformerBondChannel")
	public Order processBondMessage(Order order){		
		return bondProcessor.processPrivateBondMessage(order);
	}
}
