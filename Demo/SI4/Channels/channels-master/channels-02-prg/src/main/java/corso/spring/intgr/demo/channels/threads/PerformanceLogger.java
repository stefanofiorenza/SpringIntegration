package corso.spring.intgr.demo.channels.threads;

import java.util.concurrent.Callable;

import org.apache.log4j.Logger;

public class PerformanceLogger implements Runnable {

	private Long startExecution;
	private static Logger logger = Logger.getLogger(PerformanceLogger.class);
	
	public PerformanceLogger (Long startExecution){
		this.startExecution=startExecution;
	}
	
	@Override
	public void run(){
		
		Long endExecution=System.currentTimeMillis();
		double totalExecutionTimeInSeconds=(double)endExecution-startExecution/1000;
		logger.info("total execution time: "+totalExecutionTimeInSeconds+" seconds");
		
	}

}
