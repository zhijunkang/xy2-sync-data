package com.xy2.service;

import com.xy2.entity.Agenttable;
import com.xy2.entity.Usertable;
import com.xy2.repository.AgenttableDaoImpl;
import com.xy2.repository.UsertableDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

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

    private static JdbcTemplate jdbcTemplate1;

    private static JdbcTemplate jdbcTemplate2;

    @Autowired
    private void setJdbcTemplate1() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(oracleDataSource1);
        OracleDataSyncService.setJdbcTemplate1Factory(jdbcTemplate);
    }

    private static void setJdbcTemplate1Factory(JdbcTemplate factory) {
        OracleDataSyncService.jdbcTemplate1 = factory;
    }

    @Autowired
    private void setJdbcTemplate2() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(oracleDataSource2);
        OracleDataSyncService.setJdbcTemplate2Factory(jdbcTemplate);
    }

    private static void setJdbcTemplate2Factory(JdbcTemplate factory) {
        OracleDataSyncService.jdbcTemplate2 = factory;
    }

    @Autowired
    private UsertableDaoImpl usertableDao;

    @Autowired
    private AgenttableDaoImpl agenttableDao;

    public void findAll() {

//        List<Usertable> allList = usertableDao.findAllList(jdbcTemplate1);
//
//        List<Usertable> allList1 = usertableDao.findAllList(jdbcTemplate2);

        agenttableDao.findAllList(jdbcTemplate1, null)

        System.out.println("success");

    }

}
