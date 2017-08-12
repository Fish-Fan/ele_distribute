import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;

/**
 * Created by yanfeng-mac on 2017/8/9.
 */
public class test {
    @Test
    public void test() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:applicationContext*.xml");
        context.start();
        System.out.println("service_impl已启动...");
        System.in.read();
    }

    //普通连接
    @Test
    public void jedisTest() {
        Jedis jedis = new Jedis("192.168.1.215",6379);
        String name = jedis.get("user:1");
        System.out.println("name->" + name);
        jedis.close();
    }

    //连接池连接
    @Test
    public void jedisTestWithPool() {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        //最大空闲连接数
        config.setMaxTotal(10);
        //最小空闲连接数
        config.setMinIdle(5);
        JedisPool jedisPool = new JedisPool(config,"192.168.1.215",6379);

        Jedis jedis = jedisPool.getResource();
        String name = jedis.get("user:1");

        System.out.println("name->" + name);

        jedis.close();
        jedisPool.destroy();
    }


}
