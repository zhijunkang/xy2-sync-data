package com.xy2.repository;

import com.xy2.entity.Shangchengshop;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author kangzhijun
 * @version V1.0
 * @date 2023/9/7 15:04
 * @copyright 北京北大英华科技有限公司-法律科技中心
 * @description TODO
 */
public class ShangchengshopDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Shangchengshop shangchengshop) {
        return jdbcTemplate.update("insert into shangchengshop  (gid,goodsname,goodtype,goodsprice,skin ) values (?,?,?,?,? )",
                shangchengshop.getGid(),shangchengshop.getGoodsname(),shangchengshop.getGoodtype(),shangchengshop.getGoodsprice(),shangchengshop.getSkin());
    }


    public int update(JdbcTemplate jdbcTemplate,Shangchengshop shangchengshop) {
        return jdbcTemplate.update("UPDATE  shangchengshop  SET goodsname=?,goodtype=?,goodsprice=?,skin=?"
                        +" where gid=?",
                shangchengshop.getGoodsname(),shangchengshop.getGoodtype(),shangchengshop.getGoodsprice(),shangchengshop.getSkin(),
                shangchengshop.getGid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from shangchengshop where gid=?",id);
    }


    public Shangchengshop findById(JdbcTemplate jdbcTemplate,int id) {
        List<Shangchengshop> list = jdbcTemplate.query("select * from shangchengshop where gid=?", new Object[]{id}, new BeanPropertyRowMapper<Shangchengshop>(Shangchengshop.class));
        if(list!=null && list.size()>0){
            Shangchengshop shangchengshop = list.get(0);
            return shangchengshop;
        }else{
            return null;
        }
    }


    public List<Shangchengshop> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Shangchengshop> list = jdbcTemplate.query("select * from shangchengshop", new Object[]{}, new BeanPropertyRowMapper<Shangchengshop>(Shangchengshop.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
