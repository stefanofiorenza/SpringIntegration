package corso.spring.intgr.endpoints.demo.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;

import corso.spring.intgr.endpoints.demo.services.PublicBondProcessor;
import corso.spring.intgr.endpoints.demo.services.BondService;
import corso.spring.intgr.endpoints.demo.services.OrderFilter;
import corso.spring.intgr.endpoints.demo.services.OrderRouter;
import corso.spring.intgr.endpoints.demo.services.StockProcessor;
import corso.spring.intgr.endpoints.demo.services.StockService;

@Configuration
public class SI210ChannelsConfig {

	/** same as:
	 * 
		<int:channel id="orderMainInputChannel" />
		<int:channel id="filteredOrdersChannel" />
		<int:channel id="routerToDerivatiChannel" />
		<int:channel id="routerToStockChannel" />
		<int:channel id="routerToPblBondChannel" />
		<int:channel id="routerToPvtBondChannel" />
		<int:channel id="trasformerStocksChannel" />			
		<int:channel id="trasformerBondChannel" />
	
	*/		
		
	@Bean
	@Qualifier("orderMainInputChannel")
	public DirectChannel orderMainInputChannel(){
		return new DirectChannel();
	}
	
	@Bean
	@Qualifier("filteredOrdersChannel")
	public DirectChannel filteredOrdersChannel(){
		return new DirectChannel();
	}
	
	@Bean
	@Qualifier("routerToDerivatiChannel")
	public DirectChannel routerToDerivatiChannel(){
		return new DirectChannel();
	}
	
	@Bean
	@Qualifier("routerToStockChannel")
	public DirectChannel routerToStockChannel(){
		return new DirectChannel();
	}
	
	@Bean
	@Qualifier("routerToPblBondChannel")
	public DirectChannel routerToPblBondChannel(){
		return new DirectChannel();
	}
	
	@Bean
	@Qualifier("routerToPvtBondChannel")
	public DirectChannel routerToPvtBondChannel(){
		return new DirectChannel();
	}
	
	@Bean
	@Qualifier("trasformerStocksChannel")
	public DirectChannel trasformerStocksChannel(){
		return new DirectChannel();
	}
	
	@Bean
	@Qualifier("trasformerBondChannel")
	public DirectChannel trasformerBondChannel(){
		return new DirectChannel();
	}

}
