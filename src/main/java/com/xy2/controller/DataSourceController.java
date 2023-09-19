package com.xy2.controller;

import cn.hutool.json.JSONUtil;
import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.creator.DefaultDataSourceCreator;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.hikari.HikariCpConfig;
import com.xy2.bean.DataSourceReq;
import com.xy2.service.CheckLianJie;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.Set;

@RestController
@RequestMapping("/datasources")
//@Api(tags = "添加删除数据源")
public class DataSourceController<HikariDataSourceCreator> {
    @Autowired
    DataSource dataSource;

    @Autowired
    DefaultDataSourceCreator dataSourceCreator;

    @Autowired
    private CheckLianJie checkLianJie;


    @GetMapping("/get")
    //@ApiOperation("获取当前所有数据源")
    public String now() {
        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
        return  JSONUtil.toJsonStr(ds.getDataSources());
    }

    @GetMapping("/get/db")
    //@ApiOperation("获取当前所有数据源")
    public String now(@RequestParam("db")String db) {
        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
        DataSource dataSource = ds.getDataSource(db);
        return  JSONUtil.toJsonStr(dataSource);
    }

    @GetMapping("/check/oracle/one")
    public String one() {
        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds.getDataSource("slave_1"));
        String s = jdbcTemplate.queryForObject(String.format("SELECT COUNT(*) FROM USERTABLE"), String.class);
        return s;
    }

    @GetMapping("/check/oracle/two")
    public String two() {
        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds.getDataSource("slave_2"));
        String s = jdbcTemplate.queryForObject(String.format("SELECT COUNT(*) FROM WJTEST.USERTABLE"), String.class);
        return s;
    }

    @GetMapping("/check/redis")
    public boolean checkRedis(@RequestParam("host")String host,@RequestParam("port") String port) {
        boolean b = checkLianJie.checkRidsIsWorking(host, port);
        return b;
    }


    //通用数据源会根据maven中配置的连接池根据顺序依次选择。
    //默认的顺序为druid>hikaricp>beecp>dbcp>spring basic
    @PostMapping("/add/one")
    public Boolean addOne(@Validated @RequestBody DataSourceReq dto) {
        HikariCpConfig hikariCpConfig = new HikariCpConfig();
        hikariCpConfig.setConnectionTestQuery("select 1");
        DataSourceProperty dataSourceProperty = new DataSourceProperty();
        dataSourceProperty.setHikari(hikariCpConfig);
        dataSourceProperty.setPoolName("slave_1");
        dataSourceProperty.setUsername(dto.getUsername());
        dataSourceProperty.setPassword(dto.getPassword());
        dataSourceProperty.setType(SimpleDriverDataSource.class);
        dataSourceProperty.setUrl("jdbc:oracle:thin:@"+dto.getUrl()+":1521:orcl");
        dataSourceProperty.setDriverClassName("oracle.jdbc.driver.OracleDriver");
                   DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
        ds.addDataSource(dataSourceProperty.getPoolName(), dataSourceCreator.createDataSource(dataSourceProperty));
        boolean slave_1 = ds.getDataSources().keySet().contains("slave_1");
        return slave_1;
    }

    @PostMapping("/add/two")
//    @ApiOperation("通用添加数据源（推荐）")
    public Boolean addTwo(@Validated @RequestBody DataSourceReq dto) {
        HikariCpConfig hikariCpConfig = new HikariCpConfig();
        hikariCpConfig.setConnectionTestQuery("select 1");
        DataSourceProperty dataSourceProperty = new DataSourceProperty();
        dataSourceProperty.setHikari(hikariCpConfig);
        dataSourceProperty.setPoolName("slave_2");
        dataSourceProperty.setUsername(dto.getUsername());
        dataSourceProperty.setPassword(dto.getPassword());
        dataSourceProperty.setType(SimpleDriverDataSource.class);
        dataSourceProperty.setUrl("jdbc:oracle:thin:@"+dto.getUrl()+":1521:orcl");
        dataSourceProperty.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
        ds.addDataSource(dataSourceProperty.getPoolName(), dataSourceCreator.createDataSource(dataSourceProperty));
        boolean slave_1 = ds.getDataSources().keySet().contains("slave_2");
        return slave_1;
    }



}
