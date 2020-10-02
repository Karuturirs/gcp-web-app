package com.karuturirs.gcp.webapp.configuration;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.instrument.async.LazyTraceExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class TaskExecutorConfiguration {

    @Autowired
    private BeanFactory beanFactory;

    @Bean
    public Executor citrusTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(5);
        executor.setThreadNamePrefix("KeyGenerator");
        executor.setTaskDecorator(new MDCAsychTaskExecutorStrategy());
        executor.initialize();
        return new LazyTraceExecutor(beanFactory, executor);
    }
}
