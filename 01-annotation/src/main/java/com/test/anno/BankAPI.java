package com.test.anno;

import java.lang.annotation.*;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.test.anno
 * @Author: jkl
 * @CreateTime: 2021
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
public @interface BankAPI {
    String desc() default "";
    String url() default "";
}