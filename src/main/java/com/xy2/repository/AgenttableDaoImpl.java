package com.xy2.repository;

import com.xy2.entity.Agenttable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author 燕赵阿祖
 * 代理表
 */
@Repository
public class AgenttableDaoImpl {


    public int add(JdbcTemplate jdbcTemplate, Agenttable agenttable) {
        return jdbcTemplate.update("insert into agenttable  (tb_id,at_id,at_name,at_qq,at_wx,at_alipayurl,at_wxurl,at_cretime,at_cremanageid,at_upatemanageid,at_upatime ) values (?,?,?,?,?,?,?,?,?,?,? )",
                agenttable.getTbId(), agenttable.getAtId(), agenttable.getAtName(), agenttable.getAtQq(), agenttable.getAtWx(), agenttable.getAtAlipayurl(), agenttable.getAtWxurl(), agenttable.getAtCretime(), agenttable.getAtCremanageid(), agenttable.getAtUpatemanageid(), agenttable.getAtUpatime());
    }

    public int update(JdbcTemplate jdbcTemplate, Agenttable agenttable) {
        return jdbcTemplate.update("UPDATE  agenttable  SET at_id=?,at_name=?,at_qq=?,at_wx=?,at_alipayurl=?,at_wxurl=?,at_cretime=?,at_cremanageid=?,at_upatemanageid=?,at_upatime=?"
                        + " where tb_id=?",
                agenttable.getAtId(), agenttable.getAtName(), agenttable.getAtQq(), agenttable.getAtWx(), agenttable.getAtAlipayurl(), agenttable.getAtWxurl(), agenttable.getAtCretime(), agenttable.getAtCremanageid(), agenttable.getAtUpatemanageid(), agenttable.getAtUpatime(),
                agenttable.getTbId());
    }

    public int delete(JdbcTemplate jdbcTemplate, int id) {
        return jdbcTemplate.update("DELETE from agenttable where tb_id=?", id);
    }

    public Agenttable findById(JdbcTemplate jdbcTemplate, int id) {
        List<Agenttable> list = jdbcTemplate.query("select * from agenttable where tb_id=?", new Object[]{id}, new BeanPropertyRowMapper<Agenttable>(Agenttable.class));
        if (list != null && list.size() > 0) {
            Agenttable agenttable = list.get(0);
            return agenttable;
        } else {
            return null;
        }
    }

    public List<Agenttable> findAllList(JdbcTemplate jdbcTemplate, Map<String, Object> params) {
        List<Agenttable> list = jdbcTemplate.query("select * from agenttable", new Object[]{}, new BeanPropertyRowMapper<Agenttable>(Agenttable.class));
        if (list != null && list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM AGENTTABLE"), Long.class);
        return maxId+1l;
    }
}
