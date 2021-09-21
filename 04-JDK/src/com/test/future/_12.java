package com.test.future;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.test.future
 * @Author: jkl
 * @CreateTime: 2021
 * @Description: jdk12特性
 */

/**
 * switch用法增强
 */
public class _12 {
    public static void main(String[] args) {
        System.out.println(isWorkingDay(1));
    }

    public static String isWorkingDay(int x){
       return switch (x){
            case 1,2,3,4,5 -> "workingDay";
            case 6,7 -> "NonWorkingDay";
            default -> "param is worry";

        };
    }
}
