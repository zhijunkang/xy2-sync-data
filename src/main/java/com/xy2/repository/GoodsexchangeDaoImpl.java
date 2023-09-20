package com.xy2.repository;

import com.xy2.entity.Goodsexchange;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class GoodsexchangeDaoImpl {


    public int add(JdbcTemplate jdbcTemplate,Goodsexchange goodsexchange) {
        return jdbcTemplate.update("insert into goodsexchange  (goodsguid,flag,goodsid ) values (?,?,? )",
                goodsexchange.getGoodsguid(),goodsexchange.getFlag(),goodsexchange.getGoodsid());
    }

    public int update(JdbcTemplate jdbcTemplate,Goodsexchange goodsexchange) {
        return jdbcTemplate.update("UPDATE  goodsexchange  SET flag=?,goodsid=?"
                        +" where goodsguid=?",
                goodsexchange.getFlag(),goodsexchange.getGoodsid(),
                goodsexchange.getGoodsguid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from goodsexchange where goodsguid=?",id);
    }


    public Goodsexchange findById(JdbcTemplate jdbcTemplate,int id) {
        List<Goodsexchange> list = jdbcTemplate.query("select * from goodsexchange where goodsguid=?", new Object[]{id}, new BeanPropertyRowMapper<Goodsexchange>(Goodsexchange.class));
        if(list!=null && list.size()>0){
            Goodsexchange goodsexchange = list.get(0);
            return goodsexchange;
        }else{
            return null;
        }
    }


    public List<Goodsexchange> findAllList(JdbcTemplate jdbcTemplate,Map<String,Object> params) {
        List<Goodsexchange> list = jdbcTemplate.query("select * from goodsexchange", new Object[]{}, new BeanPropertyRowMapper<Goodsexchange>(Goodsexchange.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM goodsexchange"), Long.class);
        return maxId+1l;
    }

}
