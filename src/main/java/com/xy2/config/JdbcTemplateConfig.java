package com.xy2.config;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author 燕赵阿祖
 */
public class JdbcTemplateConfig {
    @Bean(name = "oracleJdbcTemplate1")
    public JdbcTemplate mysqlJdbcTemplate(@Qualifier("slave_1") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "oracleJdbcTemplate2")
    public JdbcTemplate oracleJdbcTemplate(@Qualifier("slave_2") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
//    @Autowired
//    DataSource dataSource;
//
//    @Bean(name = "slave_1JdbcTemplate")
//    public JdbcTemplate mysqlJdbcTemplate() {
//        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
//        return new JdbcTemplate(ds.getDataSource("slave_1"));
//    }
//
//    @Bean(name = "slave_2JdbcTemplate")
//    public JdbcTemplate oracleJdbcTemplate() {
//        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
//        return new JdbcTemplate(ds.getDataSource("slave_2"));
//    }

    }
