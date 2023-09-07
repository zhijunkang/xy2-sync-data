package com.xy2.controller;

import com.xy2.service.OracleDataSyncService;
import com.xy2.service.RedisDataSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 燕赵阿祖
 */
@RestController
public class SyncController {

    @Autowired
    private RedisDataSyncService redisDataSyncService;
    @Autowired
    private OracleDataSyncService oracleDataSyncService;
    @GetMapping("/sync/o")
    public void syncOracle() {
        oracleDataSyncService.findAll();
    }
    @GetMapping("/sync/r")
    public void syncRedis() {
        redisDataSyncService.a();
    }



}
