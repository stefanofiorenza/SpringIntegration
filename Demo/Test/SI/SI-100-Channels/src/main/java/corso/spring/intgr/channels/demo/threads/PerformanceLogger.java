package corso.spring.intgr.channels.demo.threads;

import java.util.Date;
import java.util.concurrent.Callable;

import lombok.extern.slf4j.Slf4j;

import org.apache.log4j.Logger;

@Slf4j
public class PerformanceLogger implements Runnable {

	private long startExecution;
	
	public PerformanceLogger (){
		this.startExecution=System.currentTimeMillis();
		log.info("Start execution time: "+new Date(System.currentTimeMillis()));
	}
	
	@Override
	public void run(){
			
		Long endExecution=System.currentTimeMillis();
		log.info("End execution time: "+new Date(System.currentTimeMillis()));
		
		double totalExecutionTimeInSeconds=((double)endExecution-startExecution)/1000;
		log.info("total execution time: "+totalExecutionTimeInSeconds+" seconds");
		
	}

}
