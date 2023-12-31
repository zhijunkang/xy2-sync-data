package com.xy2.repository;

import com.xy2.entity.Goodsbuyrecord;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class GoodsbuyrecordDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Goodsbuyrecord goodsbuyrecord) {
        return jdbcTemplate.update("insert into goodsbuyrecord  (bid,gid,price,buytype,goodnumber,numbermoney,recordtime,userid,roleid ) values (?,?,?,?,?,?,?,?,? )",
                goodsbuyrecord.getBid(), goodsbuyrecord.getGid(), goodsbuyrecord.getPrice(), goodsbuyrecord.getBuytype(), goodsbuyrecord.getGoodnumber(), goodsbuyrecord.getNumbermoney(), goodsbuyrecord.getRecordtime(), goodsbuyrecord.getUserid(), goodsbuyrecord.getRoleid());
    }


    public int update(JdbcTemplate jdbcTemplate,Goodsbuyrecord goodsbuyrecord) {
        return jdbcTemplate.update("UPDATE  goodsbuyrecord  SET gid=?,price=?,buytype=?,goodnumber=?,numbermoney=?,recordtime=?,userid=?,roleid=?"
                        + " where bid=?",
                goodsbuyrecord.getGid(), goodsbuyrecord.getPrice(), goodsbuyrecord.getBuytype(), goodsbuyrecord.getGoodnumber(), goodsbuyrecord.getNumbermoney(), goodsbuyrecord.getRecordtime(), goodsbuyrecord.getUserid(), goodsbuyrecord.getRoleid(),
                goodsbuyrecord.getBid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from goodsbuyrecord where bid=?", id);
    }


    public Goodsbuyrecord findById(JdbcTemplate jdbcTemplate,int id) {
        List<Goodsbuyrecord> list = jdbcTemplate.query("select * from goodsbuyrecord where bid=?", new Object[]{id}, new BeanPropertyRowMapper<Goodsbuyrecord>(Goodsbuyrecord.class));
        if (list != null && list.size() > 0) {
            Goodsbuyrecord goodsbuyrecord = list.get(0);
            return goodsbuyrecord;
        } else {
            return null;
        }
    }


    public List<Goodsbuyrecord> findAllList(JdbcTemplate jdbcTemplate, Map<String, Object> params) {
        List<Goodsbuyrecord> list = jdbcTemplate.query("select * from goodsbuyrecord", new Object[]{}, new BeanPropertyRowMapper<Goodsbuyrecord>(Goodsbuyrecord.class));
        if (list != null && list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM goodsbuyrecord"), Long.class);
        return maxId == null ? 1L : maxId+1l;
    }
}
