package com.xy2.repository;

import com.xy2.entity.RoleTable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;


public class RoleTableDaoImpl {


    public int add(JdbcTemplate jdbcTemplate,RoleTable roleTable) {
        return jdbcTemplate.update("insert into role_table  (role_id,user_id,species_id,summoning_id,gang_id,mount_id,troop_id,race_id,skill_id,booth_id,task_id,hp,mp,gold,codecard,experience,grade,prestige,pkrecord,rolename,title,path,sex,localname,skill,x,y,mapid,uptime,gangpost,achievement,contribution,bone,spir,power,speed,canpoint,captain,savegold,password,gangname,havebaby,newrole,racename,maxexp,marryobject,skills,timinggood,turnaround,taskdaily,born,resistance,servermestring,taskreceive,taskcomplete,taskdata,fighting,dbexp,score,kill,babyid,drawing,calm,xiuwei,extrapoint,paysum,daypaysum,dayandpayorno,dayfirstinorno,daygetorno,vipget,loworhihtpack,pals,fmsld,attachpack,meridians,hjmax,qian_dao,online_time,xingpans,ttvictory,ttfail,ttrecord,ttjiangli,gmshoptype,gradeincrease,currentattribute,gametimeremaining,shigongx ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )",
                roleTable.getRoleId(),roleTable.getUserId(),roleTable.getSpeciesId(),roleTable.getSummoningId(),roleTable.getGangId(),roleTable.getMountId(),roleTable.getTroopId(),roleTable.getRaceId(),roleTable.getSkillId(),roleTable.getBoothId(),roleTable.getTaskId(),roleTable.getHp(),roleTable.getMp(),roleTable.getGold(),roleTable.getCodecard(),roleTable.getExperience(),roleTable.getGrade(),roleTable.getPrestige(),roleTable.getPkrecord(),roleTable.getRolename(),roleTable.getTitle(),roleTable.getPath(),roleTable.getSex(),roleTable.getLocalname(),roleTable.getSkill(),roleTable.getX(),roleTable.getY(),roleTable.getMapid(),roleTable.getUptime(),roleTable.getGangpost(),roleTable.getAchievement(),roleTable.getContribution(),roleTable.getBone(),roleTable.getSpir(),roleTable.getPower(),roleTable.getSpeed(),roleTable.getCanpoint(),roleTable.getCaptain(),roleTable.getSavegold(),roleTable.getPassword(),roleTable.getGangname(),roleTable.getHavebaby(),roleTable.getNewrole(),roleTable.getRacename(),roleTable.getMaxexp(),roleTable.getMarryobject(),roleTable.getSkills(),roleTable.getTiminggood(),roleTable.getTurnaround(),roleTable.getTaskdaily(),roleTable.getBorn(),roleTable.getResistance(),roleTable.getServermestring(),roleTable.getTaskreceive(),roleTable.getTaskcomplete(),roleTable.getTaskdata(),roleTable.getFighting(),roleTable.getDbexp(),roleTable.getScore(),roleTable.getKill(),roleTable.getBabyid(),roleTable.getDrawing(),roleTable.getCalm(),roleTable.getXiuwei(),roleTable.getExtrapoint(),roleTable.getPaysum(),roleTable.getDaypaysum(),roleTable.getDayandpayorno(),roleTable.getDayfirstinorno(),roleTable.getDaygetorno(),roleTable.getVipget(),roleTable.getLoworhihtpack(),roleTable.getPals(),roleTable.getFmsld(),roleTable.getAttachpack(),roleTable.getMeridians(),roleTable.getHjmax(),roleTable.getQianDao(),roleTable.getOnlineTime(),roleTable.getXingpans(),roleTable.getTtvictory(),roleTable.getTtfail(),roleTable.getTtrecord(),roleTable.getTtjiangli(),roleTable.getGmshoptype(),roleTable.getGradeincrease(),roleTable.getCurrentattribute(),roleTable.getGametimeremaining(),roleTable.getShigongx());
    }


    public int update(JdbcTemplate jdbcTemplate, RoleTable roleTable) {
        return jdbcTemplate.update("UPDATE  role_table  SET user_id=?,species_id=?,summoning_id=?,gang_id=?,mount_id=?,troop_id=?,race_id=?,skill_id=?,booth_id=?,task_id=?,hp=?,mp=?,gold=?,codecard=?,experience=?,grade=?,prestige=?,pkrecord=?,rolename=?,title=?,path=?,sex=?,localname=?,skill=?,x=?,y=?,mapid=?,uptime=?,gangpost=?,achievement=?,contribution=?,bone=?,spir=?,power=?,speed=?,canpoint=?,captain=?,savegold=?,password=?,gangname=?,havebaby=?,newrole=?,racename=?,maxexp=?,marryobject=?,skills=?,timinggood=?,turnaround=?,taskdaily=?,born=?,resistance=?,servermestring=?,taskreceive=?,taskcomplete=?,taskdata=?,fighting=?,dbexp=?,score=?,kill=?,babyid=?,drawing=?,calm=?,xiuwei=?,extrapoint=?,paysum=?,daypaysum=?,dayandpayorno=?,dayfirstinorno=?,daygetorno=?,vipget=?,loworhihtpack=?,pals=?,fmsld=?,attachpack=?,meridians=?,hjmax=?,qian_dao=?,online_time=?,xingpans=?,ttvictory=?,ttfail=?,ttrecord=?,ttjiangli=?,gmshoptype=?,gradeincrease=?,currentattribute=?,gametimeremaining=?,shigongx=?"
                        +" where role_id=?",
                roleTable.getUserId(),roleTable.getSpeciesId(),roleTable.getSummoningId(),roleTable.getGangId(),roleTable.getMountId(),roleTable.getTroopId(),roleTable.getRaceId(),roleTable.getSkillId(),roleTable.getBoothId(),roleTable.getTaskId(),roleTable.getHp(),roleTable.getMp(),roleTable.getGold(),roleTable.getCodecard(),roleTable.getExperience(),roleTable.getGrade(),roleTable.getPrestige(),roleTable.getPkrecord(),roleTable.getRolename(),roleTable.getTitle(),roleTable.getPath(),roleTable.getSex(),roleTable.getLocalname(),roleTable.getSkill(),roleTable.getX(),roleTable.getY(),roleTable.getMapid(),roleTable.getUptime(),roleTable.getGangpost(),roleTable.getAchievement(),roleTable.getContribution(),roleTable.getBone(),roleTable.getSpir(),roleTable.getPower(),roleTable.getSpeed(),roleTable.getCanpoint(),roleTable.getCaptain(),roleTable.getSavegold(),roleTable.getPassword(),roleTable.getGangname(),roleTable.getHavebaby(),roleTable.getNewrole(),roleTable.getRacename(),roleTable.getMaxexp(),roleTable.getMarryobject(),roleTable.getSkills(),roleTable.getTiminggood(),roleTable.getTurnaround(),roleTable.getTaskdaily(),roleTable.getBorn(),roleTable.getResistance(),roleTable.getServermestring(),roleTable.getTaskreceive(),roleTable.getTaskcomplete(),roleTable.getTaskdata(),roleTable.getFighting(),roleTable.getDbexp(),roleTable.getScore(),roleTable.getKill(),roleTable.getBabyid(),roleTable.getDrawing(),roleTable.getCalm(),roleTable.getXiuwei(),roleTable.getExtrapoint(),roleTable.getPaysum(),roleTable.getDaypaysum(),roleTable.getDayandpayorno(),roleTable.getDayfirstinorno(),roleTable.getDaygetorno(),roleTable.getVipget(),roleTable.getLoworhihtpack(),roleTable.getPals(),roleTable.getFmsld(),roleTable.getAttachpack(),roleTable.getMeridians(),roleTable.getHjmax(),roleTable.getQianDao(),roleTable.getOnlineTime(),roleTable.getXingpans(),roleTable.getTtvictory(),roleTable.getTtfail(),roleTable.getTtrecord(),roleTable.getTtjiangli(),roleTable.getGmshoptype(),roleTable.getGradeincrease(),roleTable.getCurrentattribute(),roleTable.getGametimeremaining(),roleTable.getShigongx(),
                roleTable.getRoleId())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from role_table where role_id=?",id);
    }


    public RoleTable findById(JdbcTemplate jdbcTemplate,int id) {
        List<RoleTable> list = jdbcTemplate.query("select * from role_table where role_id=?", new Object[]{id}, new BeanPropertyRowMapper<RoleTable>(RoleTable.class));
        if(list!=null && list.size()>0){
            RoleTable roleTable = list.get(0);
            return roleTable;
        }else{
            return null;
        }
    }


    public List<RoleTable> findAllList(JdbcTemplate jdbcTemplate,Map<String,Object> params) {
        List<RoleTable> list = jdbcTemplate.query("select * from role_table", new Object[]{}, new BeanPropertyRowMapper<RoleTable>(RoleTable.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }


}
