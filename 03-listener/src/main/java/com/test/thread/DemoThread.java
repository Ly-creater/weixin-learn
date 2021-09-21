package com.test.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

import static com.test.thread.ThreadPoolUtil.getExecutorService;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.test.listener
 * @Author: jkl
 * @CreateTime: 2021
 * @Description:
 */
public class DemoThread {
    private static ExecutorService executor = getExecutorService();

    public static void main(String[] args) {
        CompletableFuture.runAsync(()->{
            System.out.println("start");
        },executor);


        new Thread(()->{
            System.out.println("ddd");
        }).start();

    }
}
