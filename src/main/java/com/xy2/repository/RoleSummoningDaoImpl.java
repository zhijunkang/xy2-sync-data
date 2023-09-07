package com.xy2.repository;

import com.xy2.entity.RoleSummoning;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;


public class RoleSummoningDaoImpl {

    public int add(JdbcTemplate jdbcTemplate, RoleSummoning roleSummoning) {
        return jdbcTemplate.update("insert into role_summoning  (summoningid,summoningskin,stye,hp,mp,ap,sp,growlevel,resistance,skill,gold,wood,soil,water,fire,summoningname,sid,ssn,roleid,bone,spir,power,speed,canpoint,grade,exp,faithful,friendliness,price,basishp,basismp,basisap,basissp,openseal,innergoods,dragon,extrahp,extramp,extraap,extrasp,petskills,turnrount,gradehp,grademp,nedanresistance,revealnum,flyupnum,beastskills,fourattributes,skilldata,lyk,zqk,alchemynum,growupdannum,colorscheme,drac,trainnum,petlock,calm,czjjd,xy,deposit ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )",
                roleSummoning.getSummoningid(),roleSummoning.getSummoningskin(),roleSummoning.getStye(),roleSummoning.getHp(),roleSummoning.getMp(),roleSummoning.getAp(),roleSummoning.getSp(),roleSummoning.getGrowlevel(),roleSummoning.getResistance(),roleSummoning.getSkill(),roleSummoning.getGold(),roleSummoning.getWood(),roleSummoning.getSoil(),roleSummoning.getWater(),roleSummoning.getFire(),roleSummoning.getSummoningname(),roleSummoning.getSid(),roleSummoning.getSsn(),roleSummoning.getRoleid(),roleSummoning.getBone(),roleSummoning.getSpir(),roleSummoning.getPower(),roleSummoning.getSpeed(),roleSummoning.getCanpoint(),roleSummoning.getGrade(),roleSummoning.getExp(),roleSummoning.getFaithful(),roleSummoning.getFriendliness(),roleSummoning.getPrice(),roleSummoning.getBasishp(),roleSummoning.getBasismp(),roleSummoning.getBasisap(),roleSummoning.getBasissp(),roleSummoning.getOpenseal(),roleSummoning.getInnergoods(),roleSummoning.getDragon(),roleSummoning.getExtrahp(),roleSummoning.getExtramp(),roleSummoning.getExtraap(),roleSummoning.getExtrasp(),roleSummoning.getPetskills(),roleSummoning.getTurnrount(),roleSummoning.getGradehp(),roleSummoning.getGrademp(),roleSummoning.getNedanresistance(),roleSummoning.getRevealnum(),roleSummoning.getFlyupnum(),roleSummoning.getBeastskills(),roleSummoning.getFourattributes(),roleSummoning.getSkilldata(),roleSummoning.getLyk(),roleSummoning.getZqk(),roleSummoning.getAlchemynum(),roleSummoning.getGrowupdannum(),roleSummoning.getColorscheme(),roleSummoning.getDrac(),roleSummoning.getTrainnum(),roleSummoning.getPetlock(),roleSummoning.getCalm(),roleSummoning.getCzjjd(),roleSummoning.getXy(),roleSummoning.getDeposit());
    }


    public int update(JdbcTemplate jdbcTemplate,RoleSummoning roleSummoning) {
        return jdbcTemplate.update("UPDATE  role_summoning  SET summoningskin=?,stye=?,hp=?,mp=?,ap=?,sp=?,growlevel=?,resistance=?,skill=?,gold=?,wood=?,soil=?,water=?,fire=?,summoningname=?,sid=?,ssn=?,roleid=?,bone=?,spir=?,power=?,speed=?,canpoint=?,grade=?,exp=?,faithful=?,friendliness=?,price=?,basishp=?,basismp=?,basisap=?,basissp=?,openseal=?,innergoods=?,dragon=?,extrahp=?,extramp=?,extraap=?,extrasp=?,petskills=?,turnrount=?,gradehp=?,grademp=?,nedanresistance=?,revealnum=?,flyupnum=?,beastskills=?,fourattributes=?,skilldata=?,lyk=?,zqk=?,alchemynum=?,growupdannum=?,colorscheme=?,drac=?,trainnum=?,petlock=?,calm=?,czjjd=?,xy=?,deposit=?"
                        +" where summoningid=?",
                roleSummoning.getSummoningskin(),roleSummoning.getStye(),roleSummoning.getHp(),roleSummoning.getMp(),roleSummoning.getAp(),roleSummoning.getSp(),roleSummoning.getGrowlevel(),roleSummoning.getResistance(),roleSummoning.getSkill(),roleSummoning.getGold(),roleSummoning.getWood(),roleSummoning.getSoil(),roleSummoning.getWater(),roleSummoning.getFire(),roleSummoning.getSummoningname(),roleSummoning.getSid(),roleSummoning.getSsn(),roleSummoning.getRoleid(),roleSummoning.getBone(),roleSummoning.getSpir(),roleSummoning.getPower(),roleSummoning.getSpeed(),roleSummoning.getCanpoint(),roleSummoning.getGrade(),roleSummoning.getExp(),roleSummoning.getFaithful(),roleSummoning.getFriendliness(),roleSummoning.getPrice(),roleSummoning.getBasishp(),roleSummoning.getBasismp(),roleSummoning.getBasisap(),roleSummoning.getBasissp(),roleSummoning.getOpenseal(),roleSummoning.getInnergoods(),roleSummoning.getDragon(),roleSummoning.getExtrahp(),roleSummoning.getExtramp(),roleSummoning.getExtraap(),roleSummoning.getExtrasp(),roleSummoning.getPetskills(),roleSummoning.getTurnrount(),roleSummoning.getGradehp(),roleSummoning.getGrademp(),roleSummoning.getNedanresistance(),roleSummoning.getRevealnum(),roleSummoning.getFlyupnum(),roleSummoning.getBeastskills(),roleSummoning.getFourattributes(),roleSummoning.getSkilldata(),roleSummoning.getLyk(),roleSummoning.getZqk(),roleSummoning.getAlchemynum(),roleSummoning.getGrowupdannum(),roleSummoning.getColorscheme(),roleSummoning.getDrac(),roleSummoning.getTrainnum(),roleSummoning.getPetlock(),roleSummoning.getCalm(),roleSummoning.getCzjjd(),roleSummoning.getXy(),roleSummoning.getDeposit(),
                roleSummoning.getSummoningid())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from role_summoning where summoningid=?",id);
    }


    public RoleSummoning findById(JdbcTemplate jdbcTemplate,int id) {
        List<RoleSummoning> list = jdbcTemplate.query("select * from role_summoning where summoningid=?", new Object[]{id}, new BeanPropertyRowMapper<RoleSummoning>(RoleSummoning.class));
        if(list!=null && list.size()>0){
            RoleSummoning roleSummoning = list.get(0);
            return roleSummoning;
        }else{
            return null;
        }
    }


    public List<RoleSummoning> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<RoleSummoning> list = jdbcTemplate.query("select * from role_summoning", new Object[]{}, new BeanPropertyRowMapper<RoleSummoning>(RoleSummoning.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}