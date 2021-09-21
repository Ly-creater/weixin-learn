package com.test.common.vo;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.test.common.vo
 * @Author: jkl
 * @CreateTime: 2021
 * @Description:
 */
public interface TestIn {
    static final String name = "name";
    public abstract void m1();
    public static void m3(){
        System.out.println("ooo");
    }
    public default void m2(){

    }


}
