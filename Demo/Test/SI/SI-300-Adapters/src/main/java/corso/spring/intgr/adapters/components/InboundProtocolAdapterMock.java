package corso.spring.intgr.adapters.components;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import corso.spring.intgr.common.beans.Order;
import corso.spring.intgr.common.services.AgentService;

@Component("inboundProtocolAdapterMock")
//@Qualifier
@Slf4j
public class InboundProtocolAdapterMock implements InitializingBean{

	@Autowired
	private AgentService agentService;
	
	private	List<Order> ordersInBuffer;
	
		
	public Order receiveOrderFromExternalSystemThroughProtocol(){	
		if(ordersInBuffer.isEmpty()){
			log.warn("Adapter listen for new orders...");
			return null;
		}		
		Order received=ordersInBuffer.remove(0);
		log.info("Received from some protocol order#{}",received.getOrderId());
		return received;
	
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		ordersInBuffer=agentService.createOrders(100);		
	}
}
