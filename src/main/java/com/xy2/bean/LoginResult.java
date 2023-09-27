package com.xy2.bean;


import com.xy2.entity.RoleSummoning;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 登入返回角色实体类
 *
 * @author 叶豪芳
 * @date : 2017年11月23日 下午2:58:19
 */
public class LoginResult {

    // 帮派名称
    private String gangname;
    // 角色ID
    private BigDecimal role_id;
    // 种族名称
    private String race_name;
    // 用户ID
    private BigDecimal user_id;
    // 种类ID
    private BigDecimal species_id;
    // 召唤兽ID
    private BigDecimal summoning_id;
    //飞行器ID
    private Integer fly_id;
    private String flyskin;
    // 参战伙伴id
    private String pals;
    // 角色表里的帮派ID
    private BigDecimal gang_id;
    // 坐骑ID
    private Integer mount_id;
    // 队伍ID
    private BigDecimal troop_id;
    // 种族ID
    private BigDecimal race_id;
    // 摆摊ID
    private BigDecimal booth_id;
    //任务id 现在是徽章id
    private Integer skill_id;
    // 血量
    private BigDecimal hp;
    // 蓝量
    private BigDecimal mp;
    // 金币
    private BigDecimal gold;
    // 绑玉
    private BigDecimal savegold;
    // 点卡
    private BigDecimal codecard;
    // 经验
    private BigDecimal experience;
    // 等级
    private Integer grade;
    // 声望
    private BigDecimal prestige;
    // 战绩
    private BigDecimal pkrecord;
    // 角色名字
    private String rolename;
    // 角色称谓
    private String title;
    // 角色本名
    private String localname;
    // 用户名
    private String userName;
    // 密码
    private String userPwd;
    // 状态
    private Integer activity;
    // 性别
    private String sex;
    // 所在坐标
    private Long x;
    private Long y;
    // 所在地图
    private Long mapid;
    // 帮派职务
    private String gangpost;
    // 帮派成就
    private BigDecimal achievement;
    // 帮派贡献
    private BigDecimal contribution;
    // 师贡
    private BigDecimal shigongx;
    // 根骨
    private Integer bone;
    // 灵性
    private Integer spir;
    // 力量
    private Integer power;
    // 敏捷
    private Integer speed;
    // 定力
    private Integer calm;
    // 修为点
    private Integer xiuwei;
    // 已兑换属性点
    private String extraPoint;
    // 判断是否在战斗中(1、战斗中)
    private Integer fighting;
    // 下线时间
    private String uptime;
    // 背包密码
    private String password;
    // 是否有待产宝宝（为空没有  1、有）
    private Integer havebaby;
    // 洞房时间
    private long makeloveTime;
    //结婚的对象
    private String marryObject;
    //宝宝id
    private BigDecimal babyId;
    //角色技能ID
    private BigDecimal SkillS_Id;
    //宝宝状态
    private String babyState;
    // 累计充值金额
    private Integer money;
    //队伍信息（队长名字|队员一|队员二|.......）
    private String teamInfo;
    //技能集合 技能名字=熟练度|技能名字=熟练度
    private String Skills;
    // 定时物品效果使用
    private String TimingGood;
    // 转生标识字段（0转为0，1转为1以此类推）
    private int TurnAround;
    // 坐牢标志      PK点数=身份标志=做天牢次数=每周坐牢次数
    private String taskDaily;
    private String born;
    //帮派守护主副抗性字段(抗性)  存储形式(主属性=值|副属性=值)
    private String resistance;
    //角色服务器区号
    private String serverMeString;
    //记录完成次数
    private String taskComplete;
    //记录任务数据
    private String taskData;
    //记录使用的双倍时间 剩余精确到秒 6小时 21600秒
    private Integer DBExp;
    //记录积分
    private String Score;
    //记录击杀记录
    private String Kill;
    // 抽奖时间
    private Date drawing;
    //记录帮派积分
    private Integer bangScore;
    //额外皮肤
    private String skin;
    private String meridians; //完整经脉系统
    private BigDecimal Paysum;// 角色的总充值积分，
    private BigDecimal Daypaysum;// 角色的日累计充值
    private BigDecimal Dayandpayorno;//连续充值标识 1-7
    private int Dayfirstinorno;//是否最新叠加冲值标识 0 表示没 有叠加，1 表示今日已经叠加
    private int attachPack;// 扩充背包数量
    private int hjmax;//战绩系统
    private int dianka;//点卡系统
    private BigDecimal Daygetorno;// 每日特惠领取与否 1 表示领取 2 表示没有
    private String Vipget;// 特权领取规则 1=1|2|3&&2=1|2|3其中1=表示vip特权,2=表示每日充 值领取等级包，1 表示 1 级，2 表示 2 级，以此类推。
    private int lowOrHihtpack;//小资礼包/土豪礼包获取 权限 1 表示小资礼包，2 表示土豪礼包。
    //展示

    private String gmshoptype;//
    private Boolean divineRune = false;

    private Integer fmsld;
    private String xy;

    private String qianDao;//ED=1,10&1,7
    private Long loginTime;
    private Long onlineTime;


    private String xingpans;
    private String fmSkills;
    private BigDecimal tiantipkrecord;
    private Integer tiantiyisheng;
    private Integer tiantisansheng;
    private Integer tiantilingqu;
    private Integer gradeincrease;//人物等级上限增加
    private Integer gameTimeRemaining;//剩余点卡
    private String gameStartTime;//剩余点卡
    private Integer currentattribute;//当前属性编号
    private List<RoleSummoning> showRoleSummoningList;


}
