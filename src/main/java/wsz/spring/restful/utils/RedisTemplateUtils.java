package wsz.spring.restful.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
/**
 * 调整序列化方式
 * @author wsz
 */
@Configuration
public class RedisTemplateUtils {
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate;
	
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Bean
    public RedisTemplate redisTemplateInit(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return this.redisTemplate;
    }
}
