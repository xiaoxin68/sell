package com.imooc.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Description:分布式锁
 * @Source: JDK 1.8
 * @author: ZhangXiaoxin
 * @date: 2019/3/14$ 16:46$
 * @Since: 1.0
 */
@Component
@Slf4j
public class RedisLock {

   /*
        怎么使用呢？

        在某段代码之前加锁：if(!lock(productId,当前时间+超时时间)){抛出异常}

        在某段代码结束时：unlock(lock(productId,当前时间+超时时间))
   */

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 加锁
     *
     * @param key
     * @param value 当前时间+超时时间
     * @return
     */
    public boolean lock(String key,String value){
        if (redisTemplate.opsForValue().setIfAbsent(key,value)){
            return true;
        }
        String currentValue = redisTemplate.opsForValue().get(key);
        //如果锁过期
        if (!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis()){
            //获取上一个锁的时间
            String oldValue = redisTemplate.opsForValue().getAndSet(key, value);
            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)){
                return true;
            }
        }
        return false;
    }

    /**
     * 解锁
     *
     * @param key
     * @param value
     */
    public void unLock(String key,String value){
        try {
            String currentValue = redisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)){
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        }catch (Exception e){
            log.info("[redis分布式锁] 解锁时异常，{}",e);
        }
    }
}
