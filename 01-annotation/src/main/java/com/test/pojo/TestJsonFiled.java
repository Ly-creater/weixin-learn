package com.test.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
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
@JsonInclude
public class TestJsonFiled {
@JSONField(name = "name")
    private String sName;
    @JsonValue
    private String aAge;

}
