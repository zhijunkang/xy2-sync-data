package com.xy2.repository;

import com.xy2.entity.PetDefault;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PetDefaultDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, PetDefault petDefault) {
        return jdbcTemplate.update("insert into pet_default  (summoningid,summoningskin,stye,hp,mp,ap,sp,growlevel,resistance,skill,gold,wood,soil,water,fire,summoningname,sid,ssn,roleid,bone,spir,power,speed,canpoint,grade,exp,faithful,friendliness,price,basishp,basismp,basisap,basissp,openseal,innergoods,dragon,extrahp,extramp,extraap,extrasp,petskills,turnrount,gradehp,grademp,nedanresistance,revealnum,flyupnum,beastskills,fourattributes,skilldata,lyk,zqk,alchemynum,growupdannum,colorscheme,drac,trainnum ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )",
                petDefault.getSummoningid(),petDefault.getSummoningskin(),petDefault.getStye(),petDefault.getHp(),petDefault.getMp(),petDefault.getAp(),petDefault.getSp(),petDefault.getGrowlevel(),petDefault.getResistance(),petDefault.getSkill(),petDefault.getGold(),petDefault.getWood(),petDefault.getSoil(),petDefault.getWater(),petDefault.getFire(),petDefault.getSummoningname(),petDefault.getSid(),petDefault.getSsn(),petDefault.getRoleid(),petDefault.getBone(),petDefault.getSpir(),petDefault.getPower(),petDefault.getSpeed(),petDefault.getCanpoint(),petDefault.getGrade(),petDefault.getExp(),petDefault.getFaithful(),petDefault.getFriendliness(),petDefault.getPrice(),petDefault.getBasishp(),petDefault.getBasismp(),petDefault.getBasisap(),petDefault.getBasissp(),petDefault.getOpenseal(),petDefault.getInnergoods(),petDefault.getDragon(),petDefault.getExtrahp(),petDefault.getExtramp(),petDefault.getExtraap(),petDefault.getExtrasp(),petDefault.getPetskills(),petDefault.getTurnrount(),petDefault.getGradehp(),petDefault.getGrademp(),petDefault.getNedanresistance(),petDefault.getRevealnum(),petDefault.getFlyupnum(),petDefault.getBeastskills(),petDefault.getFourattributes(),petDefault.getSkilldata(),petDefault.getLyk(),petDefault.getZqk(),petDefault.getAlchemynum(),petDefault.getGrowupdannum(),petDefault.getColorscheme(),petDefault.getDrac(),petDefault.getTrainnum());
    }


    public int update(JdbcTemplate jdbcTemplate,PetDefault petDefault) {
        return jdbcTemplate.update("UPDATE  pet_default  SET summoningskin=?,stye=?,hp=?,mp=?,ap=?,sp=?,growlevel=?,resistance=?,skill=?,gold=?,wood=?,soil=?,water=?,fire=?,summoningname=?,sid=?,ssn=?,roleid=?,bone=?,spir=?,power=?,speed=?,canpoint=?,grade=?,exp=?,faithful=?,friendliness=?,price=?,basishp=?,basismp=?,basisap=?,basissp=?,openseal=?,innergoods=?,dragon=?,extrahp=?,extramp=?,extraap=?,extrasp=?,petskills=?,turnrount=?,gradehp=?,grademp=?,nedanresistance=?,revealnum=?,flyupnum=?,beastskills=?,fourattributes=?,skilldata=?,lyk=?,zqk=?,alchemynum=?,growupdannum=?,colorscheme=?,drac=?,trainnum=?"
                        +" where summoningid=?",
                petDefault.getSummoningskin(),petDefault.getStye(),petDefault.getHp(),petDefault.getMp(),petDefault.getAp(),petDefault.getSp(),petDefault.getGrowlevel(),petDefault.getResistance(),petDefault.getSkill(),petDefault.getGold(),petDefault.getWood(),petDefault.getSoil(),petDefault.getWater(),petDefault.getFire(),petDefault.getSummoningname(),petDefault.getSid(),petDefault.getSsn(),petDefault.getRoleid(),petDefault.getBone(),petDefault.getSpir(),petDefault.getPower(),petDefault.getSpeed(),petDefault.getCanpoint(),petDefault.getGrade(),petDefault.getExp(),petDefault.getFaithful(),petDefault.getFriendliness(),petDefault.getPrice(),petDefault.getBasishp(),petDefault.getBasismp(),petDefault.getBasisap(),petDefault.getBasissp(),petDefault.getOpenseal(),petDefault.getInnergoods(),petDefault.getDragon(),petDefault.getExtrahp(),petDefault.getExtramp(),petDefault.getExtraap(),petDefault.getExtrasp(),petDefault.getPetskills(),petDefault.getTurnrount(),petDefault.getGradehp(),petDefault.getGrademp(),petDefault.getNedanresistance(),petDefault.getRevealnum(),petDefault.getFlyupnum(),petDefault.getBeastskills(),petDefault.getFourattributes(),petDefault.getSkilldata(),petDefault.getLyk(),petDefault.getZqk(),petDefault.getAlchemynum(),petDefault.getGrowupdannum(),petDefault.getColorscheme(),petDefault.getDrac(),petDefault.getTrainnum(),
                petDefault.getSummoningid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from pet_default where summoningid=?",id);
    }


    public PetDefault findById(JdbcTemplate jdbcTemplate,int id) {
        List<PetDefault> list = jdbcTemplate.query("select * from pet_default where summoningid=?", new Object[]{id}, new BeanPropertyRowMapper<PetDefault>(PetDefault.class));
        if(list!=null && list.size()>0){
            PetDefault petDefault = list.get(0);
            return petDefault;
        }else{
            return null;
        }
    }


    public List<PetDefault> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<PetDefault> list = jdbcTemplate.query("select * from pet_default", new Object[]{}, new BeanPropertyRowMapper<PetDefault>(PetDefault.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM pet_default"), Long.class);
        return maxId+1l;
    }
}
