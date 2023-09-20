package com.xy2.repository;

import com.xy2.entity.GameRace;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class GameRaceDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, GameRace gameRace) {
        return jdbcTemplate.update("insert into game_race  (race_id ) values (? )",
                gameRace.getRaceId());
    }


    public int update(JdbcTemplate jdbcTemplate,GameRace gameRace) {
        return jdbcTemplate.update("UPDATE  game_race  SET "
                        +" where race_id=?",

                gameRace.getRaceId())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from game_race where race_id=?",id);
    }


    public GameRace findById(JdbcTemplate jdbcTemplate,int id) {
        List<GameRace> list = jdbcTemplate.query("select * from game_race where race_id=?", new Object[]{id}, new BeanPropertyRowMapper<GameRace>(GameRace.class));
        if(list!=null && list.size()>0){
            GameRace gameRace = list.get(0);
            return gameRace;
        }else{
            return null;
        }
    }


    public List<GameRace> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<GameRace> list = jdbcTemplate.query("select * from game_race", new Object[]{}, new BeanPropertyRowMapper<GameRace>(GameRace.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM game_race"), Long.class);
        return maxId+1l;
    }
}
