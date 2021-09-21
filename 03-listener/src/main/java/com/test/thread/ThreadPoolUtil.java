package com.test.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class ThreadPoolUtil {
    private static int corePoolSize = 5;
    private static int maximumPoolSize = 10;
    private static long keepAliveTime = 60L;
    private static TimeUnit unit = TimeUnit.SECONDS;
    private static int capacity = 1024;
    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("jdk-thread-pool-%d").build();
    private static final ExecutorService executorService = new ThreadPoolExecutor(corePoolSize,
            maximumPoolSize,
            keepAliveTime,
            unit,
            new LinkedBlockingQueue<>(capacity),
            namedThreadFactory,
            new ThreadPoolExecutor.AbortPolicy());

    private ThreadPoolUtil() {

    }

    public static ExecutorService getExecutorService() {
        return executorService;
    }
}