package com.xy2.repository;

import com.xy2.entity.Importantrecordgoods;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author kangzhijun
 * @version V1.0
 * @date 2023/9/7 14:29
 * @copyright 北京北大英华科技有限公司-法律科技中心
 * @description TODO
 */
public class ImportantrecordgoodsDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Importantrecordgoods importantrecordgoods) {
        return jdbcTemplate.update("insert into importantrecordgoods  (iid,goodsid,goodsnumber,rocordtype,userid,roleid,sid ) values (?,?,?,?,?,?,? )",
                importantrecordgoods.getIid(),importantrecordgoods.getGoodsid(),importantrecordgoods.getGoodsnumber(),importantrecordgoods.getRocordtype(),importantrecordgoods.getUserid(),importantrecordgoods.getRoleid(),importantrecordgoods.getSid());
    }


    public int update(JdbcTemplate jdbcTemplate,Importantrecordgoods importantrecordgoods) {
        return jdbcTemplate.update("UPDATE  importantrecordgoods  SET goodsid=?,goodsnumber=?,rocordtype=?,userid=?,roleid=?,sid=?"
                        +" where iid=?",
                importantrecordgoods.getGoodsid(),importantrecordgoods.getGoodsnumber(),importantrecordgoods.getRocordtype(),importantrecordgoods.getUserid(),importantrecordgoods.getRoleid(),importantrecordgoods.getSid(),
                importantrecordgoods.getIid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from importantrecordgoods where iid=?",id);
    }


    public Importantrecordgoods findById(JdbcTemplate jdbcTemplate,int id) {
        List<Importantrecordgoods> list = jdbcTemplate.query("select * from importantrecordgoods where iid=?", new Object[]{id}, new BeanPropertyRowMapper<Importantrecordgoods>(Importantrecordgoods.class));
        if(list!=null && list.size()>0){
            Importantrecordgoods importantrecordgoods = list.get(0);
            return importantrecordgoods;
        }else{
            return null;
        }
    }


    public List<Importantrecordgoods> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Importantrecordgoods> list = jdbcTemplate.query("select * from importantrecordgoods", new Object[]{}, new BeanPropertyRowMapper<Importantrecordgoods>(Importantrecordgoods.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM importantrecordgoods"), Long.class);
        return maxId;
    }
}
