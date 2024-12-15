package com.colak.springtutorial.stringvalue.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


@Service
public class OpsForValueService {

    private final RedisTemplate<String, Object> redisTemplate;

    private final ValueOperations<String, Object> valueOperations;

    public OpsForValueService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.valueOperations = redisTemplate.opsForValue();
    }

    public Boolean delete(String key) {
        return redisTemplate.delete(key);
    }

    public Object getAndExpire(String key, Duration duration) {
        return valueOperations.getAndExpire(key, duration);
    }

    public Object get(String key) {
        return valueOperations.get(key);
    }

    public void set(String key, String value) {
        valueOperations.set(key, value);
    }

    public Boolean setIfAbsent(String key, String value, long timeout, TimeUnit unit) {
        return valueOperations.setIfAbsent(key, value, timeout, unit);
    }

    public Long increment(String key) {
        valueOperations.setIfAbsent(key, 0);
        return valueOperations.increment(key, 1);
    }

}
