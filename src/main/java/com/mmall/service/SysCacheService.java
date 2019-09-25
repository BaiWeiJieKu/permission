package com.mmall.service;

import com.google.common.base.Joiner;
import com.mmall.beans.CacheKeyConstants;
import com.mmall.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;

import javax.annotation.Resource;
/**
 * 处理缓存cache
 * @author Administrator
 *
 */

@Service
@Slf4j
public class SysCacheService {

    @Resource(name = "redisPool")
    private RedisPool redisPool;
    /**
     * 保存cache
     * @param toSavedValue
     * @param timeoutSeconds
     * @param prefix
     */
    public void saveCache(String toSavedValue, int timeoutSeconds, CacheKeyConstants prefix) {
        saveCache(toSavedValue, timeoutSeconds, prefix, null);
    }

    public void saveCache(String toSavedValue, int timeoutSeconds, CacheKeyConstants prefix, String... keys) {
        //需要缓存的值为空，返回
    	if (toSavedValue == null) {
            return;
        }
        //获取连接
        ShardedJedis shardedJedis = null;
        try {
        	//生成缓存的key
            String cacheKey = generateCacheKey(prefix, keys);
            //创建Redis实例
            shardedJedis = redisPool.instance();
            //执行缓存操作
            shardedJedis.setex(cacheKey, timeoutSeconds, toSavedValue);
        } catch (Exception e) {
            log.error("save cache exception, prefix:{}, keys:{}", prefix.name(), JsonMapper.obj2String(keys), e);
        } finally {
            redisPool.safeClose(shardedJedis);
        }
    }
    /**
     * 获取cache
     * @param prefix
     * @param keys
     * @return
     */
    public String getFromCache(CacheKeyConstants prefix, String... keys) {
        ShardedJedis shardedJedis = null;
        String cacheKey = generateCacheKey(prefix, keys);
        try {
            shardedJedis = redisPool.instance();
            //根据key获取缓存数据
            String value = shardedJedis.get(cacheKey);
            return value;
        } catch (Exception e) {
            log.error("get from cache exception, prefix:{}, keys:{}", prefix.name(), JsonMapper.obj2String(keys), e);
            return null;
        } finally {
            redisPool.safeClose(shardedJedis);
        }
    }
    /**
     * 自动生成缓存的key
     * @param prefix
     * @param keys
     * @return
     */
    private String generateCacheKey(CacheKeyConstants prefix, String... keys) {
        //从枚举中获取前缀
    	String key = prefix.name();
    	//进行key的拼接
        if (keys != null && keys.length > 0) {
            key += "_" + Joiner.on("_").join(keys);
        }
        return key;
    }
}
