package com.jubotech.framework.config;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AsyncConfig implements AsyncConfigurer {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
		threadPool.setCorePoolSize(1000);
		threadPool.setMaxPoolSize(2000);
		 
		threadPool.setWaitForTasksToCompleteOnShutdown(true);
		threadPool.setAwaitTerminationSeconds(60 * 15);
		threadPool.setThreadNamePrefix("MyAsync-");
		threadPool.initialize();
		return threadPool;

	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new AsyncUncaughtExceptionHandler() {
			// 自定义异常处理类
			@Override
			public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {
				log.info("Exception message - " + throwable.getMessage());
				log.info("Method name - " + method.getName());
				for (Object param : obj) {
					log.info("Parameter value - " + param);
				}
			}
		};
	}

}
