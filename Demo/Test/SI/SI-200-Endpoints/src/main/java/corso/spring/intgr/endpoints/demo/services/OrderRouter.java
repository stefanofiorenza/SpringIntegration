package corso.spring.intgr.endpoints.demo.services;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import corso.spring.intgr.common.beans.Order;

@Service("orderRouter")
@Slf4j
public class OrderRouter {

	public String route(Order item) {
		log.info("*[OrderRouter]: ricevuto nuovo: "+item.getStockType());
		
		switch(item.getStockType()){
		
		case CERTIFICATO_AZIONARIO: 
			return "routerToStockChannel";
			
		case CERTIFICATO_OBBLIGAZIONARIO_DEBITO_SOVRANO:
			return "routerToPblBondChannel";
			
		case CERTIFICATO_OBBLIGAZIONARIO_PRIVATO:
			return "routerToPvtBondChannel";
			
		case EQUITY_SWAP:
		case OPZIONE: 
		case QUOTA_FONDO_INVESTIMENTO:
		case TITOLO_DERIVATO:
		default:
		return "routerToDerivatiChannel";
	
		}
			
	}
	
	
	
}
