package com.xy2.repository;

import com.xy2.entity.OneRol;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author kangzhijun
 * @version V1.0
 * @date 2023/9/7 14:36
 * @copyright 北京北大英华科技有限公司-法律科技中心
 * @description TODO
 */
public class OneRolDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, OneRol oneRol) {
        return jdbcTemplate.update("insert into one_rol  (id,roleid,place,placepast,isaward,skin,name ) values (?,?,?,?,?,?,? )",
                oneRol.getId(),oneRol.getRoleid(),oneRol.getPlace(),oneRol.getPlacepast(),oneRol.getIsaward(),oneRol.getSkin(),oneRol.getName());
    }


    public int update(JdbcTemplate jdbcTemplate,OneRol oneRol) {
        return jdbcTemplate.update("UPDATE  one_rol  SET roleid=?,place=?,placepast=?,isaward=?,skin=?,name=?"
                        +" where id=?",
                oneRol.getRoleid(),oneRol.getPlace(),oneRol.getPlacepast(),oneRol.getIsaward(),oneRol.getSkin(),oneRol.getName(),
                oneRol.getId())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from one_rol where id=?",id);
    }


    public OneRol findById(JdbcTemplate jdbcTemplate,int id) {
        List<OneRol> list = jdbcTemplate.query("select * from one_rol where id=?", new Object[]{id}, new BeanPropertyRowMapper<OneRol>(OneRol.class));
        if(list!=null && list.size()>0){
            OneRol oneRol = list.get(0);
            return oneRol;
        }else{
            return null;
        }
    }


    public List<OneRol> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<OneRol> list = jdbcTemplate.query("select * from one_rol", new Object[]{}, new BeanPropertyRowMapper<OneRol>(OneRol.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

}
