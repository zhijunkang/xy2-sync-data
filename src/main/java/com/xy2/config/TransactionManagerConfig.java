package com.xy2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

//@EnableTransactionManagement
//@Configuration
//public class TransactionManagerConfig {
//    @Bean(name = "txManager1")
//    @Autowired    //自动注入 dataSource1
//    public PlatformTransactionManager txManager1(@Qualifier("slave_1") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "txManager2")
//    @Autowired    //自动注入 dataSource2
//    public PlatformTransactionManager txManager2(@Qualifier("slave_2") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//}
