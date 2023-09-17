package com.xy2.repository;

import com.xy2.entity.Rune;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class RuneDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Rune rune) {
        return jdbcTemplate.update("insert into rune  (runeid,runename,runeskin,runetype,runequality,runevalue ) values (?,?,?,?,?,? )",
                rune.getRuneid(),rune.getRunename(),rune.getRuneskin(),rune.getRunetype(),rune.getRunequality(),rune.getRunevalue());
    }


    public int update(JdbcTemplate jdbcTemplate,Rune rune) {
        return jdbcTemplate.update("UPDATE  rune  SET runename=?,runeskin=?,runetype=?,runequality=?,runevalue=?"
                        +" where runeid=?",
                rune.getRunename(),rune.getRuneskin(),rune.getRunetype(),rune.getRunequality(),rune.getRunevalue(),
                rune.getRuneid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from rune where runeid=?",id);
    }


    public Rune findById(JdbcTemplate jdbcTemplate,int id) {
        List<Rune> list = jdbcTemplate.query("select * from rune where runeid=?", new Object[]{id}, new BeanPropertyRowMapper<Rune>(Rune.class));
        if(list!=null && list.size()>0){
            Rune rune = list.get(0);
            return rune;
        }else{
            return null;
        }
    }


    public List<Rune> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Rune> list = jdbcTemplate.query("select * from rune", new Object[]{}, new BeanPropertyRowMapper<Rune>(Rune.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM rune"), Long.class);
        return maxId;
    }
}
