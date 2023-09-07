package com.xy2.repository;

import com.xy2.entity.Salegoods;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;


public class SalegoodsDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Salegoods salegoods) {
        return jdbcTemplate.update("insert into salegoods  (saleid,salename,saletype,otherid,contiontype,flag,uptime,roleid,buyrole,saleprice ) values (?,?,?,?,?,?,?,?,?,? )",
                salegoods.getSaleid(),salegoods.getSalename(),salegoods.getSaletype(),salegoods.getOtherid(),salegoods.getContiontype(),salegoods.getFlag(),salegoods.getUptime(),salegoods.getRoleid(),salegoods.getBuyrole(),salegoods.getSaleprice());
    }


    public int update(JdbcTemplate jdbcTemplate,Salegoods salegoods) {
        return jdbcTemplate.update("UPDATE  salegoods  SET salename=?,saletype=?,otherid=?,contiontype=?,flag=?,uptime=?,roleid=?,buyrole=?,saleprice=?"
                        +" where saleid=?",
                salegoods.getSalename(),salegoods.getSaletype(),salegoods.getOtherid(),salegoods.getContiontype(),salegoods.getFlag(),salegoods.getUptime(),salegoods.getRoleid(),salegoods.getBuyrole(),salegoods.getSaleprice(),
                salegoods.getSaleid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from salegoods where saleid=?",id);
    }


    public Salegoods findById(JdbcTemplate jdbcTemplate,int id) {
        List<Salegoods> list = jdbcTemplate.query("select * from salegoods where saleid=?", new Object[]{id}, new BeanPropertyRowMapper<Salegoods>(Salegoods.class));
        if(list!=null && list.size()>0){
            Salegoods salegoods = list.get(0);
            return salegoods;
        }else{
            return null;
        }
    }


    public List<Salegoods> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Salegoods> list = jdbcTemplate.query("select * from salegoods", new Object[]{}, new BeanPropertyRowMapper<Salegoods>(Salegoods.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

}
