package com.test.common.vo;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.test.common.vo
 * @Author: jkl
 * @CreateTime: 2021
 * @Description:
 */
public class StuVO {
    public String name;
    public String age;
    public String sex;

    public StuVO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "StuVO{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public static void say(){
        System.out.println("parent say");
    }

    public static void say(String name){

    }



}
