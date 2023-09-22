package com.xy2.service;

import com.xy2.entity.Gang;
import com.xy2.repository.GangDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author kangzhijun
 * @version V1.0
 * @date 2023/9/21 14:41
 * @copyright 北京北大英华科技有限公司-法律科技中心
 * @description TODO
 */
@Service
public class GangService {

    @Autowired
    private GangDaoImpl gangDao;

    //封装帮派数据
    public List<Gang> gangDataBuilds(JdbcTemplate jdbcTemplate1) {
        List<Gang> allList = gangDao.findAllList(jdbcTemplate1, null);
        return allList;
    }

    public Long topId(JdbcTemplate jdbcTemplate, String zd) {
        return   gangDao.topId(jdbcTemplate, "gangid");
    }

    public boolean isGangNameExists(JdbcTemplate jdbcTemplate, String gangname) {
        return gangDao.isGangNameExists(jdbcTemplate,gangname);
    }

    @Transactional(propagation = Propagation.NESTED)
    public int add(JdbcTemplate jdbcTemplate, Gang gang) {
        return gangDao.add(jdbcTemplate, gang);
    }
}
