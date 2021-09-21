package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.test
 * @Author: jkl
 * @CreateTime: 2021
 * @Description:
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(App.class);
    }
}
