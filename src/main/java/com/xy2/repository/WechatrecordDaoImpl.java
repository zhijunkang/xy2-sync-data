package com.xy2.repository;

import com.xy2.entity.Wechatrecord;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class WechatrecordDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Wechatrecord wechatrecord) {
        return jdbcTemplate.update("insert into wechatrecord  (chat_id,chat_mes,chat_sendid,chat_getid ) values (?,?,?,? )",
                wechatrecord.getChatId(),wechatrecord.getChatMes(),wechatrecord.getChatSendid(),wechatrecord.getChatGetid());
    }


    public int update(JdbcTemplate jdbcTemplate,Wechatrecord wechatrecord) {
        return jdbcTemplate.update("UPDATE  wechatrecord  SET chat_mes=?,chat_sendid=?,chat_getid=?"
                        +" where chat_id=?",
                wechatrecord.getChatMes(),wechatrecord.getChatSendid(),wechatrecord.getChatGetid(),
                wechatrecord.getChatId())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from wechatrecord where chat_id=?",id);
    }


    public Wechatrecord findById(JdbcTemplate jdbcTemplate,int id) {
        List<Wechatrecord> list = jdbcTemplate.query("select * from wechatrecord where chat_id=?", new Object[]{id}, new BeanPropertyRowMapper<Wechatrecord>(Wechatrecord.class));
        if(list!=null && list.size()>0){
            Wechatrecord wechatrecord = list.get(0);
            return wechatrecord;
        }else{
            return null;
        }
    }


    public List<Wechatrecord> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Wechatrecord> list = jdbcTemplate.query("select * from wechatrecord", new Object[]{}, new BeanPropertyRowMapper<Wechatrecord>(Wechatrecord.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM wechatrecord"), Long.class);
        return maxId;
    }
}
