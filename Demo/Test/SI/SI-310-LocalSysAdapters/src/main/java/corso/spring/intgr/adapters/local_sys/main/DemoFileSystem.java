package corso.spring.intgr.adapters.local_sys.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoFileSystem {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("files-adapters-demo-config.xml");
		context.start();
	}

}
