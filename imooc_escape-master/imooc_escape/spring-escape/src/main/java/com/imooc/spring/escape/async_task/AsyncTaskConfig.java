package com.imooc.spring.escape.async_task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
@Configuration
public class AsyncTaskConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("imocc-qinyi-task-");
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(8);
        executor.setKeepAliveSeconds(5);
        executor.setQueueCapacity(100);
        //默认拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        //等待任务执行完成再去关闭其他bean
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //任务等待时间，到时间没关闭，强制销毁
        executor.setAwaitTerminationSeconds(60);

        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {

        return new AsyncUncaughtExceptionHandler() {
            @Override
            public void handleUncaughtException(Throwable ex, Method method,
                                                Object... params) {
                // 发送报警邮件, 短信等等
                log.error("Async Task Has Some Error: {}, {}, {}",
                        ex.getMessage(),
                        method.getDeclaringClass().getName() + "." + method.getName(),
                        Arrays.toString(params));
            }
        };
    }
}
