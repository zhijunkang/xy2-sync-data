package com.xy2.repository;

import com.xy2.entity.Onearenarole;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class OnearenaroleDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Onearenarole onearenarole) {
        return jdbcTemplate.update("insert into onearenarole  (roleid,place,skin,name,lvl,isaward ) values (?,?,?,?,?,? )",
                onearenarole.getRoleid(),onearenarole.getPlace(),onearenarole.getSkin(),onearenarole.getName(),onearenarole.getLvl(),onearenarole.getIsaward());
    }


    public int update(JdbcTemplate jdbcTemplate,Onearenarole onearenarole) {
        return jdbcTemplate.update("UPDATE  onearenarole  SET place=?,skin=?,name=?,lvl=?,isaward=?"
                        +" where roleid=?",
                onearenarole.getPlace(),onearenarole.getSkin(),onearenarole.getName(),onearenarole.getLvl(),onearenarole.getIsaward(),
                onearenarole.getRoleid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from onearenarole where roleid=?",id);
    }


    public Onearenarole findById(JdbcTemplate jdbcTemplate,int id) {
        List<Onearenarole> list = jdbcTemplate.query("select * from onearenarole where roleid=?", new Object[]{id}, new BeanPropertyRowMapper<Onearenarole>(Onearenarole.class));
        if(list!=null && list.size()>0){
            Onearenarole onearenarole = list.get(0);
            return onearenarole;
        }else{
            return null;
        }
    }


    public List<Onearenarole> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Onearenarole> list = jdbcTemplate.query("select * from onearenarole", new Object[]{}, new BeanPropertyRowMapper<Onearenarole>(Onearenarole.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM onearenarole"), Long.class);
        return maxId == null ? 1L : maxId+1l;
    }
}
