package com.xy2.repository;

import com.xy2.entity.Expensesreceipts;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ExpensesreceiptsDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Expensesreceipts expensesreceipts) {
        return jdbcTemplate.update("insert into expensesreceipts  (erid,playeracc,recharge,playerpay,yuanbao,paytime,sid,type,roleid,returntype,appid,managerid,goodsid,buyrole,sellrole,buyuserid,buyrolebalance,payofprofits,gongshisign,gspayofprofits,buyrolename,sellrolename,buyuseridname ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )",
                expensesreceipts.getErid(),expensesreceipts.getPlayeracc(),expensesreceipts.getRecharge(),expensesreceipts.getPlayerpay(),expensesreceipts.getYuanbao(),expensesreceipts.getPaytime(),expensesreceipts.getSid(),expensesreceipts.getType(),expensesreceipts.getRoleid(),expensesreceipts.getReturntype(),expensesreceipts.getAppid(),expensesreceipts.getManagerid(),expensesreceipts.getGoodsid(),expensesreceipts.getBuyrole(),expensesreceipts.getSellrole(),expensesreceipts.getBuyuserid(),expensesreceipts.getBuyrolebalance(),expensesreceipts.getPayofprofits(),expensesreceipts.getGongshisign(),expensesreceipts.getGspayofprofits(),expensesreceipts.getBuyrolename(),expensesreceipts.getSellrolename(),expensesreceipts.getBuyuseridname());
    }


    public int update(JdbcTemplate jdbcTemplate,Expensesreceipts expensesreceipts) {
        return jdbcTemplate.update("UPDATE  expensesreceipts  SET playeracc=?,recharge=?,playerpay=?,yuanbao=?,paytime=?,sid=?,type=?,roleid=?,returntype=?,appid=?,managerid=?,goodsid=?,buyrole=?,sellrole=?,buyuserid=?,buyrolebalance=?,payofprofits=?,gongshisign=?,gspayofprofits=?,buyrolename=?,sellrolename=?,buyuseridname=?"
                        +" where erid=?",
                expensesreceipts.getPlayeracc(),expensesreceipts.getRecharge(),expensesreceipts.getPlayerpay(),expensesreceipts.getYuanbao(),expensesreceipts.getPaytime(),expensesreceipts.getSid(),expensesreceipts.getType(),expensesreceipts.getRoleid(),expensesreceipts.getReturntype(),expensesreceipts.getAppid(),expensesreceipts.getManagerid(),expensesreceipts.getGoodsid(),expensesreceipts.getBuyrole(),expensesreceipts.getSellrole(),expensesreceipts.getBuyuserid(),expensesreceipts.getBuyrolebalance(),expensesreceipts.getPayofprofits(),expensesreceipts.getGongshisign(),expensesreceipts.getGspayofprofits(),expensesreceipts.getBuyrolename(),expensesreceipts.getSellrolename(),expensesreceipts.getBuyuseridname(),
                expensesreceipts.getErid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from expensesreceipts where erid=?",id);
    }


    public Expensesreceipts findById(JdbcTemplate jdbcTemplate,int id) {
        List<Expensesreceipts> list = jdbcTemplate.query("select * from expensesreceipts where erid=?", new Object[]{id}, new BeanPropertyRowMapper<Expensesreceipts>(Expensesreceipts.class));
        if(list!=null && list.size()>0){
            Expensesreceipts expensesreceipts = list.get(0);
            return expensesreceipts;
        }else{
            return null;
        }
    }


    public List<Expensesreceipts> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Expensesreceipts> list = jdbcTemplate.query("select * from expensesreceipts", new Object[]{}, new BeanPropertyRowMapper<Expensesreceipts>(Expensesreceipts.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM expensesreceipts"), Long.class);
        return maxId;
    }


}
