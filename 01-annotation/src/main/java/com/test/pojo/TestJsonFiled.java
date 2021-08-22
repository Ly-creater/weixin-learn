package com.test.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.test.pojo
 * @Author: jkl
 * @CreateTime: 2021
 * @Description:
 */
@Data
@AllArgsConstructor
public class TestJsonFiled {
@JSONField(name = "name")
    private String sName;

    private String aAge;

}
