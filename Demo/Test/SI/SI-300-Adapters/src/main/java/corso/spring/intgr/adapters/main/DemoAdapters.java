package corso.spring.intgr.adapters.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoAdapters {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("adapters-demo-config.xml");
		context.start();

	}
	

}
