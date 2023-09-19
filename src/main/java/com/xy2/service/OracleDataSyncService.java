package com.xy2.service;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.StopWatch;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONNull;
import cn.hutool.json.JSONUtil;
import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.xy2.bean.RoleDataBean;
import com.xy2.bean.UserDataBean;
import com.xy2.entity.*;
import com.xy2.repository.*;
import com.xy2.utils.RedisParameterUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.Local;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


@Slf4j
@Service
public class OracleDataSyncService {

    Map<Long, Long> roleRel = new HashMap<>();//key 是旧角色ID value是新角色ID
    Map<Long, Long> gangRel = new HashMap<>();//key 是旧帮派ID value是帮派ID


    @Autowired
    DataSource dataSource;

    private static JdbcTemplate jdbcTemplate1;

    private static JdbcTemplate jdbcTemplate2;

    @Value("${server.hq}")
    private String hq;

    @Autowired
    private  RedisDataSyncService redisDataSyncService;

    @Autowired
    private void setJdbcTemplate1() {
        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds.getDataSource("slave_1"));
        OracleDataSyncService.setJdbcTemplate1Factory(jdbcTemplate);
    }

    private static void setJdbcTemplate1Factory(JdbcTemplate factory) {
        OracleDataSyncService.jdbcTemplate1 = factory;
    }

    @Autowired
    private void setJdbcTemplate2() {
        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds.getDataSource("slave_2"));
        OracleDataSyncService.setJdbcTemplate2Factory(jdbcTemplate);
    }

    private static void setJdbcTemplate2Factory(JdbcTemplate factory) {
        OracleDataSyncService.jdbcTemplate2 = factory;
    }

    @Transactional
    public void findAll() {
        try {
            this.syncUserTable();
        } catch (Exception e) {
            log.error("sync 异常  本次同步 回滚到最初状态！！！", e);
        }
        System.out.println("success");

    }

    @Autowired
    private AgenttableDaoImpl agenttableDao;

    //代理表同步
    private void syncAgenttable() {
        //查询是否有数据需要合并
        List<Agenttable> allList = agenttableDao.findAllList(jdbcTemplate1, null);
        if (ObjectUtil.isAllEmpty(allList)) {
            return;
        }

        allList.forEach(a -> {
            //数据源1的数据到数据源2里面查找id是否已存 不存在 直接新增 已存在 查询最大的id 在现有ID上面递增
            Agenttable byId = agenttableDao.findById(jdbcTemplate2, Integer.parseInt(a.getAtId()));
            if (Objects.isNull(byId)) {
                agenttableDao.add(jdbcTemplate2, byId);
            } else {
                agenttableDao.topId(jdbcTemplate2, "tb_id");
            }
        });
    }

    @Autowired
    private UsertableDaoImpl usertableDao;


    //用户表同步
    private void syncUserTable() {

        StopWatch stopWatch = new StopWatch();
        //用于存放新旧角色ID
        List<UserDataBean> userDataBeans = this.userDataBuilds();

        stopWatch.start("USERTABLE -> 开始同步数据...| 共计：" + userDataBeans.size() + " 条|");

        //开始同步帮派数据
        List<Gang> gangs = this.gangDataBuilds();
        gangs.forEach(gang -> {
            Long gangId = gangDao.topId(jdbcTemplate2, "gangid");
            String oldGangId = gang.getGangid();
            gang.setGangid(String.valueOf(gangId));
            boolean gangNameExists = gangDao.isGangNameExists(jdbcTemplate2, gang.getGangname());
            if (gangNameExists) {
                gang.setGangname(hq + gang.getGangname());
            }
            gangRel.put(Long.parseLong(oldGangId), gangId);
            gangDao.add(jdbcTemplate2, gang);
        });

        //开始同步用户数据
        userDataBeans.forEach(userDataBean -> {
            LocalDateTime lasetLoginTime = LocalDateTime.parse(userDataBean.getUserTable().getUserlastlogin(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            long days = Duration.between(lasetLoginTime, LocalDateTime.now()).toDays();
            //账号大于40天未登录进行清除
            if (days > 40) {
                return;
            }
            Boolean usernameExists = usertableDao.isUsernameExists(jdbcTemplate2, userDataBean.getUserTable().getUsername());
            //名字是否已存在
            if (usernameExists) {
                userDataBean.getUserTable().setUsername("hq99" + usernameExists);
            }
            Long user_id = usertableDao.topId(jdbcTemplate2, "user_id");
            userDataBean.getUserTable().setUserId(String.valueOf(user_id));
            usertableDao.add(jdbcTemplate2, userDataBean.getUserTable());

            userDataBean.getRoleDataBeans().forEach(roleDataBean -> {
                //写入角色
                RoleTable roleTable = roleDataBean.getRoleTable();
                Long role_id = roleTableDao.topId(jdbcTemplate2, "role_id");
                roleRel.put(Long.parseLong(roleTable.getRoleId()), role_id);
                boolean roleNameExists = roleTableDao.isRoleNameExists(jdbcTemplate2, roleTable.getRolename());
                if (roleNameExists) {
                    roleTable.setRolename(hq + roleTable.getRolename());
                }
                //如果有帮派写入帮派数据
                Long aLong = gangRel.get(roleTable.getGangId());
                if (Objects.nonNull(aLong)) {
                    roleTable.setGangId(String.valueOf(aLong));
                }
                roleTableDao.add(jdbcTemplate2, roleTable);
                //写入角色背包数据
                PackRecord packRecord = roleDataBean.getPackRecord();
                packRecord.setRoleId(String.valueOf(role_id));
                packRecordDao.add(jdbcTemplate2, packRecord);
                //写入角色物品数据
                roleDataBean.getGoodstables().forEach(goodstable -> {
                    goodstable.setRoleId(String.valueOf(role_id));
                    goodstableDao.add(jdbcTemplate2, goodstable);
                    redisDataSyncService.insertKey(RedisParameterUtil.GOODS, goodstable.getRgid() + "", JSONUtil.toJsonStr(goodstable));
                    redisDataSyncService.insertListRedis(RedisParameterUtil.GOODS, goodstable.getRoleId(), goodstable.getRgid());
                    redisDataSyncService.insertListRedis(RedisParameterUtil.GOODSID + "_" + goodstable.getRoleId(), goodstable.getGoodsid(), goodstable.getRgid());
                    redisDataSyncService.insertListRedis(RedisParameterUtil.GOODSST + "_" + goodstable.getRoleId(), goodstable.getStatus(), goodstable.getRgid());
                    redisDataSyncService.insertRoleControAdd(RedisParameterUtil.GOODS, goodstable.getRgid());
                });
                //写入角色召唤兽数据
                roleDataBean.getPets().forEach(pet -> {
                    pet.setRoleid(String.valueOf(role_id));
                    roleSummoningDao.add(jdbcTemplate2, pet);
                    redisDataSyncService.insertKey(RedisParameterUtil.PET, pet.getSid(), JSONUtil.toJsonStr(pet));
                    redisDataSyncService.insertListRedis(RedisParameterUtil.PET, pet.getRoleid(), pet.getSid());
                    redisDataSyncService.insertRoleControAdd(RedisParameterUtil.PET, pet.getSid());
                });
                //写入角色坐骑数据
                roleDataBean.getMounts().forEach(mount -> {
                    mount.setRoleid(String.valueOf(role_id));
                    mountDao.add(jdbcTemplate2, mount);
                    redisDataSyncService.insertKey(RedisParameterUtil.MOUNT, mount.getMid(),JSONUtil.toJsonStr(mount));
                    redisDataSyncService.insertListRedis(RedisParameterUtil.MOUNT, mount.getRoleid(), mount.getMid());
                    redisDataSyncService.insertRoleControAdd(RedisParameterUtil.MOUNT, mount.getMid());
                });
                //写入角色飞行器数据
                roleDataBean.getFlys().forEach(fly -> {
                    fly.setRoleId(String.valueOf(role_id));
//                    rolrFlyDao.add(jdbcTemplate2, fly);
                    redisDataSyncService.insertKey(RedisParameterUtil.FLY, fly.getMid(), JSONUtil.toJsonStr(fly));
                    redisDataSyncService.insertListRedis(RedisParameterUtil.FLY,fly.getRoleId(), fly.getMid());
                    redisDataSyncService.insertRoleControAdd(RedisParameterUtil.FLY, fly.getMid());
                });
                //写入角色灵宝数据
                roleDataBean.getLingbaos().forEach(lingbao -> {
                    lingbao.setRoleid(String.valueOf(role_id));
                    lingbaoDao.add(jdbcTemplate2, lingbao);
                    redisDataSyncService.insertKey(RedisParameterUtil.LINGBAO, lingbao.getBaoid() + "", JSONUtil.toJsonStr(lingbao));
                    redisDataSyncService.insertListRedis(RedisParameterUtil.LINGBAO, lingbao.getRoleid().toString(), lingbao.getBaoid() + "");
                    redisDataSyncService.insertRoleControAdd(RedisParameterUtil.LINGBAO, lingbao.getBaoid());
                });
                //写入角色孩子数据
                roleDataBean.getBabys().forEach(baby -> {
                    baby.setRoleid(String.valueOf(role_id));
                    babyDao.add(jdbcTemplate2, baby);
                    redisDataSyncService.insertKey(RedisParameterUtil.BABY,baby.getBabyid(), JSONUtil.toJsonStr(baby));
                    redisDataSyncService.insertListRedis(RedisParameterUtil.BABY,baby.getRoleid(),baby.getBabyid());
                    redisDataSyncService.insertRoleControAdd(RedisParameterUtil.BABY, baby.getBabyid());
                });
                //写入角色称谓数据
                roleDataBean.getTitletables().forEach(titletable -> {
                    titletable.setRoleid(String.valueOf(role_id));
                    titletableDao.add(jdbcTemplate2, titletable);
                });
                //写入角色伙伴数据
                roleDataBean.getRolePals().forEach(rolePal -> {
                    rolePal.setRoleid(String.valueOf(role_id));
                    rolePalDao.add(jdbcTemplate2, rolePal);
                });

            });
        });

        //开始同步好友数据
        List<Friend> friends = this.friendDataBuilds();
        friends.forEach(friend -> {
            Long fid = friendDao.topId(jdbcTemplate2, "fid");
            Long newRole = roleRel.get(friend.getRoleid());
            if (Objects.isNull(newRole)) {
                return;
            }
            Long newFriend = roleRel.get(friend.getFriendid());
            if (Objects.isNull(newFriend)) {
                return;
            }
            friend.setFid(String.valueOf(fid));
            friend.setRoleid(String.valueOf(newRole));
            friend.setFriendid(String.valueOf(newFriend));
            friendDao.add(jdbcTemplate2, friend);
        });
        log.info("USERTABLE---同步数据完成 共计：【耗时{}】");
        stopWatch.stop();
    }


    @Autowired
    private RoleTableDaoImpl roleTableDao;
    @Autowired
    private PackRecordDaoImpl packRecordDao;
    @Autowired
    private GoodstableDaoImpl goodstableDao;
    @Autowired
    private RoleSummoningDaoImpl roleSummoningDao;
    @Autowired
    private MountDaoImpl mountDao;
    @Autowired
    private RolrFlyDaoImpl rolrFlyDao;
    @Autowired
    private LingbaoDaoImpl lingbaoDao;
    @Autowired
    private BabyDaoImpl babyDao;
    @Autowired
    private TitletableDaoImpl titletableDao;
    @Autowired
    private RolePalDaoImpl rolePalDao;

    /**
     * 封装合区用户数据
     *
     * @return
     */
    private List<UserDataBean> userDataBuilds() {
        List<UserDataBean> userDataBeans = new ArrayList<>();
        List<Usertable> allList = usertableDao.findAllList(jdbcTemplate1);
        allList.forEach(usertable -> {
            UserDataBean userDataBean = new UserDataBean();
            userDataBean.setUserTable(usertable);
            List<RoleTable> roleTables = roleTableDao.findAllListByUserId(jdbcTemplate1, Long.parseLong(usertable.getUserId()));
            List<RoleDataBean> roleDataBeans = new ArrayList<>();
            roleTables.forEach(role -> {
                RoleDataBean roleDataBean = new RoleDataBean();
                //角色信息
                roleDataBean.setRoleTable(role);
                //背包信息
                List<PackRecord> packRecords = packRecordDao.findAllListByRoleId(jdbcTemplate1, Long.parseLong(role.getRoleId()));
                if (packRecords.size() > 0) {
                    roleDataBean.setPackRecord(packRecords.get(0));
                }
                //物品信息
                List<Goodstable> goodstables = goodstableDao.findAllListByRoleId(jdbcTemplate1, Long.parseLong(role.getRoleId()));
                if(ObjectUtil.isNull(goodstables)){
                    //从缓存中取

                }
                roleDataBean.setGoodstables(goodstables);
                //召唤兽信息
                List<RoleSummoning> roleSumms = roleSummoningDao.findAllListByRoleId(jdbcTemplate1, Long.parseLong(role.getRoleId()));
                if(ObjectUtil.isNull(roleSumms)){
                    //从缓存中取

                }
                roleDataBean.setPets(roleSumms);
                //坐骑信息
                List<Mount> mounts = mountDao.findAllListByRoleId(jdbcTemplate1, Long.parseLong(role.getRoleId()));
                if(ObjectUtil.isNull(mounts)){
                    //从缓存中取

                }
                roleDataBean.setMounts(mounts);
                //飞行器信息
                List<RolrFly> rolrFlys = rolrFlyDao.findAllListByRoleId(jdbcTemplate1, Long.parseLong(role.getRoleId()));
                if(ObjectUtil.isNull(rolrFlys)){
                    //从缓存中取

                }
                roleDataBean.setFlys(rolrFlys);
                //灵宝信息
                List<Lingbao> lingbaos = lingbaoDao.findAllListByRoleId(jdbcTemplate1, Long.parseLong(role.getRoleId()));
                if(ObjectUtil.isNull(lingbaos)){
                    //从缓存中取

                }
                roleDataBean.setLingbaos(lingbaos);
                //孩子信息
                List<Baby> babys = babyDao.findAllListByRoleId(jdbcTemplate1, Long.parseLong(role.getRoleId()));
                if(ObjectUtil.isNull(babys)){
                    //从缓存中取

                }
                roleDataBean.setBabys(babys);
                //称号信息
                List<Titletable> titles = titletableDao.findAllListByRoleId(jdbcTemplate1, Long.parseLong(role.getRoleId()));
                if(ObjectUtil.isNull(titles)){
                    //从缓存中取

                }
                roleDataBean.setTitletables(titles);
                //伙伴信息
                List<RolePal> rolePals = rolePalDao.findAllListByRoleId(jdbcTemplate1, Long.parseLong(role.getRoleId()));
                if(ObjectUtil.isNull(rolePals)){
                    //从缓存中取

                }
                roleDataBean.setRolePals(rolePals);
                roleDataBeans.add(roleDataBean);
            });
            userDataBean.setRoleDataBeans(roleDataBeans);
            userDataBeans.add(userDataBean);
        });
        return userDataBeans;
    }


    @Autowired
    private FriendDaoImpl friendDao;

    //封装好友数据
    private List<Friend> friendDataBuilds() {
        List<Friend> allList = friendDao.findAllList(jdbcTemplate1, null);
        return allList;
    }

    @Autowired
    private GangDaoImpl gangDao;

    //封装帮派数据
    private List<Gang> gangDataBuilds() {
        List<Gang> allList = gangDao.findAllList(jdbcTemplate1, null);
        return allList;
    }
}
