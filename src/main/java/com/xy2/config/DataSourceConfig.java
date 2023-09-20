package com.xy2.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 燕赵阿祖
 */
@Configuration
public class DataSourceConfig {
    @Primary
    @Bean(name = "slave_1")
    @ConfigurationProperties(prefix = "spring.datasource.oracle1")
    public DataSource slave_1() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "slave_2")
    @ConfigurationProperties(prefix = "spring.datasource.oracle2")
    public DataSource slave_2() {
        return DataSourceBuilder.create().build();
    }


}
