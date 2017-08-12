package com.ele.service_impl;

import com.ele.mapper.UserMapper;
import com.ele.pojo.User;
import com.ele.service.UserService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by yanfeng-mac on 2017/8/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext*.xml")
public class UserServiceImplTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void findById() throws Exception {
        Integer id = 1;
        String json = redisTemplate.opsForValue().get("user" + id);
        Gson gson = new Gson();

        User user = null;

        if(json == null) {
            user = userMapper.findById(id);

            redisTemplate.opsForValue().set("user" + user.getId(), gson.toJson(user));
        } else {
            user = gson.fromJson(json,User.class);
        }
        System.out.println(user);
    }

}