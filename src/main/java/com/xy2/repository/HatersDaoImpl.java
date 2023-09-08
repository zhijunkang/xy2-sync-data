package com.xy2.repository;

import com.xy2.entity.Haters;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author kangzhijun
 * @version V1.0
 * @date 2023/9/7 14:26
 * @copyright 北京北大英华科技有限公司-法律科技中心
 * @description TODO
 */
public class HatersDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Haters haters) {
        return jdbcTemplate.update("insert into haters  (roleid ) values (? )",
                haters.getRoleid());
    }


    public int update(JdbcTemplate jdbcTemplate,Haters haters) {
        return jdbcTemplate.update("UPDATE  haters  SET "
                        +" where roleid=?",

                haters.getRoleid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from haters where roleid=?",id);
    }


    public Haters findById(JdbcTemplate jdbcTemplate,int id) {
        List<Haters> list = jdbcTemplate.query("select * from haters where roleid=?", new Object[]{id}, new BeanPropertyRowMapper<Haters>(Haters.class));
        if(list!=null && list.size()>0){
            Haters haters = list.get(0);
            return haters;
        }else{
            return null;
        }
    }


    public List<Haters> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Haters> list = jdbcTemplate.query("select * from haters", new Object[]{}, new BeanPropertyRowMapper<Haters>(Haters.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM haters"), Long.class);
        return maxId;
    }
}
