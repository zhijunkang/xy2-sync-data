package com.xy2.repository;

import com.xy2.entity.Friend;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
public class FriendDaoImpl {
    //@Transactional(propagation = Propagation.NESTED)
    public int add(JdbcTemplate jdbcTemplate, Friend friend) {
        return jdbcTemplate.update("insert into friend  (fid,roleid ) values (?,? )",
                friend.getFid(),friend.getRoleid());
    }


    public int update(JdbcTemplate jdbcTemplate,Friend friend) {
        return jdbcTemplate.update("UPDATE  friend  SET roleid=?"
                        +" where fid=?",
                friend.getRoleid(),
                friend.getFid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from friend where fid=?",id);
    }


    public Friend findById(JdbcTemplate jdbcTemplate,int id) {
        List<Friend> list = jdbcTemplate.query("select * from friend where fid=?", new Object[]{id}, new BeanPropertyRowMapper<Friend>(Friend.class));
        if(list!=null && list.size()>0){
            Friend friend = list.get(0);
            return friend;
        }else{
            return null;
        }
    }


    public List<Friend> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Friend> list = jdbcTemplate.query("select * from friend", new Object[]{}, new BeanPropertyRowMapper<Friend>(Friend.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }


    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM friend"), Long.class);
        return maxId == null ? 1L : maxId+1l;
    }
}
