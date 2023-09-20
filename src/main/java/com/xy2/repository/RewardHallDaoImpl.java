package com.xy2.repository;

import com.xy2.entity.RewardHall;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class RewardHallDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, RewardHall rewardHall) {
        return jdbcTemplate.update("insert into reward_hall  (id,goodstable,goodnum,goodprice,role_id ) values (?,?,?,?,? )",
                rewardHall.getId(),rewardHall.getGoodstable(),rewardHall.getGoodnum(),rewardHall.getGoodprice(),rewardHall.getRoleId());
    }


    public int update(JdbcTemplate jdbcTemplate,RewardHall rewardHall) {
        return jdbcTemplate.update("UPDATE  reward_hall  SET goodstable=?,goodnum=?,goodprice=?,role_id=?"
                        +" where id=?",
                rewardHall.getGoodstable(),rewardHall.getGoodnum(),rewardHall.getGoodprice(),rewardHall.getRoleId(),
                rewardHall.getId())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from reward_hall where id=?",id);
    }


    public RewardHall findById(JdbcTemplate jdbcTemplate,int id) {
        List<RewardHall> list = jdbcTemplate.query("select * from reward_hall where id=?", new Object[]{id}, new BeanPropertyRowMapper<RewardHall>(RewardHall.class));
        if(list!=null && list.size()>0){
            RewardHall rewardHall = list.get(0);
            return rewardHall;
        }else{
            return null;
        }
    }


    public List<RewardHall> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<RewardHall> list = jdbcTemplate.query("select * from reward_hall", new Object[]{}, new BeanPropertyRowMapper<RewardHall>(RewardHall.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM reward_hall"), Long.class);
        return maxId+1l;
    }
}
