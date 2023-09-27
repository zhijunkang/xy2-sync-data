package com.xy2.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.xy2.entity.*;
import com.xy2.utils.RedisParameterUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RedisDataSyncService {

    @Resource(name = "sourceRedisTemplate")
    private RedisTemplate<String, Object> sourceRedisTemplate;

    @Resource(name = "targetRedisTemplate")
    private RedisTemplate<String, Object> targetRedisTemplate;

    @Value("${server.area}")
    private String area;


    public  void insertKey(String key, String filed, String value) {
        Boolean aBoolean = targetRedisTemplate.opsForHash().putIfAbsent(key, filed, value);
        log.info("insertKey key:{} result :{}",key,aBoolean);
    }

    public Long insertListRedis(String key, String id, Integer value){
        Long okOrNo=null;
        if (id!=null) {

            okOrNo =  targetRedisTemplate.opsForSet().add(key+"_"+id,value);
        }else {
            okOrNo = targetRedisTemplate.opsForSet().add(key,value);
        }
        return okOrNo;
    }

    public Long insertListRedisLists(String key, String id, List<Integer> value){
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
        targetRedisTemplate.opsForHash().put(area+RedisParameterUtil.ROLE_CONTROL, value, "1");
    }

    public void insertRoleControDel(String key, String id){
        String value =key+":"+id;
        targetRedisTemplate.opsForHash().put(area+RedisParameterUtil.ROLE_CONTROL, value, "3");
    }

    public void insertRoleControUpd(String key, String id){
        String value =key+":"+id;
        targetRedisTemplate.opsForHash().put(area+RedisParameterUtil.ROLE_CONTROL, value, "2");
    }

    public void insertUserContro(String key, String id, String json){
        String value =key+":"+id;
        targetRedisTemplate.opsForHash().put(area+RedisParameterUtil.USER_REDIS, value, json);
    }

    public void insertRoleContro(String key, String id, String json){
        String value =key+":"+id;
        targetRedisTemplate.opsForHash().put(area+RedisParameterUtil.USER_REDIS, value, json);
    }



    List<Goodstable> goodstables = null;
    public List<Goodstable> getReidsGoods(String key, String id){
//        Map<String,Goodstable> map = new HashMap<>();
//        Map<Object, Object> entries = sourceRedisTemplate.opsForHash().entries(key);
//        entries.forEach((k,v)->{
//            System.out.println(k);
//            System.out.println(v);
//        });
        if(ObjectUtil.isEmpty(goodstables)){
            goodstables = BeanUtil.copyToList(sourceRedisTemplate.opsForHash().values(key), Goodstable.class);
        }
        List<Goodstable> collect = goodstables.stream().filter(goodstable -> goodstable.getRoleId().equals(id)).collect(Collectors.toList());
        return collect;
    }


    public List<RoleSummoning> getRoleSummoing(String key, String id){
        List<RoleSummoning> roleSummonings = BeanUtil.copyToList(sourceRedisTemplate.opsForHash().values(key), RoleSummoning.class);
        List<RoleSummoning> collect = roleSummonings.stream().filter(roleSummoning -> roleSummoning.getRoleid().equals(id)).collect(Collectors.toList());
        return collect;
    }

    public List<Mount> getMount(String key, String id){
        List<Mount> mounts = BeanUtil.copyToList(sourceRedisTemplate.opsForHash().values(key), Mount.class);
        List<Mount> collect = mounts.stream().filter(mount -> mount.getRoleid().equals(id)).collect(Collectors.toList());
        return collect;
    }

    public List<Lingbao> getLingbao(String key, String id){
        List<Lingbao> lingbaos = BeanUtil.copyToList(sourceRedisTemplate.opsForHash().values(key), Lingbao.class);
        List<Lingbao> collect = lingbaos.stream().filter(lingbao -> lingbao.getRoleid().equals(id)).collect(Collectors.toList());
        return collect;
    }

    public List<Baby> getBaby(String key, String id){
        List<Baby> babies = BeanUtil.copyToList(sourceRedisTemplate.opsForHash().values(key), Baby.class);
        List<Baby> collect = babies.stream().filter(baby -> baby.getRoleid().equals(id)).collect(Collectors.toList());
        return collect;
    }

    public List<Fly> getFly(String key, String id){
        List<Fly> flyList = BeanUtil.copyToList(sourceRedisTemplate.opsForHash().values(key), Fly.class);
        List<Fly> collect = flyList.stream().filter(fly -> fly.getRoleid().equals(id)).collect(Collectors.toList());
        return collect;
    }

    public List<RolePal> getPal(String key, String id){
        List<RolePal> pals = BeanUtil.copyToList(sourceRedisTemplate.opsForHash().values(key), RolePal.class);
        List<RolePal> collect = pals.stream().filter(pal -> pal.getRoleid().equals(id)).collect(Collectors.toList());
        return collect;
    }
}
