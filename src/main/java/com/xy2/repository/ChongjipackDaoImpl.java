package com.xy2.repository;

import com.xy2.entity.Chongjipack;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ChongjipackDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Chongjipack chongjipack) {
        return jdbcTemplate.update("insert into chongjipack  (id,packtype,packgradetype,packgrade,packgoods,getnumber,datetime,canpaymoney ) values (?,?,?,?,?,?,?,? )",
                chongjipack.getId(),chongjipack.getPacktype(),chongjipack.getPackgradetype(),chongjipack.getPackgrade(),chongjipack.getPackgoods(),chongjipack.getGetnumber(),chongjipack.getDatetime(),chongjipack.getCanpaymoney());
    }


    public int update(JdbcTemplate jdbcTemplate,Chongjipack chongjipack) {
        return jdbcTemplate.update("UPDATE  chongjipack  SET packtype=?,packgradetype=?,packgrade=?,packgoods=?,getnumber=?,datetime=?,canpaymoney=?"
                        +" where id=?",
                chongjipack.getPacktype(),chongjipack.getPackgradetype(),chongjipack.getPackgrade(),chongjipack.getPackgoods(),chongjipack.getGetnumber(),chongjipack.getDatetime(),chongjipack.getCanpaymoney(),
                chongjipack.getId())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from chongjipack where id=?",id);
    }


    public Chongjipack findById(JdbcTemplate jdbcTemplate,int id) {
        List<Chongjipack> list = jdbcTemplate.query("select * from chongjipack where id=?", new Object[]{id}, new BeanPropertyRowMapper<Chongjipack>(Chongjipack.class));
        if(list!=null && list.size()>0){
            Chongjipack chongjipack = list.get(0);
            return chongjipack;
        }else{
            return null;
        }
    }


    public List<Chongjipack> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Chongjipack> list = jdbcTemplate.query("select * from chongjipack", new Object[]{}, new BeanPropertyRowMapper<Chongjipack>(Chongjipack.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM chongjipack"), Long.class);
        return maxId == null ? 1L : maxId+1l;
    }
}
