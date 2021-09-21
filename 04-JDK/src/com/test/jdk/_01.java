package com.test.jdk;

import com.test.common.vo.StuVO;

import java.math.BigDecimal;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.test.jdk
 * @Author: jkl
 * @CreateTime: 2021
 * @Description:
 */
public class _01 {
    int j;
    public static void main(String[] args) {
        char ch ='a';
        System.out.println(ch);
        System.out.println(ch+1);
        System.out.println(ch+1.1);
        System.out.println("===================");
        System.out.println(0.1+0.2);
        BigDecimal bigDecimal = new BigDecimal("0.1");
        BigDecimal bigDecimal1 = new BigDecimal("0.2");
        BigDecimal add = bigDecimal.add(bigDecimal1);
        System.out.println(add);
        System.out.println("=====================");
        StuVO stuVO = new StuVO();
        stuVO.age="11";



    }
}
