package com.xy2.repository;

import com.xy2.entity.Ttmodel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;


public class TtmodelDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Ttmodel ttmodel) {
        return jdbcTemplate.update("insert into ttmodel  (starthour,endhour,startminute,endminute,seasonstarttime,seasonendtime,currentseason ) values (?,?,?,?,?,?,? )",
                ttmodel.getStarthour(),ttmodel.getEndhour(),ttmodel.getStartminute(),ttmodel.getEndminute(),ttmodel.getSeasonstarttime(),ttmodel.getSeasonendtime(),ttmodel.getCurrentseason());
    }


    public int update(JdbcTemplate jdbcTemplate,Ttmodel ttmodel) {
        return jdbcTemplate.update("UPDATE  ttmodel  SET endhour=?,startminute=?,endminute=?,seasonstarttime=?,seasonendtime=?,currentseason=?"
                        +" where starthour=?",
                ttmodel.getEndhour(),ttmodel.getStartminute(),ttmodel.getEndminute(),ttmodel.getSeasonstarttime(),ttmodel.getSeasonendtime(),ttmodel.getCurrentseason(),
                ttmodel.getStarthour())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from ttmodel where starthour=?",id);
    }


    public Ttmodel findById(JdbcTemplate jdbcTemplate,int id) {
        List<Ttmodel> list = jdbcTemplate.query("select * from ttmodel where starthour=?", new Object[]{id}, new BeanPropertyRowMapper<Ttmodel>(Ttmodel.class));
        if(list!=null && list.size()>0){
            Ttmodel ttmodel = list.get(0);
            return ttmodel;
        }else{
            return null;
        }
    }


    public List<Ttmodel> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Ttmodel> list = jdbcTemplate.query("select * from ttmodel", new Object[]{}, new BeanPropertyRowMapper<Ttmodel>(Ttmodel.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
