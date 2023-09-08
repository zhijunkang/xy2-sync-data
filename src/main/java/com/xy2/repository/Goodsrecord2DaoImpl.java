package com.xy2.repository;

import com.xy2.entity.Goodsrecord2;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author kangzhijun
 * @version V1.0
 * @date 2023/9/7 14:21
 * @copyright 北京北大英华科技有限公司-法律科技中心
 * @description TODO
 */
public class Goodsrecord2DaoImpl {


    public int add(JdbcTemplate jdbcTemplate,Goodsrecord2 goodsrecord2) {
        return jdbcTemplate.update("insert into goodsrecord2  (grid,recordtype,roleid,otherrole,goods,recordtime,goodsnum,sid,goodsname,value,usetime,goodsid,skin,type,quality,instruction,rgid,status,defineprice ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )",
                goodsrecord2.getGrid(),goodsrecord2.getRecordtype(),goodsrecord2.getRoleid(),goodsrecord2.getOtherrole(),goodsrecord2.getGoods(),goodsrecord2.getRecordtime(),goodsrecord2.getGoodsnum(),goodsrecord2.getSid(),goodsrecord2.getGoodsname(),goodsrecord2.getValue(),goodsrecord2.getUsetime(),goodsrecord2.getGoodsid(),goodsrecord2.getSkin(),goodsrecord2.getType(),goodsrecord2.getQuality(),goodsrecord2.getInstruction(),goodsrecord2.getRgid(),goodsrecord2.getStatus(),goodsrecord2.getDefineprice());
    }


    public int update(JdbcTemplate jdbcTemplate,Goodsrecord2 goodsrecord2) {
        return jdbcTemplate.update("UPDATE  goodsrecord2  SET recordtype=?,roleid=?,otherrole=?,goods=?,recordtime=?,goodsnum=?,sid=?,goodsname=?,value=?,usetime=?,goodsid=?,skin=?,type=?,quality=?,instruction=?,rgid=?,status=?,defineprice=?"
                        +" where grid=?",
                goodsrecord2.getRecordtype(),goodsrecord2.getRoleid(),goodsrecord2.getOtherrole(),goodsrecord2.getGoods(),goodsrecord2.getRecordtime(),goodsrecord2.getGoodsnum(),goodsrecord2.getSid(),goodsrecord2.getGoodsname(),goodsrecord2.getValue(),goodsrecord2.getUsetime(),goodsrecord2.getGoodsid(),goodsrecord2.getSkin(),goodsrecord2.getType(),goodsrecord2.getQuality(),goodsrecord2.getInstruction(),goodsrecord2.getRgid(),goodsrecord2.getStatus(),goodsrecord2.getDefineprice(),
                goodsrecord2.getGrid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from goodsrecord2 where grid=?",id);
    }


    public Goodsrecord2 findById(JdbcTemplate jdbcTemplate,int id) {
        List<Goodsrecord2> list = jdbcTemplate.query("select * from goodsrecord2 where grid=?", new Object[]{id}, new BeanPropertyRowMapper<Goodsrecord2>(Goodsrecord2.class));
        if(list!=null && list.size()>0){
            Goodsrecord2 goodsrecord2 = list.get(0);
            return goodsrecord2;
        }else{
            return null;
        }
    }


    public List<Goodsrecord2> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Goodsrecord2> list = jdbcTemplate.query("select * from goodsrecord2", new Object[]{}, new BeanPropertyRowMapper<Goodsrecord2>(Goodsrecord2.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM goodsrecord2"), Long.class);
        return maxId;
    }

}
