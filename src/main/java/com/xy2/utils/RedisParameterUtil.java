package com.xy2.utils;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class RedisParameterUtil {

    public static void setGameServerArea(String gameServerArea) {
        RedisParameterUtil.gameServerArea = gameServerArea;
    }

    public static String getGameServerArea() {
        return gameServerArea;
    }

    private static String gameServerArea;

    private  RedisParameterUtil( @Value("${server.area}") String area){
        RedisParameterUtil.setGameServerArea(area);
    }
    /**
     * 武神山
     */
    public final static String BATTLEROLE =  "BATTLEROLE";
    /**
     * 宝宝
     */
    public final static String BABY =  "BABY";
    /**
     * 好友
     */
    public final static String FRIENDS = "FRIENDS";
    /**
     * 帮派申请列表
     */
    public final static String GANG_APPLY = "GANG_APPLY";
    /**
     * 帮派
     */
    public final static String GANG =  "GANG";
    /**
     * 帮派名称
     */
    public final static String GANG_NAME =  "GANG_NAME";
    /**
     * 物品
     */
    public final static String GOODS =  "GOODS";
    public final static String GOODSID =  "GOODSID";//物品item表id
    public final static String GOODSST =  "GOODSST";//物品 背包 装备上 仓库
    /**
     * 坐骑
     */
    public final static String MOUNT =  "MOUNT";
    /**
     * 飞行器
     */
    public final static String FLY =  "FLY";
    /**
     * 召唤兽
     */
    public final static String PET =   "PET";
    /**
     * 灵宝
     */
    public final static String LINGBAO = "LINGBAO";
    /**
     * 伙伴
     */
    public final static String PAL =  "PAL";
    /**
     * 物品记录
     */
    public final static String GOODS_RECORD =  "GOODS_RECORD";
    /**
     * 人物数据同步
     */
    public final static String USER_REDIS =  "USER_REDIS";
    /**
     * 人物操作
     */
    public final static String ROLE_CONTROL = "control_redis_delete";
    /**
     * 人物数据备份对象 LoginResult
     */
    public final static String COPY_LOGIN =  "COPY_LOGIN";
    /**
     * 人物数据备份对象 PackRecord
     */
    public final static String COPY_PACK =  "COPY_PACK";
    /**
     * salesgoods存储表名
     */
    public final static String SALESGOODS_STATUES = "SALESGOODS_STATUES";
}
