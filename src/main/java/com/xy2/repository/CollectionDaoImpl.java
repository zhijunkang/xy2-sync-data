package com.xy2.repository;

import com.xy2.entity.Collection;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
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

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM collection"), Long.class);
        return maxId+1l;
    }
}
