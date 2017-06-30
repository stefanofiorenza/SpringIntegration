package corso.spring.intgr.endpoints.demo.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;

import corso.spring.intgr.common.beans.Order;
import corso.spring.intgr.endpoints.demo.services.PublicBondProcessor;

@MessageEndpoint
public class PublicBondProcessorInt {

	@Autowired
	private PublicBondProcessor bondProcessor;
	
	@Transformer(inputChannel="routerToPblBondChannel",outputChannel="trasformerBondChannel")
	public Order processBondMessage(Order order){		
		return bondProcessor.processPublicBondMessage(order);
	}
}
