package corso.spring.intgr.endpoints.demo.services;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import corso.spring.intgr.common.beans.Order;

@Service("orderFilter")
@Slf4j
public class OrderFilter {

	public static int scartati=0;
	public static int processati=0;
	
	public boolean filterOrders(Order order){
		log.info("\n\n*****************************************");
		log.info("[OrderFilter]: "+order);
		
		if(order.getPrice().doubleValue()<300){
			log.info("[OrderFilter]: "+order.getPrice()+" verra scartato!!");
			scartati++;
			log.info("[OrderFilter]: scartati: "+scartati);
			log.info("*******FINE ELABORAZIONE*******");		
			return false;
		}else{
			processati++;
			return true;
		}
		
	}
}
