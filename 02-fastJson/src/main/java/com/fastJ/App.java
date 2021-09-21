package com.fastJ;

import com.fastJ.service.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.fastJ
 * @Author: jkl
 * @CreateTime: 2021
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.fastJ.dao")
@EnableAsync
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(App.class);

        Object bean = run.getBean("&sut");
        Object bean1 = run.getBean("sut");
        System.out.println(bean instanceof User);
        System.out.println(bean1 instanceof User);
    }

    @Bean
    public Executor myExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(3);
        executor.setCorePoolSize(1);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("lv-");
        executor.initialize();
        return executor;

    }
}
