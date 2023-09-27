package com.xy2.repository;

import com.xy2.entity.PackRecord;
import com.xy2.entity.RoleTable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
public class PackRecordDaoImpl {
    //@Transactional(propagation = Propagation.NESTED)
    public int add(JdbcTemplate jdbcTemplate, PackRecord packRecord) {
        return jdbcTemplate.update("insert into pack_record  (role_id,record,helpbb,helpling,suitnum,collect,suit1,suit2,suit3,suit4,suit5,suit6,suit7,suit8,suit9,suit10,suit11,tx,sldh,other ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )",
                packRecord.getRoleId(),packRecord.getRecord(),packRecord.getHelpbb(),packRecord.getHelpling(),packRecord.getSuitnum(),packRecord.getCollect(),packRecord.getSuit1(),packRecord.getSuit2(),packRecord.getSuit3(),packRecord.getSuit4(),packRecord.getSuit5(),packRecord.getSuit6(),packRecord.getSuit7(),packRecord.getSuit8(),packRecord.getSuit9(),packRecord.getSuit10(),packRecord.getSuit11(),packRecord.getTx(),packRecord.getSldh(),packRecord.getOther());
    }


    public int update(JdbcTemplate jdbcTemplate,PackRecord packRecord) {
        return jdbcTemplate.update("UPDATE  pack_record  SET record=?,helpbb=?,helpling=?,suitnum=?,collect=?,suit1=?,suit2=?,suit3=?,suit4=?,suit5=?,suit6=?,suit7=?,suit8=?,suit9=?,suit10=?,suit11=?,tx=?,sldh=?,other=?"
                        +" where role_id=?",
                packRecord.getRecord(),packRecord.getHelpbb(),packRecord.getHelpling(),packRecord.getSuitnum(),packRecord.getCollect(),packRecord.getSuit1(),packRecord.getSuit2(),packRecord.getSuit3(),packRecord.getSuit4(),packRecord.getSuit5(),packRecord.getSuit6(),packRecord.getSuit7(),packRecord.getSuit8(),packRecord.getSuit9(),packRecord.getSuit10(),packRecord.getSuit11(),packRecord.getTx(),packRecord.getSldh(),packRecord.getOther(),
                packRecord.getRoleId())
                ;
    }


    public int delete(JdbcTemplate jdbcTemplate,int id) {
        return jdbcTemplate.update("DELETE from pack_record where role_id=?",id);
    }


    public PackRecord findById(JdbcTemplate jdbcTemplate,int id) {
        List<PackRecord> list = jdbcTemplate.query("select * from pack_record where role_id=?", new Object[]{id}, new BeanPropertyRowMapper<PackRecord>(PackRecord.class));
        if(list!=null && list.size()>0){
            PackRecord packRecord = list.get(0);
            return packRecord;
        }else{
            return null;
        }
    }


    public List<PackRecord> findAllList(JdbcTemplate jdbcTemplate, Map<String,Object> params) {
        List<PackRecord> list = jdbcTemplate.query("select * from pack_record", new Object[]{}, new BeanPropertyRowMapper<PackRecord>(PackRecord.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public Long topId(JdbcTemplate jdbcTemplate,String zd){
        Long maxId = jdbcTemplate.queryForObject(String.format("SELECT MAX(" + zd + ") FROM pack_record"), Long.class);
        return maxId == null ? 1L : maxId+1l;
    }

    public List<PackRecord> findAllListByRoleId(JdbcTemplate jdbcTemplate, Long roleId) {
        List<PackRecord> list = jdbcTemplate.query("select * from pack_record where role_id="+roleId,new Object[]{}, new BeanPropertyRowMapper<PackRecord>(PackRecord.class));
        return list;
    }
}
