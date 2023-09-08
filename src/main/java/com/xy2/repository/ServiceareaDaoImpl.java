package com.xy2.repository;

import com.xy2.entity.Servicearea;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;


public class ServiceareaDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Servicearea servicearea) {
        return jdbcTemplate.update("insert into servicearea  (sid,sname,sdate,agents,dividedinto ) values (?,?,?,?,? )",
                servicearea.getSid(),servicearea.getSname(),servicearea.getSdate(),servicearea.getAgents(),servicearea.getDividedinto());
    }


    public int update(JdbcTemplate jdbcTemplate,Servicearea servicearea) {
        return jdbcTemplate.update("UPDATE  servicearea  SET sname=?,sdate=?,agents=?,dividedinto=?"
                        +" where sid=?",
                servicearea.getSname(),servicearea.getSdate(),servicearea.getAgents(),servicearea.getDividedinto(),
                servicearea.getSid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from servicearea where sid=?",id);
    }


    public Servicearea findById(JdbcTemplate jdbcTemplate,int id) {
        List<Servicearea> list = jdbcTemplate.query("select * from servicearea where sid=?", new Object[]{id}, new BeanPropertyRowMapper<Servicearea>(Servicearea.class));
        if(list!=null && list.size()>0){
            Servicearea servicearea = list.get(0);
            return servicearea;
        }else{
            return null;
        }
    }


    public List<Servicearea> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Servicearea> list = jdbcTemplate.query("select * from servicearea", new Object[]{}, new BeanPropertyRowMapper<Servicearea>(Servicearea.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM servicearea"), Long.class);
        return maxId;
    }
}
