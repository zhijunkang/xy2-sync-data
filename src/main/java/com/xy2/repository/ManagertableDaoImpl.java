package com.xy2.repository;

import com.xy2.entity.Managertable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ManagertableDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Managertable managertable) {
        return jdbcTemplate.update("insert into managertable  (manaeid,username,pwd,relname,createtime ) values (?,?,?,?,? )",
                managertable.getManaeid(),managertable.getUsername(),managertable.getPwd(),managertable.getRelname(),managertable.getCreatetime());
    }


    public int update(JdbcTemplate jdbcTemplate,Managertable managertable) {
        return jdbcTemplate.update("UPDATE  managertable  SET username=?,pwd=?,relname=?,createtime=?"
                        +" where manaeid=?",
                managertable.getUsername(),managertable.getPwd(),managertable.getRelname(),managertable.getCreatetime(),
                managertable.getManaeid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from managertable where manaeid=?",id);
    }


    public Managertable findById(JdbcTemplate jdbcTemplate,int id) {
        List<Managertable> list = jdbcTemplate.query("select * from managertable where manaeid=?", new Object[]{id}, new BeanPropertyRowMapper<Managertable>(Managertable.class));
        if(list!=null && list.size()>0){
            Managertable managertable = list.get(0);
            return managertable;
        }else{
            return null;
        }
    }


    public List<Managertable> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Managertable> list = jdbcTemplate.query("select * from managertable", new Object[]{}, new BeanPropertyRowMapper<Managertable>(Managertable.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM managertable"), Long.class);
        return maxId == null ? 1L : maxId+1l;
    }
}
