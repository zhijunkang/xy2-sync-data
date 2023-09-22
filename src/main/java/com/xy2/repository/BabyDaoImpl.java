package com.xy2.repository;

import com.xy2.entity.Baby;
import com.xy2.entity.Lingbao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author 燕赵阿祖
 * 孩子数据
 */
@Repository
public class BabyDaoImpl {
    @Transactional(propagation = Propagation.NESTED)
    public int add(JdbcTemplate jdbcTemplate, Baby baby) {
        return jdbcTemplate.update("insert into baby  (babyid,babyname,qizhi,neili,zhili,naili,mingqi,daode,panni,wanxing,qingmi,xiaoxin,wenbao,pilao,yangyujin,roleid,babyage,childsex,outcome,talents,parts ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )",
                baby.getBabyid(),baby.getBabyname(),baby.getQizhi(),baby.getNeili(),baby.getZhili(),baby.getNaili(),baby.getMingqi(),baby.getDaode(),baby.getPanni(),baby.getWanxing(),baby.getQingmi(),baby.getXiaoxin(),baby.getWenbao(),baby.getPilao(),baby.getYangyujin(),baby.getRoleid(),baby.getBabyage(),baby.getChildsex(),baby.getOutcome(),baby.getTalents(),baby.getParts());
    }


    public int update(JdbcTemplate jdbcTemplate,Baby baby) {
        return jdbcTemplate.update("UPDATE  baby  SET babyname=?,qizhi=?,neili=?,zhili=?,naili=?,mingqi=?,daode=?,panni=?,wanxing=?,qingmi=?,xiaoxin=?,wenbao=?,pilao=?,yangyujin=?,roleid=?,babyage=?,childsex=?,outcome=?,talents=?,parts=?"
                        +" where babyid=?",
                baby.getBabyname(),baby.getQizhi(),baby.getNeili(),baby.getZhili(),baby.getNaili(),baby.getMingqi(),baby.getDaode(),baby.getPanni(),baby.getWanxing(),baby.getQingmi(),baby.getXiaoxin(),baby.getWenbao(),baby.getPilao(),baby.getYangyujin(),baby.getRoleid(),baby.getBabyage(),baby.getChildsex(),baby.getOutcome(),baby.getTalents(),baby.getParts(),
                baby.getBabyid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from baby where babyid=?",id);
    }


    public Baby findById(JdbcTemplate jdbcTemplate,int id) {
        List<Baby> list = jdbcTemplate.query("select * from baby where babyid=?", new Object[]{id}, new BeanPropertyRowMapper<Baby>(Baby.class));
        if(list!=null && list.size()>0){
            Baby baby = list.get(0);
            return baby;
        }else{
            return null;
        }
    }


    public List<Baby> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Baby> list = jdbcTemplate.query("select * from baby", new Object[]{}, new BeanPropertyRowMapper<Baby>(Baby.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM baby"), Long.class);
        return maxId == null ? 1L : maxId+1l;
    }

    public List<Baby> findAllListByRoleId(JdbcTemplate jdbcTemplate, Long roleId) {
        List<Baby> list = jdbcTemplate.query("select * from baby where roleid="+roleId,new Object[]{}, new BeanPropertyRowMapper<Baby>(Baby.class));
        return list;
    }
}
