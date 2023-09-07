package com.xy2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author kangzhijun
 * @version V1.0
 * @date 2023/9/6 17:24
 * @copyright 北京北大英华科技有限公司-法律科技中心
 * @description TODO
 */
@Service
public class RedisDataSyncService {
//
//    @Autowired
//    @Qualifier("redisTemplate0")
//    private StringRedisTemplate redisTemplate0;
//
//    @Autowired
//    @Qualifier("redisTemplate1")
//    private StringRedisTemplate redisTemplate1;
//
//    public void a(){
//        redisTemplate0.opsForValue().set("key0", "value0");
//// 获取数据从 Redis 数据库 0
//        Object value0 = redisTemplate0.opsForValue().get("key0");
//// 删除数据从 Redis 数据库 0
//        redisTemplate0.delete("key0");
//
//// 存储数据到 Redis 数据库 1
//        redisTemplate1.opsForValue().set("key1", "value1");
//// 获取数据从 Redis 数据库 1
//        Object value1 = redisTemplate1.opsForValue().get("key1");
//// 删除数据从 Redis 数据库 1
//        redisTemplate1.delete("key1");
//
//    }

}
