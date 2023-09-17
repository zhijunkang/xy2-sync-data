package com.xy2.repository;

import com.xy2.entity.Record;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class RecordDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Record record) {
        return jdbcTemplate.update("insert into record  (recordid,recordtype,text ) values (?,?,? )",
                record.getRecordid(),record.getRecordtype(),record.getText());
    }


    public int update(JdbcTemplate jdbcTemplate,Record record) {
        return jdbcTemplate.update("UPDATE  record  SET recordtype=?,text=?"
                        +" where recordid=?",
                record.getRecordtype(),record.getText(),
                record.getRecordid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from record where recordid=?",id);
    }


    public Record findById(JdbcTemplate jdbcTemplate,int id) {
        List<Record> list = jdbcTemplate.query("select * from record where recordid=?", new Object[]{id}, new BeanPropertyRowMapper<Record>(Record.class));
        if(list!=null && list.size()>0){
            Record record = list.get(0);
            return record;
        }else{
            return null;
        }
    }


    public List<Record> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Record> list = jdbcTemplate.query("select * from record", new Object[]{}, new BeanPropertyRowMapper<Record>(Record.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM record"), Long.class);
        return maxId;
    }
}
