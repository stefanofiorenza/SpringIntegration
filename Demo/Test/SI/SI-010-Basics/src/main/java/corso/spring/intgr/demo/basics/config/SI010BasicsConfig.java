package corso.spring.intgr.demo.basics.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.PollableChannel;

@Configuration
@EnableIntegration
@ComponentScan("corso.spring.intgr.demo.basics.services,"//)
		+ "corso.spring.intgr.demo.basics.endpoints") // ATTENZIONE: non e' sufficiente averlo in @IntegrationComponentScan
@IntegrationComponentScan("corso.spring.intgr.demo.basics.endpoints")
public class SI010BasicsConfig {

	private static final int pollableQueueCapacity=10;
	
	@Bean
	//@Qualifier("inputChannel")
	public DirectChannel inputChannel(){
		DirectChannel inputChannel= new DirectChannel();		
		return inputChannel;
	}
	
	@Bean
	//@Qualifier("outputChannel")
	public PollableChannel outputChannel(){
		return new QueueChannel(pollableQueueCapacity);		
	}

}
