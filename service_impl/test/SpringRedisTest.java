import com.ele.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by yanfeng-mac on 2017/8/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-redis.xml")
public class SpringRedisTest {
//    @Autowired
//    private JedisPool jedisPool;
//
//    //jedis连接池直连
//    @Test
//    public void testJedis() {
//        Jedis jedis = jedisPool.getResource();
//        jedis.set("user:3","Jenny");
//
//        String name = jedis.get("user:2");
//        System.out.println("name->" + name);
//        jedis.close();
//    }

    //使用redisTemplate连接redis
    @Autowired
    private RedisTemplate<String,User> redisTemplate;

//    @Autowired
    public void setRedisTemplate(RedisTemplate<String,User> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.redisTemplate.setKeySerializer(new StringRedisSerializer());
        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<User>(User.class));
    }

    @Test
    public void testRedisTemplate() {
        User user = new User();
        user.setUsername("lisi");
        user.setEmail("110@qq.com");
        user.setPhoneNum("110");
        redisTemplate.opsForValue().set("user:4",user);
        User user1 = redisTemplate.opsForValue().get("user:4");
        System.out.println(user1);
    }
}
