package com.xy2.service;

import com.xy2.utils.RedisParameterUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@Service
public class RedisDataSyncService {

    @Resource(name = "sourceRedisTemplate")
    private RedisTemplate<String, Object> sourceRedisTemplate;

    @Resource(name = "targetRedisTemplate")
    private RedisTemplate<String, Object> targetRedisTemplate;

    @Value("${server.area}")
    private String area;

    public void a(){
        Map<Object, Object> entries = sourceRedisTemplate.opsForHash().entries("0001FLY");
        System.out.println(entries);
        Set<Object> pop = targetRedisTemplate.opsForSet().members("0001FLY_10");
        System.out.println(pop);
    }

    public  void insertKey(String key, String filed, String value) {
        Boolean aBoolean = targetRedisTemplate.opsForHash().putIfAbsent(key, filed, value);
        log.info("insertKey key:{} result :{}",key,aBoolean);
    }

    public Long insertListRedis(String key, String id, String value){
        Long okOrNo=null;
        if (id!=null) {

            okOrNo =  targetRedisTemplate.opsForSet().add(key+"_"+id,value);
        }else {
            okOrNo = targetRedisTemplate.opsForSet().add(key,value);
        }
        return okOrNo;
    }

    public void insertRoleControAdd(String key, String id){
        String value =key+":"+id;
        targetRedisTemplate.opsForHash().putIfAbsent(RedisParameterUtil.ROLE_CONTROL, value, "1");
    }

    public void insertRoleControDel(String key, String id){
        String value =key+":"+id;
        targetRedisTemplate.opsForHash().putIfAbsent(RedisParameterUtil.ROLE_CONTROL, value, "3");
    }

    public void insertRoleControUpd(String key, String id){
        String value =key+":"+id;
        targetRedisTemplate.opsForHash().putIfAbsent(RedisParameterUtil.ROLE_CONTROL, value, "2");
    }


    public void sysRedis(){

    }
}
