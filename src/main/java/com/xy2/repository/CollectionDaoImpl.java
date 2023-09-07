package com.xy2.repository;

import com.xy2.entity.Collection;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author kangzhijun
 * @version V1.0
 * @date 2023/9/7 13:50
 * @copyright 北京北大英华科技有限公司-法律科技中心
 * @description TODO
 */
public class CollectionDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Collection collection) {
        return jdbcTemplate.update("insert into collection  (colid,saleid ) values (?,? )",
                collection.getColid(),collection.getSaleid());
    }


    public int update(JdbcTemplate jdbcTemplate,Collection collection) {
        return jdbcTemplate.update("UPDATE  collection  SET saleid=?"
                        +" where colid=?",
                collection.getSaleid(),
                collection.getColid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from collection where colid=?",id);
    }


    public Collection findById(JdbcTemplate jdbcTemplate,int id) {
        List<Collection> list = jdbcTemplate.query("select * from collection where colid=?", new Object[]{id}, new BeanPropertyRowMapper<Collection>(Collection.class));
        if(list!=null && list.size()>0){
            Collection collection = list.get(0);
            return collection;
        }else{
            return null;
        }
    }


    public List<Collection> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Collection> list = jdbcTemplate.query("select * from collection", new Object[]{}, new BeanPropertyRowMapper<Collection>(Collection.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
