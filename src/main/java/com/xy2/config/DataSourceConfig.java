package com.xy2.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author 燕赵阿祖
 */
@Configuration
public class DataSourceConfig {
    @Bean(name = "oracle1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.oracle1")
    public DataSource oracle1DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "oracle2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.oracle2")
    public DataSource oracle2DataSource() {
        return DataSourceBuilder.create().build();
    }

}
