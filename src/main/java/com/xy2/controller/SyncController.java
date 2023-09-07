package com.xy2.controller;

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

    @GetMapping("/sync/o")
    public void syncOracle() {
    }
    @GetMapping("/sync/r")
    public void syncRedis() {
    }



}
