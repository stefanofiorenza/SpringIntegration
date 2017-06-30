package corso.spring.intgr.endpoints.demo.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;

import corso.spring.intgr.endpoints.demo.services.PublicBondProcessor;
import corso.spring.intgr.endpoints.demo.services.BondService;
import corso.spring.intgr.endpoints.demo.services.OrderFilter;
import corso.spring.intgr.endpoints.demo.services.OrderRouter;
import corso.spring.intgr.endpoints.demo.services.StockProcessor;
import corso.spring.intgr.endpoints.demo.services.StockService;

@Configuration
@EnableIntegration
@ComponentScan("corso.spring.intgr.endpoints.demo.services,corso.spring.intgr.endpoints.demo.endpoints") 
@IntegrationComponentScan("corso.spring.intgr.endpoints.demo.endpoints")
@Import(SI210ChannelsConfig.class)
public class SI210EndpointsConfigClasspathScan {	

		
}
