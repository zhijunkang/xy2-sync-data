package com.xy2.repository;

import com.xy2.entity.Openareatable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class OpenareatableDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Openareatable openareatable) {
        return jdbcTemplate.update("insert into openareatable  (tb_id,ot_areaid,ot_areaname,ot_belong,ot_distribution,ot_atid,ot_cretime,ot_ctremanageid,ot_upatemanageid,ot_updatetime,ot_memo,maxonline,nowonline ) values (?,?,?,?,?,?,?,?,?,?,?,?,? )",
                openareatable.getTbId(),openareatable.getOtAreaid(),openareatable.getOtAreaname(),openareatable.getOtBelong(),openareatable.getOtDistribution(),openareatable.getOtAtid(),openareatable.getOtCretime(),openareatable.getOtCtremanageid(),openareatable.getOtUpatemanageid(),openareatable.getOtUpdatetime(),openareatable.getOtMemo(),openareatable.getMaxonline(),openareatable.getNowonline());
    }


    public int update(JdbcTemplate jdbcTemplate,Openareatable openareatable) {
        return jdbcTemplate.update("UPDATE  openareatable  SET ot_areaid=?,ot_areaname=?,ot_belong=?,ot_distribution=?,ot_atid=?,ot_cretime=?,ot_ctremanageid=?,ot_upatemanageid=?,ot_updatetime=?,ot_memo=?,maxonline=?,nowonline=?"
                        +" where tb_id=?",
                openareatable.getOtAreaid(),openareatable.getOtAreaname(),openareatable.getOtBelong(),openareatable.getOtDistribution(),openareatable.getOtAtid(),openareatable.getOtCretime(),openareatable.getOtCtremanageid(),openareatable.getOtUpatemanageid(),openareatable.getOtUpdatetime(),openareatable.getOtMemo(),openareatable.getMaxonline(),openareatable.getNowonline(),
                openareatable.getTbId())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from openareatable where tb_id=?",id);
    }


    public Openareatable findById(JdbcTemplate jdbcTemplate,int id) {
        List<Openareatable> list = jdbcTemplate.query("select * from openareatable where tb_id=?", new Object[]{id}, new BeanPropertyRowMapper<Openareatable>(Openareatable.class));
        if(list!=null && list.size()>0){
            Openareatable openareatable = list.get(0);
            return openareatable;
        }else{
            return null;
        }
    }


    public List<Openareatable> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Openareatable> list = jdbcTemplate.query("select * from openareatable", new Object[]{}, new BeanPropertyRowMapper<Openareatable>(Openareatable.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM openareatable"), Long.class);
        return maxId == null ? 1L : maxId+1l;
    }
}
