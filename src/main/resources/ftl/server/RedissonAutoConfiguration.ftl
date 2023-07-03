package ${packageName}.server.configuration;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;

import javax.annotation.Resource;
import java.lang.reflect.Method;

@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class RedissonAutoConfiguration {

    @Resource
    private RedisProperties redisProperties;

    @Bean
    public RedissonClient redissonClient() {

        Config config = new Config();
        String prefix = "redis://";
        Method method = ReflectionUtils.findMethod(RedisProperties.class, "isSsl");

        if (method != null && ((Boolean) ReflectionUtils.invokeMethod(method, redisProperties))) {
            prefix = "rediss://";
        }
        config.useSingleServer().setAddress(prefix + redisProperties.getHost() + ":" + redisProperties.getPort())
        .setConnectTimeout(3000).setDatabase(redisProperties.getDatabase())
        .setPassword(redisProperties.getPassword());
        config.setCodec(new JsonJacksonCodec());
        return Redisson.create(config);
    }

}
