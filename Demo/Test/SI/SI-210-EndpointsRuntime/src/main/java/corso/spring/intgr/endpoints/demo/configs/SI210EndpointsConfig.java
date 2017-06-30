package corso.spring.intgr.endpoints.demo.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.Router;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.config.EnableIntegration;

import corso.spring.intgr.endpoints.demo.config.SI200EndpointsConfig;
import corso.spring.intgr.endpoints.demo.endpoints.BondServiceInt;
import corso.spring.intgr.endpoints.demo.endpoints.DerivatiServiceInt;
import corso.spring.intgr.endpoints.demo.endpoints.OrderFilterInt;
import corso.spring.intgr.endpoints.demo.endpoints.OrderRouterInt;
import corso.spring.intgr.endpoints.demo.endpoints.PrivateBondProcessorInt;
import corso.spring.intgr.endpoints.demo.endpoints.PublicBondProcessorInt;
import corso.spring.intgr.endpoints.demo.endpoints.StockProcessorInt;
import corso.spring.intgr.endpoints.demo.endpoints.StockServiceInt;

@Configuration
@EnableIntegration
@Import({ SI200EndpointsConfig.class, SI210ChannelsConfig.class })
public class SI210EndpointsConfig {	

	
	@Bean
	@Qualifier("bondServiceInt")
	@ServiceActivator(inputChannel = "trasformerBondChannel")
	public BondServiceInt bondServiceInt(){
		return new BondServiceInt();
	}
	
	@Bean
	@Qualifier("derivatiServiceInt")
	@ServiceActivator(inputChannel = "routerToDerivatiChannel")
	public DerivatiServiceInt derivatiServiceInt(){
		return new DerivatiServiceInt();
	}
	
	
	@Bean
	@Qualifier("orderFilterInt")
	@Filter(inputChannel="orderMainInputChannel",outputChannel="filteredOrdersChannel")
	public OrderFilterInt orderFilterInt(){
		return new OrderFilterInt();
	}
	
	
	@Bean
	@Qualifier("orderRouterInt")
	@Router(inputChannel="filteredOrdersChannel")
	public OrderRouterInt orderRouterInt(){
		return new OrderRouterInt();
	}
	
	
	@Bean
	@Qualifier("privateBondProcessorInt")
	@Transformer(inputChannel="routerToPvtBondChannel",outputChannel="trasformerBondChannel")
	public PrivateBondProcessorInt privateBondProcessorInt(){
		return new PrivateBondProcessorInt();
	}
		
	
	@Bean
	@Qualifier("publicBondProcessorInt")
	@Transformer(inputChannel="routerToPblBondChannel",outputChannel="trasformerBondChannel")
	public PublicBondProcessorInt publicBondProcessorInt(){
		return new PublicBondProcessorInt();
	}
	
		
	@Bean
	@Qualifier("stockProcessorInt")
	@Transformer(inputChannel="routerToStockChannel",outputChannel="trasformerStocksChannel")
	public StockProcessorInt stockProcessorInt(){
		return new StockProcessorInt();
	}
	
	@Bean
	@Qualifier("stockServiceInt")
	@ServiceActivator(inputChannel = "trasformerStocksChannel")
	public StockServiceInt stockServiceInt(){
		return new StockServiceInt();
	}
		
}
