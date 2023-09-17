package com.xy2.repository;

import com.xy2.entity.Lingbao;
import com.xy2.entity.RolrFly;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class LingbaoDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Lingbao lingbao) {
        return jdbcTemplate.update("insert into lingbao  (baoid,baoname,gethard,baotype,baoactive,baospeed,baoreply,baoshot,baoap,resistshot,assistance,goodskill,roleid,skin,skillsum,fusum,lingbaolvl,lingbaoexe,lingbaoqihe,skills,kangxing,equipment,baoquality,tianfuskill ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )",
                lingbao.getBaoid(),lingbao.getBaoname(),lingbao.getGethard(),lingbao.getBaotype(),lingbao.getBaoactive(),lingbao.getBaospeed(),lingbao.getBaoreply(),lingbao.getBaoshot(),lingbao.getBaoap(),lingbao.getResistshot(),lingbao.getAssistance(),lingbao.getGoodskill(),lingbao.getRoleid(),lingbao.getSkin(),lingbao.getSkillsum(),lingbao.getFusum(),lingbao.getLingbaolvl(),lingbao.getLingbaoexe(),lingbao.getLingbaoqihe(),lingbao.getSkills(),lingbao.getKangxing(),lingbao.getEquipment(),lingbao.getBaoquality(),lingbao.getTianfuskill());
    }


    public int update(JdbcTemplate jdbcTemplate,Lingbao lingbao) {
        return jdbcTemplate.update("UPDATE  lingbao  SET baoname=?,gethard=?,baotype=?,baoactive=?,baospeed=?,baoreply=?,baoshot=?,baoap=?,resistshot=?,assistance=?,goodskill=?,roleid=?,skin=?,skillsum=?,fusum=?,lingbaolvl=?,lingbaoexe=?,lingbaoqihe=?,skills=?,kangxing=?,equipment=?,baoquality=?,tianfuskill=?"
                        +" where baoid=?",
                lingbao.getBaoname(),lingbao.getGethard(),lingbao.getBaotype(),lingbao.getBaoactive(),lingbao.getBaospeed(),lingbao.getBaoreply(),lingbao.getBaoshot(),lingbao.getBaoap(),lingbao.getResistshot(),lingbao.getAssistance(),lingbao.getGoodskill(),lingbao.getRoleid(),lingbao.getSkin(),lingbao.getSkillsum(),lingbao.getFusum(),lingbao.getLingbaolvl(),lingbao.getLingbaoexe(),lingbao.getLingbaoqihe(),lingbao.getSkills(),lingbao.getKangxing(),lingbao.getEquipment(),lingbao.getBaoquality(),lingbao.getTianfuskill(),
                lingbao.getBaoid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from lingbao where baoid=?",id);
    }


    public Lingbao findById(JdbcTemplate jdbcTemplate,int id) {
        List<Lingbao> list = jdbcTemplate.query("select * from lingbao where baoid=?", new Object[]{id}, new BeanPropertyRowMapper<Lingbao>(Lingbao.class));
        if(list!=null && list.size()>0){
            Lingbao lingbao = list.get(0);
            return lingbao;
        }else{
            return null;
        }
    }


    public List<Lingbao> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Lingbao> list = jdbcTemplate.query("select * from lingbao", new Object[]{}, new BeanPropertyRowMapper<Lingbao>(Lingbao.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM lingbao"), Long.class);
        return maxId;
    }

    public List<Lingbao> findAllListByRoleId(JdbcTemplate jdbcTemplate, Long roleId) {
        List<Lingbao> list = jdbcTemplate.query("select * from lingbao where roleid="+roleId,new Object[]{}, new BeanPropertyRowMapper<Lingbao>(Lingbao.class));
        return list;
    }
}
