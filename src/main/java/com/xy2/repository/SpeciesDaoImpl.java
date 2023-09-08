package com.xy2.repository;

import com.xy2.entity.Species;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;


public class SpeciesDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, Species species) {
        return jdbcTemplate.update("insert into species  (species_id,race_id,sex ) values (?,?,? )",
                species.getSpeciesId(),species.getRaceId(),species.getSex());
    }


    public int update(JdbcTemplate jdbcTemplate,Species species) {
        return jdbcTemplate.update("UPDATE  species  SET race_id=?,sex=?"
                        +" where species_id=?",
                species.getRaceId(),species.getSex(),
                species.getSpeciesId())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from species where species_id=?",id);
    }


    public Species findById(JdbcTemplate jdbcTemplate,int id) {
        List<Species> list = jdbcTemplate.query("select * from species where species_id=?", new Object[]{id}, new BeanPropertyRowMapper<Species>(Species.class));
        if(list!=null && list.size()>0){
            Species species = list.get(0);
            return species;
        }else{
            return null;
        }
    }


    public List<Species> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<Species> list = jdbcTemplate.query("select * from species", new Object[]{}, new BeanPropertyRowMapper<Species>(Species.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM species"), Long.class);
        return maxId;
    }
}
