package corso.spring.intgr.common.services;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import corso.spring.intgr.common.beans.Order;
import corso.spring.intgr.common.utils.OrderGenerator;

@Service
@Slf4j
public class AgentServiceImpl implements AgentService{


	@Override
	public List<Order> createOrders(int quantity) {
		return OrderGenerator.createOrders(quantity);
	}

}
