package com.test.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.test.listener
 * @Author: jkl
 * @CreateTime: 2021
 * @Description:
 */
public class MyListener1 implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("applicationLinstener======================");
    }
}
