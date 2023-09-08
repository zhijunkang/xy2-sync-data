package com.xy2.service;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.xy2.entity.Agenttable;
import com.xy2.entity.Usertable;
import com.xy2.repository.AgenttableDaoImpl;
import com.xy2.repository.UsertableDaoImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;
import java.util.Objects;

/**
 * @author kangzhijun
 * @version V1.0
 * @date 2023/9/6 17:23
 * @copyright 北京北大英华科技有限公司-法律科技中心
 * @description TODO
 */
@Slf4j
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

    @Transactional
    public void findAll() {
        try{
            this.syncUserTable();
        }catch (Exception e){
        log.error("sync 异常  本次同步 回滚到最初状态！！！",e);
        }
        System.out.println("success");

    }

    @Autowired
    private AgenttableDaoImpl agenttableDao;

    //代理表同步
    private void syncAgenttable() {
        //查询是否有数据需要合并
        List<Agenttable> allList = agenttableDao.findAllList(jdbcTemplate1, null);
        if (ObjectUtil.isAllEmpty(allList)) {
            return;
        }

        allList.forEach(a -> {
            //数据源1的数据到数据源2里面查找id是否已存 不存在 直接新增 已存在 查询最大的id 在现有ID上面递增
            Agenttable byId = agenttableDao.findById(jdbcTemplate2, Integer.parseInt(a.getAtId()));
            if (Objects.isNull(byId)) {
                agenttableDao.add(jdbcTemplate2, byId);
            } else {
                agenttableDao.topId(jdbcTemplate2, "tb_id");
            }
        });
    }

    @Autowired
    private UsertableDaoImpl usertableDao;

    //用户表同步
    private void syncUserTable() {
        //查询是否有数据需要合并
        List<Usertable> allList = usertableDao.findAllList(jdbcTemplate1);
        if (ObjectUtil.isAllEmpty(allList)) {
            return;
        }

        allList.forEach(u -> {
            //数据源1的数据到数据源2里面查找id是否已存 不存在 直接新增 已存在 查询最大的id 在现有ID上面递增
            Usertable userId = usertableDao.findById(jdbcTemplate2, Integer.parseInt(u.getUserId()));
            if (Objects.isNull(userId)) {
                String usernameExists = usertableDao.isUsernameExists(jdbcTemplate2, u.getUsername());
                if (StrUtil.isBlank(usernameExists)) {
                    usertableDao.add(jdbcTemplate2, u);
                } else {
                    u.setUsername(usernameExists);
                    usertableDao.add(jdbcTemplate2, u);
                }
                //校验账号是否以存在
                usertableDao.add(jdbcTemplate2, u);
            } else {
                Long user_id = usertableDao.topId(jdbcTemplate2, "user_id");
                String usernameExists = usertableDao.isUsernameExists(jdbcTemplate2, u.getUsername());
                long newUserId = user_id + 1000L;
                u.setUserId(String.valueOf(newUserId));
                if (StrUtil.isBlank(usernameExists)) {
                    usertableDao.add(jdbcTemplate2, u);
                } else {
                    u.setUsername(usernameExists);
                    usertableDao.add(jdbcTemplate2, u);
                }
            }
        });
    }


}
