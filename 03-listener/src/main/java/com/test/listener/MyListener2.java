package com.test.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.GenericApplicationListener;
import org.springframework.core.ResolvableType;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.test.listener
 * @Author: jkl
 * @CreateTime: 2021
 * @Description:
 */
public class MyListener2 implements GenericApplicationListener {
    @Override
    public boolean supportsEventType(ResolvableType eventType) {
        return false;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("------->GenericApplicationListener");

    }
}
