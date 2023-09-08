package com.xy2.repository;

import com.xy2.entity.Rufenghaocontrol;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;


public class RufenghaocontrolDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Rufenghaocontrol rufenghaocontrol) {
        return jdbcTemplate.update("insert into rufenghaocontrol  (id,username,rolename,reason,type,registerip,lasstloginip,controlobject,dailiid,totalsum,datetime ) values (?,?,?,?,?,?,?,?,?,?,? )",
                rufenghaocontrol.getId(),rufenghaocontrol.getUsername(),rufenghaocontrol.getRolename(),rufenghaocontrol.getReason(),rufenghaocontrol.getType(),rufenghaocontrol.getRegisterip(),rufenghaocontrol.getLasstloginip(),rufenghaocontrol.getControlobject(),rufenghaocontrol.getDailiid(),rufenghaocontrol.getTotalsum(),rufenghaocontrol.getDatetime());
    }


    public int update(JdbcTemplate jdbcTemplate,Rufenghaocontrol rufenghaocontrol) {
        return jdbcTemplate.update("UPDATE  rufenghaocontrol  SET username=?,rolename=?,reason=?,type=?,registerip=?,lasstloginip=?,controlobject=?,dailiid=?,totalsum=?,datetime=?"
                        +" where id=?",
                rufenghaocontrol.getUsername(),rufenghaocontrol.getRolename(),rufenghaocontrol.getReason(),rufenghaocontrol.getType(),rufenghaocontrol.getRegisterip(),rufenghaocontrol.getLasstloginip(),rufenghaocontrol.getControlobject(),rufenghaocontrol.getDailiid(),rufenghaocontrol.getTotalsum(),rufenghaocontrol.getDatetime(),
                rufenghaocontrol.getId())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from rufenghaocontrol where id=?",id);
    }


    public Rufenghaocontrol findById(JdbcTemplate jdbcTemplate,int id) {
        List<Rufenghaocontrol> list = jdbcTemplate.query("select * from rufenghaocontrol where id=?", new Object[]{id}, new BeanPropertyRowMapper<Rufenghaocontrol>(Rufenghaocontrol.class));
        if(list!=null && list.size()>0){
            Rufenghaocontrol rufenghaocontrol = list.get(0);
            return rufenghaocontrol;
        }else{
            return null;
        }
    }


    public List<Rufenghaocontrol> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Rufenghaocontrol> list = jdbcTemplate.query("select * from rufenghaocontrol", new Object[]{}, new BeanPropertyRowMapper<Rufenghaocontrol>(Rufenghaocontrol.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM rufenghaocontrol"), Long.class);
        return maxId;
    }
}
