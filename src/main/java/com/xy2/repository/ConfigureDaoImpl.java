package com.xy2.repository;

import com.xy2.entity.Configure;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author kangzhijun
 * @version V1.0
 * @date 2023/9/7 13:51
 * @copyright 北京北大英华科技有限公司-法律科技中心
 * @description TODO
 */
public class ConfigureDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Configure configure) {
        return jdbcTemplate.update("insert into configure  (fsdnum,cjlzgnum ) values (?,? )",
                configure.getFsdnum(),configure.getCjlzgnum());
    }


    public int update(JdbcTemplate jdbcTemplate,Configure configure) {
        return jdbcTemplate.update("UPDATE  configure  SET cjlzgnum=?"
                        +" where fsdnum=?",
                configure.getCjlzgnum(),
                configure.getFsdnum())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from configure where fsdnum=?",id);
    }


    public Configure findById(JdbcTemplate jdbcTemplate,int id) {
        List<Configure> list = jdbcTemplate.query("select * from configure where fsdnum=?", new Object[]{id}, new BeanPropertyRowMapper<Configure>(Configure.class));
        if(list!=null && list.size()>0){
            Configure configure = list.get(0);
            return configure;
        }else{
            return null;
        }
    }


    public List<Configure> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Configure> list = jdbcTemplate.query("select * from configure", new Object[]{}, new BeanPropertyRowMapper<Configure>(Configure.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM configure"), Long.class);
        return maxId;
    }
}
