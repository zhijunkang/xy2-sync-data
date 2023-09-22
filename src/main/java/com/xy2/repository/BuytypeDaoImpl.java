package com.xy2.repository;

import com.xy2.entity.Buytype;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BuytypeDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Buytype buytype) {
        return jdbcTemplate.update("insert into buytype  (tid,buytype,typename ) values (?,?,? )",
                buytype.getTid(),buytype.getBuytype(),buytype.getTypename());
    }


    public int update(JdbcTemplate jdbcTemplate,Buytype buytype) {
        return jdbcTemplate.update("UPDATE  buytype  SET buytype=?,typename=?"
                        +" where tid=?",
                buytype.getBuytype(),buytype.getTypename(),
                buytype.getTid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from buytype where tid=?",id);
    }


    public Buytype findById(JdbcTemplate jdbcTemplate,int id) {
        List<Buytype> list = jdbcTemplate.query("select * from buytype where tid=?", new Object[]{id}, new BeanPropertyRowMapper<Buytype>(Buytype.class));
        if(list!=null && list.size()>0){
            Buytype buytype = list.get(0);
            return buytype;
        }else{
            return null;
        }
    }


    public List<Buytype> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Buytype> list = jdbcTemplate.query("select * from buytype", new Object[]{}, new BeanPropertyRowMapper<Buytype>(Buytype.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM buytype"), Long.class);
        return maxId == null ? 1L : maxId+1l;
    }
}
