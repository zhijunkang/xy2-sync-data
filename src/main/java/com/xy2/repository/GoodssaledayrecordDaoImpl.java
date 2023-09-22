package com.xy2.repository;

import com.xy2.entity.Goodssaledayrecord;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class GoodssaledayrecordDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Goodssaledayrecord goodssaledayrecord) {
        return jdbcTemplate.update("insert into goodssaledayrecord  (id,gid,buysum,paysum ) values (?,?,?,? )",
                goodssaledayrecord.getId(),goodssaledayrecord.getGid(),goodssaledayrecord.getBuysum(),goodssaledayrecord.getPaysum());
    }


    public int update(JdbcTemplate jdbcTemplate,Goodssaledayrecord goodssaledayrecord) {
        return jdbcTemplate.update("UPDATE  goodssaledayrecord  SET gid=?,buysum=?,paysum=?"
                        +" where id=?",
                goodssaledayrecord.getGid(),goodssaledayrecord.getBuysum(),goodssaledayrecord.getPaysum(),
                goodssaledayrecord.getId())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from goodssaledayrecord where id=?",id);
    }


    public Goodssaledayrecord findById(JdbcTemplate jdbcTemplate,int id) {
        List<Goodssaledayrecord> list = jdbcTemplate.query("select * from goodssaledayrecord where id=?", new Object[]{id}, new BeanPropertyRowMapper<Goodssaledayrecord>(Goodssaledayrecord.class));
        if(list!=null && list.size()>0){
            Goodssaledayrecord goodssaledayrecord = list.get(0);
            return goodssaledayrecord;
        }else{
            return null;
        }
    }


    public List<Goodssaledayrecord> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Goodssaledayrecord> list = jdbcTemplate.query("select * from goodssaledayrecord", new Object[]{}, new BeanPropertyRowMapper<Goodssaledayrecord>(Goodssaledayrecord.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM goodssaledayrecord"), Long.class);
        return maxId == null ? 1L : maxId+1l;
    }

}
