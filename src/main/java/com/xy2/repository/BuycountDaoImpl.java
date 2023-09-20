package com.xy2.repository;

import com.xy2.entity.Buycount;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 销售统计
 */
@Repository
public class BuycountDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Buycount buycount) {
        return jdbcTemplate.update("insert into buycount  (bid,ptype,shopid,shoptype,totalnum,totalprice,weeknum,weekprice,daynum,dayprice ) values (?,?,?,?,?,?,?,?,?,? )",
                buycount.getBid(),buycount.getPtype(),buycount.getShopid(),buycount.getShoptype(),buycount.getTotalnum(),buycount.getTotalprice(),buycount.getWeeknum(),buycount.getWeekprice(),buycount.getDaynum(),buycount.getDayprice());
    }


    public int update(JdbcTemplate jdbcTemplate,Buycount buycount) {
        return jdbcTemplate.update("UPDATE  buycount  SET ptype=?,shopid=?,shoptype=?,totalnum=?,totalprice=?,weeknum=?,weekprice=?,daynum=?,dayprice=?"
                        +" where bid=?",
                buycount.getPtype(),buycount.getShopid(),buycount.getShoptype(),buycount.getTotalnum(),buycount.getTotalprice(),buycount.getWeeknum(),buycount.getWeekprice(),buycount.getDaynum(),buycount.getDayprice(),
                buycount.getBid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from buycount where bid=?",id);
    }


    public Buycount findById(JdbcTemplate jdbcTemplate,int id) {
        List<Buycount> list = jdbcTemplate.query("select * from buycount where bid=?", new Object[]{id}, new BeanPropertyRowMapper<Buycount>(Buycount.class));
        if(list!=null && list.size()>0){
            Buycount buycount = list.get(0);
            return buycount;
        }else{
            return null;
        }
    }


    public List<Buycount> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Buycount> list = jdbcTemplate.query("select * from buycount", new Object[]{}, new BeanPropertyRowMapper<Buycount>(Buycount.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM buycount"), Long.class);
        return maxId+1l;
    }
}
