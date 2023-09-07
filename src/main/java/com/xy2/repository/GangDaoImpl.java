package com.xy2.repository;

import com.xy2.entity.Gang;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author kangzhijun
 * @version V1.0
 * @date 2023/9/7 13:56
 * @copyright 北京北大英华科技有限公司-法律科技中心
 * @description TODO
 */
public class GangDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Gang gang) {
        return jdbcTemplate.update("insert into gang  (gangid,gangname,gangnumber,pkvalue,builder,property,ganggrade,founder,gangbelong,introduction,gangtxt ) values (?,?,?,?,?,?,?,?,?,?,? )",
                gang.getGangid(),gang.getGangname(),gang.getGangnumber(),gang.getPkvalue(),gang.getBuilder(),gang.getProperty(),gang.getGanggrade(),gang.getFounder(),gang.getGangbelong(),gang.getIntroduction(),gang.getGangtxt());
    }


    public int update(JdbcTemplate jdbcTemplate,Gang gang) {
        return jdbcTemplate.update("UPDATE  gang  SET gangname=?,gangnumber=?,pkvalue=?,builder=?,property=?,ganggrade=?,founder=?,gangbelong=?,introduction=?,gangtxt=?"
                        +" where gangid=?",
                gang.getGangname(),gang.getGangnumber(),gang.getPkvalue(),gang.getBuilder(),gang.getProperty(),gang.getGanggrade(),gang.getFounder(),gang.getGangbelong(),gang.getIntroduction(),gang.getGangtxt(),
                gang.getGangid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from gang where gangid=?",id);
    }


    public Gang findById(JdbcTemplate jdbcTemplate,int id) {
        List<Gang> list = jdbcTemplate.query("select * from gang where gangid=?", new Object[]{id}, new BeanPropertyRowMapper<Gang>(Gang.class));
        if(list!=null && list.size()>0){
            Gang gang = list.get(0);
            return gang;
        }else{
            return null;
        }
    }


    public List<Gang> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Gang> list = jdbcTemplate.query("select * from gang", new Object[]{}, new BeanPropertyRowMapper<Gang>(Gang.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
