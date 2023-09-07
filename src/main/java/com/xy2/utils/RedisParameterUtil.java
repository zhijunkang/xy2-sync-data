package com.xy2.utils;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RedisParameterUtil {
    @Value("${server.area}")
    private static String gameServerArea;
    /**
     * 武神山
     */
    public final static String BATTLEROLE = gameServerArea + "BATTLEROLE";
    /**
     * 宝宝
     */
    public final static String BABY = gameServerArea + "BABY";
    /**
     * 好友
     */
    public final static String FRIENDS = gameServerArea + "FRIENDS";
    /**
     * 帮派申请列表
     */
    public final static String GANG_APPLY = gameServerArea + "GANG_APPLY";
    /**
     * 帮派
     */
    public final static String GANG = gameServerArea + "GANG";
    /**
     * 帮派名称
     */
    public final static String GANG_NAME = gameServerArea + "GANG_NAME";
    /**
     * 物品
     */
    public final static String GOODS = gameServerArea + "GOODS";
    public final static String GOODSID = gameServerArea + "GOODSID";//物品item表id
    public final static String GOODSST = gameServerArea + "GOODSST";//物品 背包 装备上 仓库
    /**
     * 坐骑
     */
    public final static String MOUNT = gameServerArea + "MOUNT";
    /**
     * 飞行器
     */
    public final static String FLY = gameServerArea + "FLY";
    /**
     * 召唤兽
     */
    public final static String PET = gameServerArea + "PET";
    /**
     * 灵宝
     */
    public final static String LINGBAO = gameServerArea + "LINGBAO";
    /**
     * 伙伴
     */
    public final static String PAL = gameServerArea + "PAL";
    /**
     * 物品记录
     */
    public final static String GOODS_RECORD = gameServerArea + "GOODS_RECORD";
    /**
     * 人物数据同步
     */
    public final static String USER_REDIS = gameServerArea + "USER_REDIS";
    /**
     * 人物操作
     */
    public final static String ROLE_CONTROL = gameServerArea + "control_redis_delete";
    /**
     * 人物数据备份对象 LoginResult
     */
    public final static String COPY_LOGIN = gameServerArea + "COPY_LOGIN";
    /**
     * 人物数据备份对象 PackRecord
     */
    public final static String COPY_PACK = gameServerArea + "COPY_PACK";
    /**
     * salesgoods存储表名
     */
    public final static String SALESGOODS_STATUES = gameServerArea + "SALESGOODS_STATUES";
}
