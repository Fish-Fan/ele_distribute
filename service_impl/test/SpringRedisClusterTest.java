import com.ele.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.JedisCluster;

/**
 * Created by yanfeng-mac on 2017/8/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-redis-cluster.xml")
public class SpringRedisClusterTest {
//    @Autowired
//    private JedisCluster jedisCluster;
//
//    @Test
//    public void JedisClusterTest() {
//        jedisCluster.set("name:2","jack");
//    }

    private RedisTemplate<String,User> redisTemplate;

    @Autowired
    private void setRedisTemplate(RedisTemplate<String,User> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.redisTemplate.setKeySerializer(new StringRedisSerializer());
        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<User>(User.class));
    }

    @Test
    public void saveUser() {
        User user = new User();
        user.setUsername("hibernate");
        user.setEmail("fanyank@126.com");

        redisTemplate.opsForValue().set("user:1",user);
    }

    @Test
    public void getUser() {
        User user = redisTemplate.opsForValue().get("user:1");
        System.out.println(user);
    }
}
