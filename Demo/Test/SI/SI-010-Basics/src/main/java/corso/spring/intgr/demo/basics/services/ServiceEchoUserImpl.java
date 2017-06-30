package corso.spring.intgr.demo.basics.services;

import lombok.extern.slf4j.Slf4j;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import corso.spring.intgr.demo.basics.model.User;


@Service
@Slf4j
public class ServiceEchoUserImpl {

	public User echoUser(User input) {		
		log.info("[ServiceEchoUserImpl]: ricevuto User: "+input.toString());
		return input;
	}

}
