package com.xy2.repository;

import com.xy2.entity.Roleshopcart;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class RoleshopcartDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Roleshopcart roleshopcart) {
        return jdbcTemplate.update("insert into roleshopcart  (s_cart_id,goods_id,goods_name,skin,price,gnumber,role_id,type ) values (?,?,?,?,?,?,?,? )",
                roleshopcart.getSCartId(),roleshopcart.getGoodsId(),roleshopcart.getGoodsName(),roleshopcart.getSkin(),roleshopcart.getPrice(),roleshopcart.getGnumber(),roleshopcart.getRoleId(),roleshopcart.getType());
    }


    public int update(JdbcTemplate jdbcTemplate,Roleshopcart roleshopcart) {
        return jdbcTemplate.update("UPDATE  roleshopcart  SET goods_id=?,goods_name=?,skin=?,price=?,gnumber=?,role_id=?,type=?"
                        +" where s_cart_id=?",
                roleshopcart.getGoodsId(),roleshopcart.getGoodsName(),roleshopcart.getSkin(),roleshopcart.getPrice(),roleshopcart.getGnumber(),roleshopcart.getRoleId(),roleshopcart.getType(),
                roleshopcart.getSCartId())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from roleshopcart where s_cart_id=?",id);
    }


    public Roleshopcart findById(JdbcTemplate jdbcTemplate,int id) {
        List<Roleshopcart> list = jdbcTemplate.query("select * from roleshopcart where s_cart_id=?", new Object[]{id}, new BeanPropertyRowMapper<Roleshopcart>(Roleshopcart.class));
        if(list!=null && list.size()>0){
            Roleshopcart roleshopcart = list.get(0);
            return roleshopcart;
        }else{
            return null;
        }
    }


    public List<Roleshopcart> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Roleshopcart> list = jdbcTemplate.query("select * from roleshopcart", new Object[]{}, new BeanPropertyRowMapper<Roleshopcart>(Roleshopcart.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM roleshopcart"), Long.class);
        return maxId;
    }
}
