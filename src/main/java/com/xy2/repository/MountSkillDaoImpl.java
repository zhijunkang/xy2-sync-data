package com.xy2.repository;

import com.xy2.entity.MountSkill;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;


public class MountSkillDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, MountSkill mountSkill) {
        return jdbcTemplate.update("insert into mount_skill  (skillid,skillname,remark,mid ) values (?,?,?,? )",
                mountSkill.getSkillid(),mountSkill.getSkillname(),mountSkill.getRemark(),mountSkill.getMid());
    }


    public int update(JdbcTemplate jdbcTemplate,MountSkill mountSkill) {
        return jdbcTemplate.update("UPDATE  mount_skill  SET skillname=?,remark=?,mid=?"
                        +" where skillid=?",
                mountSkill.getSkillname(),mountSkill.getRemark(),mountSkill.getMid(),
                mountSkill.getSkillid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from mount_skill where skillid=?",id);
    }


    public MountSkill findById(JdbcTemplate jdbcTemplate,int id) {
        List<MountSkill> list = jdbcTemplate.query("select * from mount_skill where skillid=?", new Object[]{id}, new BeanPropertyRowMapper<MountSkill>(MountSkill.class));
        if(list!=null && list.size()>0){
            MountSkill mountSkill = list.get(0);
            return mountSkill;
        }else{
            return null;
        }
    }


    public List<MountSkill> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<MountSkill> list = jdbcTemplate.query("select * from mount_skill", new Object[]{}, new BeanPropertyRowMapper<MountSkill>(MountSkill.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
