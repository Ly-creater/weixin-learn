package com.test.future;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.test.future
 * @Author: jkl
 * @CreateTime: 2021
 * @Description: jdk14特性
 */

/**
 * record大概介绍
 * - Record被用来设计传输不可变的数据。从上面的例子可以看到，一个Record类被初始化后里面的属性是不能改变的，
 *   没有Setter方法而是通过全参数构造来初始化数据，天然线程安全。
 *
 * - 所有用Record关键字声明的类都是java.lang.Record的子类，这一点有点像枚举
 */
public class _14 {

    public record user(String name, String age){
    };

    public static void main(String[] args) {
        user record = new user("xm", "11");
        System.out.println(record);
        Emp smith = new Emp("smith");
        System.out.println(smith.toString());
        System.out.println("是否属于Recode的子类:"+Record.class.isAssignableFrom(smith.getClass()));
        System.out.println("是否属于Recode的子类:"+smith.getClass().isRecord());

    }
}
