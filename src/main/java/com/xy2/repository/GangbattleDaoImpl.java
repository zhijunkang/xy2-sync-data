package com.xy2.repository;

import com.xy2.entity.Gangbattle;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author kangzhijun
 * @version V1.0
 * @date 2023/9/7 13:58
 * @copyright 北京北大英华科技有限公司-法律科技中心
 * @description TODO
 */
public class GangbattleDaoImpl {


    public int add(JdbcTemplate jdbcTemplate, Gangbattle gangbattle) {
        return jdbcTemplate.update("insert into gangbattle  (week ) values (? )",
                gangbattle.getWeek());
    }


    public int update(JdbcTemplate jdbcTemplate,Gangbattle gangbattle) {
        return jdbcTemplate.update("UPDATE  gangbattle  SET "
                        +" where week=?",

                gangbattle.getWeek())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from gangbattle where week=?",id);
    }


    public Gangbattle findById(JdbcTemplate jdbcTemplate,int id) {
        List<Gangbattle> list = jdbcTemplate.query("select * from gangbattle where week=?", new Object[]{id}, new BeanPropertyRowMapper<Gangbattle>(Gangbattle.class));
        if(list!=null && list.size()>0){
            Gangbattle gangbattle = list.get(0);
            return gangbattle;
        }else{
            return null;
        }
    }


    public List<Gangbattle> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Gangbattle> list = jdbcTemplate.query("select * from gangbattle", new Object[]{}, new BeanPropertyRowMapper<Gangbattle>(Gangbattle.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}