package corso.spring.intgr.demo.basics.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import corso.spring.intgr.demo.basics.model.User;
import corso.spring.intgr.demo.basics.services.ServiceEchoUserImpl;


@MessageEndpoint
public class EndpointEchoUserImpl {

	@Autowired
	private ServiceEchoUserImpl service;
	
	@ServiceActivator(inputChannel="inputChannel", outputChannel="outputChannel", autoStartup="true")
	public User echoUser(User input) {		
		return service.echoUser(input);
	}

}
