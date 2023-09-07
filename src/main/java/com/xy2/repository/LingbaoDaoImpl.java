package com.xy2.repository;

import com.xy2.entity.Lingbao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author kangzhijun
 * @version V1.0
 * @date 2023/9/7 14:32
 * @copyright 北京北大英华科技有限公司-法律科技中心
 * @description TODO
 */
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
}
