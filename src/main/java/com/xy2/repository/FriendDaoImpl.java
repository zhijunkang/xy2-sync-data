package com.xy2.repository;

import com.xy2.entity.Friend;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author kangzhijun
 * @version V1.0
 * @date 2023/9/7 13:54
 * @copyright 北京北大英华科技有限公司-法律科技中心
 * @description TODO
 */
public class FriendDaoImpl {

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

}
