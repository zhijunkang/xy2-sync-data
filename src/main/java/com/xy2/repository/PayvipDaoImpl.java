package com.xy2.repository;

import com.xy2.entity.Payvip;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author kangzhijun
 * @version V1.0
 * @date 2023/9/7 14:42
 * @copyright 北京北大英华科技有限公司-法律科技中心
 * @description TODO
 */
public class PayvipDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Payvip payvip) {
        return jdbcTemplate.update("insert into payvip  (id,paynum,givegoods,grade,instructiontext,increationtext,datetime ) values (?,?,?,?,?,?,? )",
                payvip.getId(),payvip.getPaynum(),payvip.getGivegoods(),payvip.getGrade(),payvip.getInstructiontext(),payvip.getIncreationtext(),payvip.getDatetime());
    }


    public int update(JdbcTemplate jdbcTemplate,Payvip payvip) {
        return jdbcTemplate.update("UPDATE  payvip  SET paynum=?,givegoods=?,grade=?,instructiontext=?,increationtext=?,datetime=?"
                        +" where id=?",
                payvip.getPaynum(),payvip.getGivegoods(),payvip.getGrade(),payvip.getInstructiontext(),payvip.getIncreationtext(),payvip.getDatetime(),
                payvip.getId())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from payvip where id=?",id);
    }


    public Payvip findById(JdbcTemplate jdbcTemplate,int id) {
        List<Payvip> list = jdbcTemplate.query("select * from payvip where id=?", new Object[]{id}, new BeanPropertyRowMapper<Payvip>(Payvip.class));
        if(list!=null && list.size()>0){
            Payvip payvip = list.get(0);
            return payvip;
        }else{
            return null;
        }
    }


    public List<Payvip> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Payvip> list = jdbcTemplate.query("select * from payvip", new Object[]{}, new BeanPropertyRowMapper<Payvip>(Payvip.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}