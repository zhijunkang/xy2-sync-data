package com.xy2.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@Data
@Getter
@Setter
public class Fly {
    // 表ID
    private String mid;
    // 飞行器ID
    private Integer flytid;
    // 飞行器名称
    private String flyname;
    //飞行器阶位
    private Integer flystate;
    // 飞行器等级
    private Integer flylvl;
    // 经验
    private Integer exp;
    // 角色ID
    private String roleid;
    //飞行器
    private Integer skin;
    // 升级所需经验
    private Integer gradeexp;
    // 飞行器技能
    List<FlySkill> flyskill;
    // 燃料
    private Long fuel;

}
