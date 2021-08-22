package com.test.controller;

import org.springframework.stereotype.Controller;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.test.controller
 * @Author: jkl
 * @CreateTime: 2021
 * @Description:
 */
@Controller
public class BankController {
    //对于字符串不满足长度位置用_代替
    //对于数字不满足长度位置用0代替
    public static void main(String[] args) {
        System.out.println(String.format( "%-10s","qwer").replace(" ", "_"));
        System.out.println(String.format( "%10s","qwer").replace(" ", "_"));

    }
}
