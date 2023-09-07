package com.xy2.repository;

import com.xy2.entity.Mount;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;


public class MountDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Mount mount) {
        return jdbcTemplate.update("insert into mount  (mid,mountid,mountname,mountlvl,live,spri,power,bone,exp,roleid,sid,othrersid,usenumber,proficiency,sid3 ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )",
                mount.getMid(),mount.getMountid(),mount.getMountname(),mount.getMountlvl(),mount.getLive(),mount.getSpri(),mount.getPower(),mount.getBone(),mount.getExp(),mount.getRoleid(),mount.getSid(),mount.getOthrersid(),mount.getUsenumber(),mount.getProficiency(),mount.getSid3());
    }


    public int update(JdbcTemplate jdbcTemplate,Mount mount) {
        return jdbcTemplate.update("UPDATE  mount  SET mountid=?,mountname=?,mountlvl=?,live=?,spri=?,power=?,bone=?,exp=?,roleid=?,sid=?,othrersid=?,usenumber=?,proficiency=?,sid3=?"
                        +" where mid=?",
                mount.getMountid(),mount.getMountname(),mount.getMountlvl(),mount.getLive(),mount.getSpri(),mount.getPower(),mount.getBone(),mount.getExp(),mount.getRoleid(),mount.getSid(),mount.getOthrersid(),mount.getUsenumber(),mount.getProficiency(),mount.getSid3(),
                mount.getMid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from mount where mid=?",id);
    }


    public Mount findById(JdbcTemplate jdbcTemplate,int id) {
        List<Mount> list = jdbcTemplate.query("select * from mount where mid=?", new Object[]{id}, new BeanPropertyRowMapper<Mount>(Mount.class));
        if(list!=null && list.size()>0){
            Mount mount = list.get(0);
            return mount;
        }else{
            return null;
        }
    }


    public List<Mount> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Mount> list = jdbcTemplate.query("select * from mount", new Object[]{}, new BeanPropertyRowMapper<Mount>(Mount.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

}
