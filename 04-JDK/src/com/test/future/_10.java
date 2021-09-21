package com.test.future;

import com.test.common.vo.StuVO;

import java.util.Optional;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.test.future
 * @Author: jkl
 * @CreateTime: 2021
 * @Description: jdk10特性
 */

/**
 * 1.optional增加ifPresentOrElse
 * 2.var 但在lambda中不支持
 */
public class _10 {
    public static void main(String[] args) {
        StuVO stuVO = new StuVO();
        Optional<StuVO> optional = Optional.of(stuVO);
        optional.ifPresentOrElse(System.out::println,
                ()->{
                    System.out.println("SutVO is not exist");
                });

        var name = "String";
        System.out.println(name);


    }
}
