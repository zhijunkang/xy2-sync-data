package com.xy2.repository;

import com.xy2.entity.Ipaddressmac;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class IpaddressmacDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Ipaddressmac ipaddressmac) {
        return jdbcTemplate.update("insert into ipaddressmac  (ipid,addresskey ) values (?,? )",
                ipaddressmac.getIpid(),ipaddressmac.getAddresskey());
    }


    public int update(JdbcTemplate jdbcTemplate,Ipaddressmac ipaddressmac) {
        return jdbcTemplate.update("UPDATE  ipaddressmac  SET addresskey=?"
                        +" where ipid=?",
                ipaddressmac.getAddresskey(),
                ipaddressmac.getIpid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from ipaddressmac where ipid=?",id);
    }


    public Ipaddressmac findById(JdbcTemplate jdbcTemplate,int id) {
        List<Ipaddressmac> list = jdbcTemplate.query("select * from ipaddressmac where ipid=?", new Object[]{id}, new BeanPropertyRowMapper<Ipaddressmac>(Ipaddressmac.class));
        if(list!=null && list.size()>0){
            Ipaddressmac ipaddressmac = list.get(0);
            return ipaddressmac;
        }else{
            return null;
        }
    }


    public List<Ipaddressmac> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Ipaddressmac> list = jdbcTemplate.query("select * from ipaddressmac", new Object[]{}, new BeanPropertyRowMapper<Ipaddressmac>(Ipaddressmac.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM ipaddressmac"), Long.class);
        return maxId == null ? 1L : maxId+1l;
    }
}
