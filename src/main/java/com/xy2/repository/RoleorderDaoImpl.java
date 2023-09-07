package com.xy2.repository;

import com.xy2.entity.Roleorder;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;


public class RoleorderDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Roleorder roleorder) {
        return jdbcTemplate.update("insert into roleorder  (orderid,saleid,buytime,status,roleid ) values (?,?,?,?,? )",
                roleorder.getOrderid(),roleorder.getSaleid(),roleorder.getBuytime(),roleorder.getStatus(),roleorder.getRoleid());
    }


    public int update(JdbcTemplate jdbcTemplate,Roleorder roleorder) {
        return jdbcTemplate.update("UPDATE  roleorder  SET saleid=?,buytime=?,status=?,roleid=?"
                        +" where orderid=?",
                roleorder.getSaleid(),roleorder.getBuytime(),roleorder.getStatus(),roleorder.getRoleid(),
                roleorder.getOrderid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from roleorder where orderid=?",id);
    }


    public Roleorder findById(JdbcTemplate jdbcTemplate,int id) {
        List<Roleorder> list = jdbcTemplate.query("select * from roleorder where orderid=?", new Object[]{id}, new BeanPropertyRowMapper<Roleorder>(Roleorder.class));
        if(list!=null && list.size()>0){
            Roleorder roleorder = list.get(0);
            return roleorder;
        }else{
            return null;
        }
    }


    public List<Roleorder> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Roleorder> list = jdbcTemplate.query("select * from roleorder", new Object[]{}, new BeanPropertyRowMapper<Roleorder>(Roleorder.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
