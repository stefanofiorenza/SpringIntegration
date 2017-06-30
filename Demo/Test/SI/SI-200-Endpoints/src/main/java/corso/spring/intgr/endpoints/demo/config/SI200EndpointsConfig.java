package corso.spring.intgr.endpoints.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import corso.spring.intgr.endpoints.demo.services.BondService;
import corso.spring.intgr.endpoints.demo.services.DerivatiService;
import corso.spring.intgr.endpoints.demo.services.OrderFilter;
import corso.spring.intgr.endpoints.demo.services.OrderRouter;
import corso.spring.intgr.endpoints.demo.services.PrivateBondProcessor;
import corso.spring.intgr.endpoints.demo.services.PublicBondProcessor;
import corso.spring.intgr.endpoints.demo.services.StockProcessor;
import corso.spring.intgr.endpoints.demo.services.StockService;

@Configuration
public class SI200EndpointsConfig {
			
	@Bean
	@Qualifier("bondService")
	public BondService bondService(){
		return new BondService();
	}
	
	@Bean
	@Qualifier("derivatiService")
	public DerivatiService derivatiService(){
		return new DerivatiService();
	}
	
	
	@Bean
	@Qualifier("orderFilter")
	public OrderFilter orderFilter(){
		return new OrderFilter();
	}
	
	
	@Bean
	@Qualifier("orderRouter")
	public OrderRouter orderRouter(){
		return new OrderRouter();
	}
	
	
	@Bean
	@Qualifier("privateBondProcessor")
	public PrivateBondProcessor privateBondProcessor(){
		return new PrivateBondProcessor();
	}
	
	@Bean
	@Qualifier("publicBondProcessor")
	public PublicBondProcessor publicBondProcessor(){
		return new PublicBondProcessor();
	}
		
	@Bean
	@Qualifier("stockProcessor")
	public StockProcessor stockProcessor(){
		return new StockProcessor();
	}
	
	@Bean
	@Qualifier("StockService")
	public StockService stockService(){
		return new StockService();
	}
	

}
