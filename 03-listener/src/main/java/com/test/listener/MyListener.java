package com.test.listener;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.test.listener
 * @Author: jkl
 * @CreateTime: 2021
 * @Description:
 */
public class MyListener implements SpringApplicationRunListener {
    private SpringApplication application;
    private String[] args;

    public MyListener(SpringApplication app,String[] args){
        this.application=app;
        this.args=args;
    }
    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        System.out.println("starting=========");
    }


    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        System.out.println("environmentPrepared=========");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("contextPrepared=========");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("contextLoaded=========");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("started=========");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("running=========");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("failed=========");
    }
}
