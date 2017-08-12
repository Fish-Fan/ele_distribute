package com.ele.service_impl;

import com.ele.mapper.UserMapper;
import com.ele.pojo.User;
import com.ele.service.UserService;
import com.google.gson.Gson;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
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
//测试高速序列化工具protostuffIO
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
        User user = new User();
        try {
            byte[] bytes = redisTemplate.opsForValue().get("user:" + id).getBytes();
            Schema<User> userSchema = RuntimeSchema.getSchema(User.class);

            ProtobufIOUtil.mergeFrom(bytes,user,userSchema);
        } catch (NullPointerException e) {
            e.printStackTrace();
            user = userMapper.findById(id);
            //将Java对象进行序列化
            Schema<User> userSchema1 = RuntimeSchema.getSchema(User.class);
            byte[] bytes1 = ProtobufIOUtil.toByteArray(user,userSchema1, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));

            redisTemplate.opsForValue().set("user:" + user.getId(), bytes1.toString());
        }

        System.out.println(user);
    }

}