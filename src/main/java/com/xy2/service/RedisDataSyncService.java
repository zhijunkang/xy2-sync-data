package com.xy2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Service
public class RedisDataSyncService {

    @Resource(name = "sourceRedisTemplate")
    private RedisTemplate<String, Object> sourceRedisTemplate;

    @Resource(name = "targetRedisTemplate")
    private RedisTemplate<String, Object> targetRedisTemplate;

    public void a(){
        Map<Object, Object> entries = sourceRedisTemplate.opsForHash().entries("0001FLY");
        System.out.println(entries);
        Set<Object> pop = targetRedisTemplate.opsForSet().members("0001FLY_10");
        System.out.println(pop);
    }

}
