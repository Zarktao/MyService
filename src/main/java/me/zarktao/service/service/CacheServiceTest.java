package me.zarktao.service.service;

import me.zarktao.service.models.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Created by yt005 on 2017/5/9.
 * <p>
 * 测试缓存是否生效
 */

@Component
public class CacheServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(CacheServiceTest.class);

    @Cacheable(value = "test-cache", keyGenerator = "wiselyKeyGenerator", cacheManager = "cacheManager")
    public User getUser(String id) {
        logger.info("===Not from cache.===");
        return new User();
    }
}
