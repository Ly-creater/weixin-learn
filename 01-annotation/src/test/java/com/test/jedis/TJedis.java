package com.test.jedis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.test.jedis
 * @Author: jkl
 * @CreateTime: 2021
 * @Description:
 */
public class TJedis {

    private static Jedis jedis = null;
    @Before
    public void initJedis(){
        jedis = new Jedis("localhost", 6379);
    }

    @Test
    public void m1(){
        jedis.configGet("*").stream().forEach(System.out::println);

    }

    @After
    public void destroyJedis(){
        System.out.println("销毁jedis");
        jedis.close();
    }
}
