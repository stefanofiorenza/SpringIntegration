package corso.spring.intgr.demo.basic.service;

import org.apache.log4j.Logger;

import corso.spring.intgr.demo.basic.model.User;
import corso.spring.intgr.demo.basic.test.TestBasicDemo;


public class ServiceEchoUserImpl implements ServiceEchoUser{

	private static Logger logger = Logger.getLogger(ServiceEchoUserImpl.class);
	
	
	@Override
	public User echoUser(User input) {

		//TODO da rimpiazzare con Logger
		logger.info("[ServiceEchoUserImpl]: ricevuto User: "+input.toString());
		return input;
	}

}
