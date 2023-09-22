package com.xy2.repository;

import com.xy2.entity.RolePal;
import com.xy2.entity.Titletable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
public class RolePalDaoImpl {
    @Transactional(propagation = Propagation.NESTED)
    public int add(JdbcTemplate jdbcTemplate, RolePal rolePal) {
        return jdbcTemplate.update("insert into role_pal  (id,pid,grow,lvl,exp,parts ) values (?,?,?,?,?,? )",
                rolePal.getId(),rolePal.getPid(),rolePal.getGrow(),rolePal.getLvl(),rolePal.getExp(),rolePal.getParts());
    }


    public int update(JdbcTemplate jdbcTemplate,RolePal rolePal) {
        return jdbcTemplate.update("UPDATE  role_pal  SET pid=?,grow=?,lvl=?,exp=?,parts=?"
                        +" where id=?",
                rolePal.getPid(),rolePal.getGrow(),rolePal.getLvl(),rolePal.getExp(),rolePal.getParts(),
                rolePal.getId())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from role_pal where id=?",id);
    }


    public RolePal findById(JdbcTemplate jdbcTemplate,int id) {
        List<RolePal> list = jdbcTemplate.query("select * from role_pal where id=?", new Object[]{id}, new BeanPropertyRowMapper<RolePal>(RolePal.class));
        if(list!=null && list.size()>0){
            RolePal rolePal = list.get(0);
            return rolePal;
        }else{
            return null;
        }
    }


    public List<RolePal> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<RolePal> list = jdbcTemplate.query("select * from role_pal", new Object[]{}, new BeanPropertyRowMapper<RolePal>(RolePal.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM role_pal"), Long.class);
        return maxId == null ? 1L : maxId+1l;
    }

    public List<RolePal> findAllListByRoleId(JdbcTemplate jdbcTemplate, Long roleId) {
        List<RolePal> list = jdbcTemplate.query("select * from role_pal where roleid="+roleId,new Object[]{}, new BeanPropertyRowMapper<RolePal>(RolePal.class));
        return list;
    }
}
