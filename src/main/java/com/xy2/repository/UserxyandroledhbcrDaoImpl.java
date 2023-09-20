package com.xy2.repository;

import com.xy2.entity.Userxyandroledhbcr;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserxyandroledhbcrDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Userxyandroledhbcr userxyandroledhbcr) {
        return jdbcTemplate.update("insert into userxyandroledhbcr  (id,userid,username,roleid,rolename,type,xsum,xdsum,dsum,sssum,time,sid ) values (?,?,?,?,?,?,?,?,?,?,?,? )",
                userxyandroledhbcr.getId(),userxyandroledhbcr.getUserid(),userxyandroledhbcr.getUsername(),userxyandroledhbcr.getRoleid(),userxyandroledhbcr.getRolename(),userxyandroledhbcr.getType(),userxyandroledhbcr.getXsum(),userxyandroledhbcr.getXdsum(),userxyandroledhbcr.getDsum(),userxyandroledhbcr.getSssum(),userxyandroledhbcr.getTime(),userxyandroledhbcr.getSid());
    }


    public int update(JdbcTemplate jdbcTemplate,Userxyandroledhbcr userxyandroledhbcr) {
        return jdbcTemplate.update("UPDATE  userxyandroledhbcr  SET userid=?,username=?,roleid=?,rolename=?,type=?,xsum=?,xdsum=?,dsum=?,sssum=?,time=?,sid=?"
                        +" where id=?",
                userxyandroledhbcr.getUserid(),userxyandroledhbcr.getUsername(),userxyandroledhbcr.getRoleid(),userxyandroledhbcr.getRolename(),userxyandroledhbcr.getType(),userxyandroledhbcr.getXsum(),userxyandroledhbcr.getXdsum(),userxyandroledhbcr.getDsum(),userxyandroledhbcr.getSssum(),userxyandroledhbcr.getTime(),userxyandroledhbcr.getSid(),
                userxyandroledhbcr.getId())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from userxyandroledhbcr where id=?",id);
    }


    public Userxyandroledhbcr findById(JdbcTemplate jdbcTemplate,int id) {
        List<Userxyandroledhbcr> list = jdbcTemplate.query("select * from userxyandroledhbcr where id=?", new Object[]{id}, new BeanPropertyRowMapper<Userxyandroledhbcr>(Userxyandroledhbcr.class));
        if(list!=null && list.size()>0){
            Userxyandroledhbcr userxyandroledhbcr = list.get(0);
            return userxyandroledhbcr;
        }else{
            return null;
        }
    }


    public List<Userxyandroledhbcr> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Userxyandroledhbcr> list = jdbcTemplate.query("select * from userxyandroledhbcr", new Object[]{}, new BeanPropertyRowMapper<Userxyandroledhbcr>(Userxyandroledhbcr.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM userxyandroledhbcr"), Long.class);
        return maxId+1l;
    }
}
