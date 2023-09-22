package com.xy2.repository;

import com.xy2.entity.Baby;
import com.xy2.entity.Titletable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
public class TitletableDaoImpl {
    @Transactional(propagation = Propagation.NESTED)
    public int add(JdbcTemplate jdbcTemplate, Titletable titletable) {
        return jdbcTemplate.update("insert into titletable  (titleid,roleid ) values (?,? )",
                titletable.getTitleid(),titletable.getRoleid());
    }


    public int update(JdbcTemplate jdbcTemplate,Titletable titletable) {
        return jdbcTemplate.update("UPDATE  titletable  SET roleid=?"
                        +" where titleid=?",
                titletable.getRoleid(),
                titletable.getTitleid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from titletable where titleid=?",id);
    }


    public Titletable findById(JdbcTemplate jdbcTemplate,int id) {
        List<Titletable> list = jdbcTemplate.query("select * from titletable where titleid=?", new Object[]{id}, new BeanPropertyRowMapper<Titletable>(Titletable.class));
        if(list!=null && list.size()>0){
            Titletable titletable = list.get(0);
            return titletable;
        }else{
            return null;
        }
    }


    public List<Titletable> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Titletable> list = jdbcTemplate.query("select * from titletable", new Object[]{}, new BeanPropertyRowMapper<Titletable>(Titletable.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM titletable"), Long.class);
        return maxId == null ? 1L : maxId+1l;
    }

    public List<Titletable> findAllListByRoleId(JdbcTemplate jdbcTemplate, Long roleId) {
        List<Titletable> list = jdbcTemplate.query("select * from titletable where roleid="+roleId,new Object[]{}, new BeanPropertyRowMapper<Titletable>(Titletable.class));
        return list;
    }
}
