package com.xy2.repository;

import com.xy2.entity.RoleAttribute;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;


public class RoleAttributeDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, RoleAttribute roleAttribute) {
        return jdbcTemplate.update("insert into role_attribute  (role_id,attributenameone,boneone,spirone,powerone,speedone,calmone,labpointnumberone,attributenametwo,bonetwo,spirtwo,powertwo,speedtwo,calmtwo,labpointnumbertwo ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )",
                roleAttribute.getRoleId(),roleAttribute.getAttributenameone(),roleAttribute.getBoneone(),roleAttribute.getSpirone(),roleAttribute.getPowerone(),roleAttribute.getSpeedone(),roleAttribute.getCalmone(),roleAttribute.getLabpointnumberone(),roleAttribute.getAttributenametwo(),roleAttribute.getBonetwo(),roleAttribute.getSpirtwo(),roleAttribute.getPowertwo(),roleAttribute.getSpeedtwo(),roleAttribute.getCalmtwo(),roleAttribute.getLabpointnumbertwo());
    }


    public int update(JdbcTemplate jdbcTemplate,RoleAttribute roleAttribute) {
        return jdbcTemplate.update("UPDATE  role_attribute  SET attributenameone=?,boneone=?,spirone=?,powerone=?,speedone=?,calmone=?,labpointnumberone=?,attributenametwo=?,bonetwo=?,spirtwo=?,powertwo=?,speedtwo=?,calmtwo=?,labpointnumbertwo=?"
                        +" where role_id=?",
                roleAttribute.getAttributenameone(),roleAttribute.getBoneone(),roleAttribute.getSpirone(),roleAttribute.getPowerone(),roleAttribute.getSpeedone(),roleAttribute.getCalmone(),roleAttribute.getLabpointnumberone(),roleAttribute.getAttributenametwo(),roleAttribute.getBonetwo(),roleAttribute.getSpirtwo(),roleAttribute.getPowertwo(),roleAttribute.getSpeedtwo(),roleAttribute.getCalmtwo(),roleAttribute.getLabpointnumbertwo(),
                roleAttribute.getRoleId())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from role_attribute where role_id=?",id);
    }


    public RoleAttribute findById(JdbcTemplate jdbcTemplate,int id) {
        List<RoleAttribute> list = jdbcTemplate.query("select * from role_attribute where role_id=?", new Object[]{id}, new BeanPropertyRowMapper<RoleAttribute>(RoleAttribute.class));
        if(list!=null && list.size()>0){
            RoleAttribute roleAttribute = list.get(0);
            return roleAttribute;
        }else{
            return null;
        }
    }


    public List<RoleAttribute> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<RoleAttribute> list = jdbcTemplate.query("select * from role_attribute", new Object[]{}, new BeanPropertyRowMapper<RoleAttribute>(RoleAttribute.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

}
