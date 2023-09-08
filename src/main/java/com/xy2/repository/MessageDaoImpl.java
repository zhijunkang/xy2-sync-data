package com.xy2.repository;

import com.xy2.entity.Message;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;


public class MessageDaoImpl {


    public int add(JdbcTemplate jdbcTemplate,Message message) {
        return jdbcTemplate.update("insert into message  (mesid,roleid,saleid,mescontent ) values (?,?,?,? )",
                message.getMesid(),message.getRoleid(),message.getSaleid(),message.getMescontent());
    }


    public int update(JdbcTemplate jdbcTemplate,Message message) {
        return jdbcTemplate.update("UPDATE  message  SET roleid=?,saleid=?,mescontent=?"
                        +" where mesid=?",
                message.getRoleid(),message.getSaleid(),message.getMescontent(),
                message.getMesid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from message where mesid=?",id);
    }


    public Message findById(JdbcTemplate jdbcTemplate,int id) {
        List<Message> list = jdbcTemplate.query("select * from message where mesid=?", new Object[]{id}, new BeanPropertyRowMapper<Message>(Message.class));
        if(list!=null && list.size()>0){
            Message message = list.get(0);
            return message;
        }else{
            return null;
        }
    }


    public List<Message> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Message> list = jdbcTemplate.query("select * from message", new Object[]{}, new BeanPropertyRowMapper<Message>(Message.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM message"), Long.class);
        return maxId;
    }
}
