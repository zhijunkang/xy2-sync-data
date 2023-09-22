package com.xy2.repository;

import com.xy2.entity.Mount;
import com.xy2.entity.RolrFly;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public class RolrFlyDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, RolrFly rolrFly) {
        return jdbcTemplate.update("insert into rolr_fly  (flyid,flyname,flylevel,role_id,movelevel,fuel ) values (?,?,?,?,?,? )",
                rolrFly.getFlyId(),rolrFly.getFlyName(),rolrFly.getFlyLevel(),rolrFly.getRoleId(),rolrFly.getMoveLevel(),rolrFly.getFuel());
    }

    public int update(JdbcTemplate jdbcTemplate, RolrFly rolrFly) {
        return jdbcTemplate.update("UPDATE  rolr_fly  SET flyname=?,flylevel=?,role_id=?,movelevel=?,fuel=?"
                        +" where flyid=?",
                rolrFly.getFlyName(),rolrFly.getFlyLevel(),rolrFly.getRoleId(),rolrFly.getMoveLevel(),rolrFly.getFuel(),
                rolrFly.getFlyId())
                ;
    }

    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from rolr_fly where flyid=?",id);
    }

    public RolrFly findById(JdbcTemplate jdbcTemplate, int id) {
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
    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM rolr_fly"), Long.class);
        return maxId == null ? 1L : maxId+1l;
    }

    public List<RolrFly> findAllListByRoleId(JdbcTemplate jdbcTemplate, Long roleId) {
        List<RolrFly> list = jdbcTemplate.query("select * from rolr_fly where role_id="+roleId,new Object[]{}, new BeanPropertyRowMapper<RolrFly>(RolrFly.class));
        return list;
    }
}
