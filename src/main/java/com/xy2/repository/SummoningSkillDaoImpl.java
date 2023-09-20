package com.xy2.repository;

import com.xy2.entity.SummoningSkill;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public class SummoningSkillDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, SummoningSkill summoningSkill) {
        return jdbcTemplate.update("insert into summoning_skill  (skillid,skillname,skilltype,skilllevel,grow,dielectric,value,camp,skillralation,remark,skiid,summoningid ) values (?,?,?,?,?,?,?,?,?,?,?,? )",
                summoningSkill.getSkillid(),summoningSkill.getSkillname(),summoningSkill.getSkilltype(),summoningSkill.getSkilllevel(),summoningSkill.getGrow(),summoningSkill.getDielectric(),summoningSkill.getValue(),summoningSkill.getCamp(),summoningSkill.getSkillralation(),summoningSkill.getRemark(),summoningSkill.getSkiid(),summoningSkill.getSummoningid());
    }


    public int update(JdbcTemplate jdbcTemplate,SummoningSkill summoningSkill) {
        return jdbcTemplate.update("UPDATE  summoning_skill  SET skillname=?,skilltype=?,skilllevel=?,grow=?,dielectric=?,value=?,camp=?,skillralation=?,remark=?,skiid=?,summoningid=?"
                        +" where skillid=?",
                summoningSkill.getSkillname(),summoningSkill.getSkilltype(),summoningSkill.getSkilllevel(),summoningSkill.getGrow(),summoningSkill.getDielectric(),summoningSkill.getValue(),summoningSkill.getCamp(),summoningSkill.getSkillralation(),summoningSkill.getRemark(),summoningSkill.getSkiid(),summoningSkill.getSummoningid(),
                summoningSkill.getSkillid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from summoning_skill where skillid=?",id);
    }


    public SummoningSkill findById(JdbcTemplate jdbcTemplate,int id) {
        List<SummoningSkill> list = jdbcTemplate.query("select * from summoning_skill where skillid=?", new Object[]{id}, new BeanPropertyRowMapper<SummoningSkill>(SummoningSkill.class));
        if(list!=null && list.size()>0){
            SummoningSkill summoningSkill = list.get(0);
            return summoningSkill;
        }else{
            return null;
        }
    }


    public List<SummoningSkill> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<SummoningSkill> list = jdbcTemplate.query("select * from summoning_skill", new Object[]{}, new BeanPropertyRowMapper<SummoningSkill>(SummoningSkill.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM summoning_skill"), Long.class);
        return maxId+1l;
    }
}
