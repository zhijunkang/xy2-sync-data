package com.xy2.repository;

import com.xy2.entity.RolrFly;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class RolrFlyDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, RolrFly rolrFly) {
        return jdbcTemplate.update("insert into rolr_fly  (flyid,flyname,flylevel,role_id,movelevel,fuel ) values (?,?,?,?,?,? )",
                rolrFly.getFlyId(),rolrFly.getFlyName(),rolrFly.getFlyLevel(),rolrFly.getRoleId(),rolrFly.getMoveLevel(),rolrFly.getFuel());
    }

    public int update(JdbcTemplate jdbcTemplate,RolrFly rolrFly) {
        return jdbcTemplate.update("UPDATE  rolr_fly  SET flyname=?,flylevel=?,role_id=?,movelevel=?,fuel=?"
                        +" where flyid=?",
                rolrFly.getFlyName(),rolrFly.getFlyLevel(),rolrFly.getRoleId(),rolrFly.getMoveLevel(),rolrFly.getFuel(),
                rolrFly.getFlyId())
                ;
    }

    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from rolr_fly where flyid=?",id);
    }

    public RolrFly findById(JdbcTemplate jdbcTemplate,int id) {
        List<RolrFly> list = jdbcTemplate.query("select * from rolr_fly where flyid=?", new Object[]{id}, new BeanPropertyRowMapper<RolrFly>(RolrFly.class));
        if(list!=null && list.size()>0){
            RolrFly rolrFly = list.get(0);
            return rolrFly;
        }else{
            return null;
        }
    }

    public List<RolrFly> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<RolrFly> list = jdbcTemplate.query("select * from rolr_fly", new Object[]{}, new BeanPropertyRowMapper<RolrFly>(RolrFly.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }


}
