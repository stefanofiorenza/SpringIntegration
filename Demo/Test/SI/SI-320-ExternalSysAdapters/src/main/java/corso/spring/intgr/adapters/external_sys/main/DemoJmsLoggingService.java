package corso.spring.intgr.adapters.external_sys.main;

import lombok.extern.slf4j.Slf4j;
import corso.spring.intgr.common.beans.OrderOutcome;

@Slf4j
public class DemoJmsLoggingService {

	public void logOutcome(OrderOutcome outcome){
		log.info("Process Terminated for Outcome for Order#{}", outcome.getOrderId());
	}
}
