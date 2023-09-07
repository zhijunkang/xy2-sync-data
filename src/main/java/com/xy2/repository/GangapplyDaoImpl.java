package com.xy2.repository;

import com.xy2.entity.Gangapply;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author kangzhijun
 * @version V1.0
 * @date 2023/9/7 14:00
 * @copyright 北京北大英华科技有限公司-法律科技中心
 * @description TODO
 */
public class GangapplyDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Gangapply gangapply) {
        return jdbcTemplate.update("insert into gangapply  (gaid,gangid ) values (?,? )",
                gangapply.getGaid(),gangapply.getGangid());
    }


    public int update(JdbcTemplate jdbcTemplate,Gangapply gangapply) {
        return jdbcTemplate.update("UPDATE  gangapply  SET gangid=?"
                        +" where gaid=?",
                gangapply.getGangid(),
                gangapply.getGaid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from gangapply where gaid=?",id);
    }


    public Gangapply findById(JdbcTemplate jdbcTemplate,int id) {
        List<Gangapply> list = jdbcTemplate.query("select * from gangapply where gaid=?", new Object[]{id}, new BeanPropertyRowMapper<Gangapply>(Gangapply.class));
        if(list!=null && list.size()>0){
            Gangapply gangapply = list.get(0);
            return gangapply;
        }else{
            return null;
        }
    }


    public List<Gangapply> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Gangapply> list = jdbcTemplate.query("select * from gangapply", new Object[]{}, new BeanPropertyRowMapper<Gangapply>(Gangapply.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

}