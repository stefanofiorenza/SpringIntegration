package corso.spring.intgr.adapters.external_sys.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import corso.spring.intgr.common.beans.Order;
import corso.spring.intgr.common.services.AgentService;

public class DemoJmsAdapters {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jms-adapters-demo-config.xml");
		MessageChannel inputChannel = context.getBean("orderOutgoingChannel",MessageChannel.class);
		AgentService agentService=context.getBean(AgentService.class);
		agentService.createOrders(100).forEach(o -> inputChannel.send(new GenericMessage<Order>(o)));
	
		
	}

}
