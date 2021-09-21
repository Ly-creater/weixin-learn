package com.test.future;

import java.util.function.Function;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.test.future
 * @Author: jkl
 * @CreateTime: 2021
 * @Description: jdk10特性
 */

/**
 * var 可以用在lambda中
 */
public class _11 {
    public static String FLAG = "one";
    public static String FAILED = "failed";

    public static void main(String[] args) {

        Function<String, String> function = (var x) -> {
           if (FLAG.equals(x)){
               return "success";
           }
           return "failed";
        };
        Function<String, String> compose = function.compose((var x) -> {
            if (FAILED.equals(x)) {
                System.out.println("11");
                return "请不用灰心，下次再接再厉！";
            }
            return "恭喜您中奖了！";
        });
        Function<String, String> andThen = function.andThen((var x) -> {
            if (FAILED.equals(x)) {
                System.out.println("11");
                return "请不用灰心，下次再接再厉！";
            }
            return "恭喜您中奖了！";
        });
        System.out.println(andThen.apply("one"));
        System.out.println(compose.apply("one"));


    }
}
