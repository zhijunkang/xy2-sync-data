package com.xy2.repository;

import com.xy2.entity.Goodsrecord;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author kangzhijun
 * @version V1.0
 * @date 2023/9/7 14:18
 * @copyright 北京北大英华科技有限公司-法律科技中心
 * @description TODO
 */
public class GoodsrecordDaoImpl {

    public int add(JdbcTemplate jdbcTemplate,Goodsrecord goodsrecord) {
        return jdbcTemplate.update("insert into goodsrecord  (grid,recordtype,roleid,otherrole,goods,recordtime,goodsnum,rolename ) values (?,?,?,?,?,?,?,? )",
                goodsrecord.getGrid(),goodsrecord.getRecordtype(),goodsrecord.getRoleid(),goodsrecord.getOtherrole(),goodsrecord.getGoods(),goodsrecord.getRecordtime(),goodsrecord.getGoodsnum(),goodsrecord.getRolename());
    }

    public int update(JdbcTemplate jdbcTemplate,Goodsrecord goodsrecord) {
        return jdbcTemplate.update("UPDATE  goodsrecord  SET recordtype=?,roleid=?,otherrole=?,goods=?,recordtime=?,goodsnum=?,rolename=?"
                        +" where grid=?",
                goodsrecord.getRecordtype(),goodsrecord.getRoleid(),goodsrecord.getOtherrole(),goodsrecord.getGoods(),goodsrecord.getRecordtime(),goodsrecord.getGoodsnum(),goodsrecord.getRolename(),
                goodsrecord.getGrid())
                ;
    }

    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from goodsrecord where grid=?",id);
    }

    public Goodsrecord findById(JdbcTemplate jdbcTemplate,int id) {
        List<Goodsrecord> list = jdbcTemplate.query("select * from goodsrecord where grid=?", new Object[]{id}, new BeanPropertyRowMapper<Goodsrecord>(Goodsrecord.class));
        if(list!=null && list.size()>0){
            Goodsrecord goodsrecord = list.get(0);
            return goodsrecord;
        }else{
            return null;
        }
    }


    public List<Goodsrecord> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Goodsrecord> list = jdbcTemplate.query("select * from goodsrecord", new Object[]{}, new BeanPropertyRowMapper<Goodsrecord>(Goodsrecord.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

}