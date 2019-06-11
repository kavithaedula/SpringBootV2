package com.springboot.v2.intercetors;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration of application caches.
 */
@Configuration
@EnableCaching(proxyTargetClass = true)
public class CacheConfig {

    /**
     * Backed by the EhCache CacheManager, this allows us to use the caches declared in ehcache.xml as spring beans.
     *
     * @return Spring CacheManager
     */
    @Bean(name = "springCacheManager")
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }
}
