package corso.spring.intgr.adapters.components;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import corso.spring.intgr.common.beans.Order;

@Component("outgoingProtocolAdapterMock")
@Slf4j
public class OutgoingProtocolAdapterMock {

	
	public void sendToExternalSystemThroughProtocol(Order order){
		if(order== null){
			log.warn("No MOre orders to Process. Demo can be closed");
		}else{
			log.info("Send order#{} to external system", order.getOrderId());
		}		
	}
}
