package com.hadoo.service;

import com.hadoo.mapper.CategoryMapper;
import com.hadoo.mapper.FriendLinkMapper;
import com.hadoo.mapper.VisitorMapper;
import com.hadoo.model.FriendLink;
import com.hadoo.redis.HashRedisServiceImpl;
import com.hadoo.redis.StringRedisServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashMap;

/**
 * @author: zhangocean
 * @Date: 2019/5/6 14:30
 * Describe:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {

    @Autowired
    HashRedisServiceImpl hashRedisService;
    @Autowired
    VisitorMapper visitorMapper;

    @Test
    public void redisTest(){
    }

}
