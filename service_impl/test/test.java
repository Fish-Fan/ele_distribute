import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

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

    //jedis直连redis集群
    @Test
    public void testJedisRedisCluster() throws IOException {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxTotal(10);
        poolConfig.setMinIdle(5);

        Set<HostAndPort> hostAndPortSet = new HashSet<>();
        hostAndPortSet.add(new HostAndPort("192.168.1.215",6000));
        hostAndPortSet.add(new HostAndPort("192.168.1.215",6001));
        hostAndPortSet.add(new HostAndPort("192.168.1.215",6002));
        hostAndPortSet.add(new HostAndPort("192.168.1.215",6003));
        hostAndPortSet.add(new HostAndPort("192.168.1.215",6004));
        hostAndPortSet.add(new HostAndPort("192.168.1.215",6005));

        JedisCluster cluster = new JedisCluster(hostAndPortSet,poolConfig);

        String name1 = cluster.get("name:1");
        System.out.println("name:1 -> " + name1);

        cluster.close();
    }


}
