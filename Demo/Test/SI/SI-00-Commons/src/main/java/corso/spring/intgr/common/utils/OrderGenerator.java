package corso.spring.intgr.common.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import corso.spring.intgr.common.beans.Order;
import corso.spring.intgr.common.beans.OrderType;
import corso.spring.intgr.common.beans.StockType;
import corso.spring.intgr.common.beans.TIFType;

public class OrderGenerator {

	
	public static List<Order> createOrders(int quantity){
		 List<Order> orders = new ArrayList<Order>();
		 for (int i=0; i<quantity; i++){
			 orders.add(mockOrder(i));
		 }
		 return orders;
	}
	
	
	
	private static Order mockOrder(int orderN){
		
		Order order = new Order();
		order.setOrderId("Order_"+orderN);
		order.setOrderReferenceId("ReferenceId_"+orderN);
		order.setPrice(new BigDecimal("1000.0"));
		order.setQuantity(10);
		order.setStockName("AMockStockName");		
		order.setTifType(TIFType.Day);
		order.setType(OrderType.LIMIT);	
						
		if(orderN%11==0){
			order.setStockType(StockType.TITOLO_DERIVATO);
			return order;
		}
				
		if(orderN%11==0){
			order.setStockType(StockType.QUOTA_FONDO_INVESTIMENTO);
			return order;
		}
		
		if(orderN%7==0){
			order.setStockType(StockType.OPZIONE);
			return order;
		}
		
		
		if(orderN%5==0){
			order.setStockType(StockType.CERTIFICATO_OBBLIGAZIONARIO_PRIVATO);
			return order;
		}		
		
		if(orderN%2==0){
			order.setStockType(StockType.CERTIFICATO_OBBLIGAZIONARIO_DEBITO_SOVRANO);
			return order;
		}
		
		else{
			order.setStockType(StockType.CERTIFICATO_AZIONARIO);
			return order;
		}	
		
	}
	
	

}
