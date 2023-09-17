package com.xy2.repository;

import com.xy2.entity.Appversion;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 下载管理
 */
@Repository
public class AppversionDaoImpl {


    public int add(JdbcTemplate jdbcTemplate, Appversion appversion) {
        return jdbcTemplate.update("insert into appversion  (ver_id,ver_url ) values (?,? )",
                appversion.getVerId(),appversion.getVerUrl());
    }


    public int update(JdbcTemplate jdbcTemplate,Appversion appversion) {
        return jdbcTemplate.update("UPDATE  appversion  SET ver_url=?"
                        +" where ver_id=?",
                appversion.getVerUrl(),
                appversion.getVerId());

    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from appversion where ver_id=?",id);
    }


    public Appversion findById(JdbcTemplate jdbcTemplate,int id) {
        List<Appversion> list = jdbcTemplate.query("select * from appversion where ver_id=?", new Object[]{id}, new BeanPropertyRowMapper<Appversion>(Appversion.class));
        if(list!=null && list.size()>0){
            Appversion appversion = list.get(0);
            return appversion;
        }else{
            return null;
        }
    }


    public List<Appversion> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Appversion> list = jdbcTemplate.query("select * from appversion", new Object[]{}, new BeanPropertyRowMapper<Appversion>(Appversion.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM APPVERSION"), Long.class);
        return maxId;
    }
}
