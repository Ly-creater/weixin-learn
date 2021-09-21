package com.test.future;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.test.future
 * @Author: jkl
 * @CreateTime: 2021
 * @Description: jdk9特性
 */
public class _09 {
    /**
     * 1.接口中的私有方法
     */
    public interface UserService{
        public default void m1(){
            m2();
        }
         private void m2(){
             System.out.println("jdk9 ");
        }

    }
    public class UserServicesImpl implements UserService{ }



    public static void main(String[] args) {
        UserServicesImpl userServices = new _09().new UserServicesImpl();
        userServices.m1();

        /**
         * 2.工厂集合方法
         * @param args
         */

        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Map<Integer, String> map = Map.of(0, "1", 1, "2");
        System.out.println(list);
        System.out.println(map);

    }


}
