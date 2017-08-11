package com.zmb.bi.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Lazy(false)
public class TaskAplService {
	
	private static final int LOOP_TIME = 5 * 1000;
	
	@Autowired
	private TaskBaseService taskBaseService;
	
	ExecutorService fixedThreadPool = Executors.newFixedThreadPool(20);
	
	@Scheduled(fixedRate = LOOP_TIME)
	private void BaseTask() {
		fixedThreadPool.execute(new Runnable() {
			public void run() {
				
				taskBaseService.doTask();
			}
		});
	}
}
