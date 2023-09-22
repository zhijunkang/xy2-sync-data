package com.xy2.repository;

import com.xy2.entity.Salegoods2;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class Salegoods2DaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Salegoods2 salegoods2) {
        return jdbcTemplate.update("insert into salegoods2  (saleid,salename,saletype,otherid,contiontype,flag,uptime,roleid,buyrole,saleprice ) values (?,?,?,?,?,?,?,?,?,? )",
                salegoods2.getSaleid(),salegoods2.getSalename(),salegoods2.getSaletype(),salegoods2.getOtherid(),salegoods2.getContiontype(),salegoods2.getFlag(),salegoods2.getUptime(),salegoods2.getRoleid(),salegoods2.getBuyrole(),salegoods2.getSaleprice());
    }


    public int update(JdbcTemplate jdbcTemplate,Salegoods2 salegoods2) {
        return jdbcTemplate.update("UPDATE  salegoods2  SET salename=?,saletype=?,otherid=?,contiontype=?,flag=?,uptime=?,roleid=?,buyrole=?,saleprice=?"
                        +" where saleid=?",
                salegoods2.getSalename(),salegoods2.getSaletype(),salegoods2.getOtherid(),salegoods2.getContiontype(),salegoods2.getFlag(),salegoods2.getUptime(),salegoods2.getRoleid(),salegoods2.getBuyrole(),salegoods2.getSaleprice(),
                salegoods2.getSaleid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from salegoods2 where saleid=?",id);
    }


    public Salegoods2 findById(JdbcTemplate jdbcTemplate,int id) {
        List<Salegoods2> list = jdbcTemplate.query("select * from salegoods2 where saleid=?", new Object[]{id}, new BeanPropertyRowMapper<Salegoods2>(Salegoods2.class));
        if(list!=null && list.size()>0){
            Salegoods2 salegoods2 = list.get(0);
            return salegoods2;
        }else{
            return null;
        }
    }


    public List<Salegoods2> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Salegoods2> list = jdbcTemplate.query("select * from salegoods2", new Object[]{}, new BeanPropertyRowMapper<Salegoods2>(Salegoods2.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM salegoods2"), Long.class);
        return maxId == null ? 1L : maxId+1l;
    }
}
