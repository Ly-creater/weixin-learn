package com.fastJ.service;

import com.fastJ.vo.Sut;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.test.postProcess
 * @Author: jkl
 * @CreateTime: 2021
 * @Description:
 */
@Component("sut")
public class User implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        Sut sut = new Sut();
        sut.setName("factoryBean");
        return sut;
    }

    @Override
    public Class<?> getObjectType() {
        return Sut.class;
    }
}
