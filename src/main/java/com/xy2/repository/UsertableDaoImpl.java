package com.xy2.repository;

import com.xy2.entity.Usertable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author kangzhijun
 * @version V1.0
 * @date 2023/9/7 13:21
 * @copyright 北京北大英华科技有限公司-法律科技中心
 * @description TODO
 */
@Repository
public class UsertableDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Usertable usertable) {
        return jdbcTemplate.update("insert into usertable  (user_id,username,userpwd,activity,vip,frient_id,safety,idcard,codecard,money,qid,usermoney,userlastlogin,phonenumber,phonetime,loginip,registerip,flag,userregidtsertime ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )",
                usertable.getUserId(), usertable.getUsername(), usertable.getUserpwd(), usertable.getActivity(), usertable.getVip(), usertable.getFrientId(), usertable.getSafety(), usertable.getIdcard(), usertable.getCodecard(), usertable.getMoney(), usertable.getQid(), usertable.getUsermoney(), usertable.getUserlastlogin(), usertable.getPhonenumber(), usertable.getPhonetime(), usertable.getLoginip(), usertable.getRegisterip(), usertable.getFlag(), usertable.getUserregidtsertime());
    }

    public int update(JdbcTemplate jdbcTemplate, Usertable usertable) {
        return jdbcTemplate.update("UPDATE  usertable  SET username=?,userpwd=?,activity=?,vip=?,frient_id=?,safety=?,idcard=?,codecard=?,money=?,qid=?,usermoney=?,userlastlogin=?,phonenumber=?,phonetime=?,loginip=?,registerip=?,flag=?,userregidtsertime=?"
                        + " where user_id=?",
                usertable.getUsername(), usertable.getUserpwd(), usertable.getActivity(), usertable.getVip(), usertable.getFrientId(), usertable.getSafety(), usertable.getIdcard(), usertable.getCodecard(), usertable.getMoney(), usertable.getQid(), usertable.getUsermoney(), usertable.getUserlastlogin(), usertable.getPhonenumber(), usertable.getPhonetime(), usertable.getLoginip(), usertable.getRegisterip(), usertable.getFlag(), usertable.getUserregidtsertime(),
                usertable.getUserId());
    }

    public int delete(JdbcTemplate jdbcTemplate, int id) {
        return jdbcTemplate.update("DELETE from usertable where user_id=?", id);
    }

    public Usertable findById(JdbcTemplate jdbcTemplate, int id) {
        List<Usertable> list = jdbcTemplate.query("select * from usertable where user_id=?", new Object[]{id}, new BeanPropertyRowMapper<Usertable>(Usertable.class));
        if (list != null && list.size() > 0) {
            Usertable usertable = list.get(0);
            return usertable;
        } else {
            return null;
        }
    }

    public List<Usertable> findAllList(JdbcTemplate jdbcTemplate) {
        List<Usertable> list = jdbcTemplate.query("select * from usertable", new Object[]{}, new BeanPropertyRowMapper<Usertable>(Usertable.class));
        if (list != null && list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }
}
