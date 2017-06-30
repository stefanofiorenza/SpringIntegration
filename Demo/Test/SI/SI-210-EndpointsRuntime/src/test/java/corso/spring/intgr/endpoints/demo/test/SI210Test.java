package corso.spring.intgr.endpoints.demo.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import corso.spring.intgr.common.beans.Order;
import corso.spring.intgr.common.utils.OrderGenerator;
import corso.spring.intgr.endpoints.demo.config.SI200EndpointsConfig;
import corso.spring.intgr.endpoints.demo.configs.SI210EndpointsConfig;
import corso.spring.intgr.endpoints.demo.configs.SI210EndpointsConfigClasspathScan;
import corso.spring.intgr.endpoints.demo.endpoints.OrderGatewayI;

public class SI210Test {


	@Test
	public void testProcessFlowFromConfigFile(){			
		ApplicationContext context =new ClassPathXmlApplicationContext("SI-200-Endpoints.xml");
		testTemplate(context);		
	}
	
	
	@Test
	public void testProcessFlowFromConfigClass(){
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(SI210EndpointsConfig.class);
		ctx.refresh();		
		testTemplate(ctx);	
	}
	
	
	@Test
	public void testProcessFlowFromSIClassPathScanning(){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(SI210EndpointsConfigClasspathScan.class);
		ctx.refresh();
		
		OrderGatewayI orderGateway= ctx.getBean(OrderGatewayI.class);	
		List<Order> orders= OrderGenerator.createOrders(10);
		for (Order order : orders) {
			orderGateway.dispatchOrder(order);
		}
		
		ctx.close();
		//testTemplate(ctx);		
	}
	
	
	private void testTemplate(ApplicationContext context){
		
		MessageChannel channel =context.getBean("orderMainInputChannel", MessageChannel.class);		
		
		List<Order> orders= OrderGenerator.createOrders(10);
		for (Order order : orders) {
			channel.send(MessageBuilder.withPayload(order).build());
		}
	}
	
}
