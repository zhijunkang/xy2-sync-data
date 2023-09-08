package com.xy2.repository;

import com.xy2.entity.Onearenanotes;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;


public class OnearenanotesDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Onearenanotes onearenanotes) {
        return jdbcTemplate.update("insert into onearenanotes  (id,role1,name1,skin1,lvl1,role2,name2,skin2,lvl2,isv,place ) values (?,?,?,?,?,?,?,?,?,?,? )",
                onearenanotes.getId(),onearenanotes.getRole1(),onearenanotes.getName1(),onearenanotes.getSkin1(),onearenanotes.getLvl1(),onearenanotes.getRole2(),onearenanotes.getName2(),onearenanotes.getSkin2(),onearenanotes.getLvl2(),onearenanotes.getIsv(),onearenanotes.getPlace());
    }


    public int update(JdbcTemplate jdbcTemplate,Onearenanotes onearenanotes) {
        return jdbcTemplate.update("UPDATE  onearenanotes  SET role1=?,name1=?,skin1=?,lvl1=?,role2=?,name2=?,skin2=?,lvl2=?,isv=?,place=?"
                        +" where id=?",
                onearenanotes.getRole1(),onearenanotes.getName1(),onearenanotes.getSkin1(),onearenanotes.getLvl1(),onearenanotes.getRole2(),onearenanotes.getName2(),onearenanotes.getSkin2(),onearenanotes.getLvl2(),onearenanotes.getIsv(),onearenanotes.getPlace(),
                onearenanotes.getId())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from onearenanotes where id=?",id);
    }


    public Onearenanotes findById(JdbcTemplate jdbcTemplate,int id) {
        List<Onearenanotes> list = jdbcTemplate.query("select * from onearenanotes where id=?", new Object[]{id}, new BeanPropertyRowMapper<Onearenanotes>(Onearenanotes.class));
        if(list!=null && list.size()>0){
            Onearenanotes onearenanotes = list.get(0);
            return onearenanotes;
        }else{
            return null;
        }
    }


    public List<Onearenanotes> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Onearenanotes> list = jdbcTemplate.query("select * from onearenanotes", new Object[]{}, new BeanPropertyRowMapper<Onearenanotes>(Onearenanotes.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM onearenanotes"), Long.class);
        return maxId;
    }
}
