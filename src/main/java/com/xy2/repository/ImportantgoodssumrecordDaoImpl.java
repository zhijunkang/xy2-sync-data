package com.xy2.repository;

import com.xy2.entity.Importantgoodssumrecord;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author kangzhijun
 * @version V1.0
 * @date 2023/9/7 14:27
 * @copyright 北京北大英华科技有限公司-法律科技中心
 * @description TODO
 */
public class ImportantgoodssumrecordDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Importantgoodssumrecord importantgoodssumrecord) {
        return jdbcTemplate.update("insert into importantgoodssumrecord  (id,gid,goodnumber,datetime ) values (?,?,?,? )",
                importantgoodssumrecord.getId(),importantgoodssumrecord.getGid(),importantgoodssumrecord.getGoodnumber(),importantgoodssumrecord.getDatetime());
    }


    public int update(JdbcTemplate jdbcTemplate,Importantgoodssumrecord importantgoodssumrecord) {
        return jdbcTemplate.update("UPDATE  importantgoodssumrecord  SET gid=?,goodnumber=?,datetime=?"
                        +" where id=?",
                importantgoodssumrecord.getGid(),importantgoodssumrecord.getGoodnumber(),importantgoodssumrecord.getDatetime(),
                importantgoodssumrecord.getId())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from importantgoodssumrecord where id=?",id);
    }


    public Importantgoodssumrecord findById(JdbcTemplate jdbcTemplate,int id) {
        List<Importantgoodssumrecord> list = jdbcTemplate.query("select * from importantgoodssumrecord where id=?", new Object[]{id}, new BeanPropertyRowMapper<Importantgoodssumrecord>(Importantgoodssumrecord.class));
        if(list!=null && list.size()>0){
            Importantgoodssumrecord importantgoodssumrecord = list.get(0);
            return importantgoodssumrecord;
        }else{
            return null;
        }
    }


    public List<Importantgoodssumrecord> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Importantgoodssumrecord> list = jdbcTemplate.query("select * from importantgoodssumrecord", new Object[]{}, new BeanPropertyRowMapper<Importantgoodssumrecord>(Importantgoodssumrecord.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM importantgoodssumrecord"), Long.class);
        return maxId;
    }
}
