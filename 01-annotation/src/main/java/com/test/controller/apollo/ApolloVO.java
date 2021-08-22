package com.test.controller.apollo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.test.controller.apollo
 * @Author: jkl
 * @CreateTime: 2021
 * @Description:
 */
@Data
@ConfigurationProperties(prefix = "dev")
@Component
@RefreshScope
public class ApolloVO {
    private String age;
    private String name;
}
