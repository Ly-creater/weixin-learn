package com.test.future;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.test.future
 * @Author: jkl
 * @CreateTime: 2021
 * @Description: jdk12特性
 */

/**
 * json块
 */
public class _13 {
    public static void main(String[] args) {
        System.out.println(isWorkingDay(1));
    }
    
    public static String isWorkingDay(int x){
       String json = """
                           {
                               "firstName": "Piotr",
                               "lastName": "Mińkowski"
                          }
               """;
       return json;
    }
}
