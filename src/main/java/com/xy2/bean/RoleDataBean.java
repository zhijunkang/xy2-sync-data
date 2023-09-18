package com.xy2.bean;

import com.xy2.entity.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Data
public class RoleDataBean {

    private RoleTable roleTable;//人物数据
    private PackRecord packRecord;//背包记录数据
    private List<Goodstable> goodstables;//物品
    private List<RoleSummoning> pets;//宝宝
    private List<Mount> mounts;//坐骑
    private List<RolrFly> flys;//飞行器
    private List<Lingbao> lingbaos;//灵宝
    private List<Baby> babys;//孩子
    private List<Titletable> titletables;//称谓
    private List<RolePal> rolePals;//伙伴数据
}
