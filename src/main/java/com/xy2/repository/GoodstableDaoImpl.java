package com.xy2.repository;

import com.xy2.entity.Goodstable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author kangzhijun
 * @version V1.0
 * @date 2023/9/7 14:23
 * @copyright 北京北大英华科技有限公司-法律科技中心
 * @description TODO
 */
public class GoodstableDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Goodstable goodstable) {
        return jdbcTemplate.update("insert into goodstable  (goodsid,goodsname,skin,type,quality,value,instruction,rgid,role_id,status,usetime,defineprice,mapname,mapx,mapy,price,codecard ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )",
                goodstable.getGoodsid(),goodstable.getGoodsname(),goodstable.getSkin(),goodstable.getType(),goodstable.getQuality(),goodstable.getValue(),goodstable.getInstruction(),goodstable.getRgid(),goodstable.getRoleId(),goodstable.getStatus(),goodstable.getUsetime(),goodstable.getDefineprice(),goodstable.getMapname(),goodstable.getMapx(),goodstable.getMapy(),goodstable.getPrice(),goodstable.getCodecard());
    }


    public int update(JdbcTemplate jdbcTemplate,Goodstable goodstable) {
        return jdbcTemplate.update("UPDATE  goodstable  SET goodsname=?,skin=?,type=?,quality=?,value=?,instruction=?,rgid=?,role_id=?,status=?,usetime=?,defineprice=?,mapname=?,mapx=?,mapy=?,price=?,codecard=?"
                        +" where goodsid=?",
                goodstable.getGoodsname(),goodstable.getSkin(),goodstable.getType(),goodstable.getQuality(),goodstable.getValue(),goodstable.getInstruction(),goodstable.getRgid(),goodstable.getRoleId(),goodstable.getStatus(),goodstable.getUsetime(),goodstable.getDefineprice(),goodstable.getMapname(),goodstable.getMapx(),goodstable.getMapy(),goodstable.getPrice(),goodstable.getCodecard(),
                goodstable.getGoodsid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from goodstable where goodsid=?",id);
    }


    public Goodstable findById(JdbcTemplate jdbcTemplate,int id) {
        List<Goodstable> list = jdbcTemplate.query("select * from goodstable where goodsid=?", new Object[]{id}, new BeanPropertyRowMapper<Goodstable>(Goodstable.class));
        if(list!=null && list.size()>0){
            Goodstable goodstable = list.get(0);
            return goodstable;
        }else{
            return null;
        }
    }


    public List<Goodstable> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Goodstable> list = jdbcTemplate.query("select * from goodstable", new Object[]{}, new BeanPropertyRowMapper<Goodstable>(Goodstable.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
