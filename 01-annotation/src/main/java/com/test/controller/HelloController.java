package com.test.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.test.controller.apollo.ApolloVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @ApolloConfig
    private Config config;

    @Value("${server.port}")
    String port;
    @Value("${timeout:1}")
    private String timeout;
    @Value("${test.apollo:1}")
    private String testAp;

    @Autowired
    private ApolloVO apolloVO;

    @Autowired
    private RefreshScope refreshScope;

    @GetMapping("hi")
    public String hi() {
        return "timeout " + timeout + " ,testAp:" + testAp+"\r\n"+"apolloVO:"+apolloVO.toString();
    }

    @ApolloConfigChangeListener({"application","test"})
    private void configChangeListter(ConfigChangeEvent changeEvent) {
        boolean b = changeEvent.changedKeys().stream().anyMatch(str -> str.startsWith("dev."));
        if (b) {
            System.out.println("跟新！！！");
            refreshScope.refresh("apolloVO");
        }
    }
}