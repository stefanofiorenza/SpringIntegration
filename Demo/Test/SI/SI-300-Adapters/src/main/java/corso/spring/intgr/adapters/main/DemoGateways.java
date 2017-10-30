package corso.spring.intgr.adapters.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import corso.spring.intgr.adapters.components.OrderGateway;
import corso.spring.intgr.common.services.AgentService;

public class DemoGateways {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("gateways-demo-config.xml");
		OrderGateway orderGateway =context.getBean("orderGateway",OrderGateway.class);
		AgentService agentService=context.getBean(AgentService.class);
		agentService.createOrders(100).forEach(o -> orderGateway.processOrder(o));
	
	}

}
