package com.xy2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

/**
 * @author kangzhijun
 * @version V1.0
 * @date 2023/9/6 17:23
 * @copyright 北京北大英华科技有限公司-法律科技中心
 * @description TODO
 */
@Service
public class OracleDataSyncService {

    @Autowired
    @Qualifier("oracle1DataSource")
    private DataSource oracleDataSource1;

    @Autowired
    @Qualifier("oracle2DataSource")
    private DataSource oracleDataSource2;

//    public void findAll() {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(oracleDataSource1);
//        String sql = "SELECT * FROM user";
//        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
//    }

}
