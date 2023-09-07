package com.xy2.repository;

import com.xy2.entity.GoodstableFault;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author kangzhijun
 * @version V1.0
 * @date 2023/9/7 14:25
 * @copyright 北京北大英华科技有限公司-法律科技中心
 * @description TODO
 */
public class GoodstableFaultDaoImpl {


    public int add(JdbcTemplate jdbcTemplate, GoodstableFault goodstableFault) {
        return jdbcTemplate.update("insert into goodstable_fault  (goodsid,goodsname,skin,type,quality,value,instruction,rgid,role_id,status,usetime,defineprice,mapname,mapx,mapy,price,codecard ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )",
                goodstableFault.getGoodsid(),goodstableFault.getGoodsname(),goodstableFault.getSkin(),goodstableFault.getType(),goodstableFault.getQuality(),goodstableFault.getValue(),goodstableFault.getInstruction(),goodstableFault.getRgid(),goodstableFault.getRoleId(),goodstableFault.getStatus(),goodstableFault.getUsetime(),goodstableFault.getDefineprice(),goodstableFault.getMapname(),goodstableFault.getMapx(),goodstableFault.getMapy(),goodstableFault.getPrice(),goodstableFault.getCodecard());
    }


    public int update(JdbcTemplate jdbcTemplate,GoodstableFault goodstableFault) {
        return jdbcTemplate.update("UPDATE  goodstable_fault  SET goodsname=?,skin=?,type=?,quality=?,value=?,instruction=?,rgid=?,role_id=?,status=?,usetime=?,defineprice=?,mapname=?,mapx=?,mapy=?,price=?,codecard=?"
                        +" where goodsid=?",
                goodstableFault.getGoodsname(),goodstableFault.getSkin(),goodstableFault.getType(),goodstableFault.getQuality(),goodstableFault.getValue(),goodstableFault.getInstruction(),goodstableFault.getRgid(),goodstableFault.getRoleId(),goodstableFault.getStatus(),goodstableFault.getUsetime(),goodstableFault.getDefineprice(),goodstableFault.getMapname(),goodstableFault.getMapx(),goodstableFault.getMapy(),goodstableFault.getPrice(),goodstableFault.getCodecard(),
                goodstableFault.getGoodsid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from goodstable_fault where goodsid=?",id);
    }


    public GoodstableFault findById(JdbcTemplate jdbcTemplate,int id) {
        List<GoodstableFault> list = jdbcTemplate.query("select * from goodstable_fault where goodsid=?", new Object[]{id}, new BeanPropertyRowMapper<GoodstableFault>(GoodstableFault.class));
        if(list!=null && list.size()>0){
            GoodstableFault goodstableFault = list.get(0);
            return goodstableFault;
        }else{
            return null;
        }
    }


    public List<GoodstableFault> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<GoodstableFault> list = jdbcTemplate.query("select * from goodstable_fault", new Object[]{}, new BeanPropertyRowMapper<GoodstableFault>(GoodstableFault.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
