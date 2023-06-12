package com.example.demo.service;

import com.example.demo.common.utils.UUIDUtil;
import com.example.demo.dao.UserEntityMapper;
import com.example.demo.dao.entity.UserEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class UserService {
  @Autowired private UserEntityMapper userEntityMapper;

  public List<UserEntity> queryUserList(UserEntity userEntity) {
    return userEntityMapper.queryUserList(userEntity);
  }

  public List<UserEntity> selectUserInfo(UserEntity userEntity) {
    return userEntityMapper.selectUserInfo(userEntity);
  }

  public int addUserInfo(UserEntity userEntity) {
    userEntity.setId(UUIDUtil.getOneUUID());
    int userResult = userEntityMapper.insert(userEntity);
    if (userResult != 0) {
      return 3; // 3代表用户存在
    } else {
      return userResult;
    }
  }

  public int modifyUserInfo(UserEntity userEntity) {
    return userEntityMapper.updateByPrimaryKeySelective(userEntity);
  }

  public int deleteUserById(UserEntity userEntity) {
    return userEntityMapper.deleteUserById(userEntity);
  }

  // redis related
  public List<UserEntity> queryUserListByRedis(UserEntity userEntity) throws ParseException {
    List<UserEntity> ret = new ArrayList<UserEntity>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    Jedis jedis = new Jedis("localhost", 6379);
    System.out.println(jedis.ping());
    // use database 0
    jedis.select(0);
    // read all
    Set<String> userIDs = jedis.smembers("users");
    System.out.println(userIDs);
    for (String userID : userIDs) {
      Map<String, String> userData = jedis.hgetAll(userID);
      UserEntity userEntity_tmp = new UserEntity();
      userEntity_tmp.setId(userID.substring(5));
      userEntity_tmp.setUsername(userData.get("username"));
      userEntity_tmp.setPassword(userData.get("password"));
      userEntity_tmp.setStartTime(sdf.parse(userData.get("start_time")));
      userEntity_tmp.setStopTime(sdf.parse(userData.get("stop_time")));
      userEntity_tmp.setStatus(userData.get("status"));
      userEntity_tmp.setCreatedBy(userData.get("created_by"));
      userEntity_tmp.setCreationDate(sdf.parse(userData.get("creation_date")));
      userEntity_tmp.setLastUpdatedBy(userData.get("last_updated_by"));
      userEntity_tmp.setLastUpdateDate(sdf.parse(userData.get("last_update_date")));
      ret.add(userEntity_tmp);
    }
    jedis.close();
    return ret;
  }

  public int addUserInfoToRedis(UserEntity userEntity){
    Jedis jedis = new Jedis("localhost", 6379);
    System.out.println(jedis.ping());
    // use database 0
    jedis.select(0);
    // check if the user already exists
    if (jedis.exists("user:" + userEntity.getId())) {
      return 3; // 3代表用户存在
    }
    // add user
    Map<String, String> userData = new HashMap<String, String>();
    userData.put("username", userEntity.getUsername());
    userData.put("password", userEntity.getPassword());
    userData.put("start_time", userEntity.getStartTime().toString());
    userData.put("stop_time", userEntity.getStopTime().toString());
    userData.put("status", userEntity.getStatus());
    userData.put("created_by", userEntity.getCreatedBy());
    userData.put("creation_date", userEntity.getCreationDate().toString());
    userData.put("last_updated_by", userEntity.getLastUpdatedBy());
    userData.put("last_update_date", userEntity.getLastUpdateDate().toString());
    jedis.hmset("user:" + userEntity.getId(), userData);
    // add user id to users
    jedis.sadd("users", "user:" + userEntity.getId());
    jedis.close();
    return 1;
  }

  public int modifyUserInfoToRedis(UserEntity userEntity){
    Jedis jedis = new Jedis("localhost", 6379);
    System.out.println(jedis.ping());
    // use database 0
    jedis.select(0);
    // modify user
    Map<String, String> userData = new HashMap<String, String>();
    userData.put("username", userEntity.getUsername());
    userData.put("password", userEntity.getPassword());
    userData.put("start_time", userEntity.getStartTime().toString());
    userData.put("stop_time", userEntity.getStopTime().toString());
    userData.put("status", userEntity.getStatus());
    userData.put("created_by", userEntity.getCreatedBy());
    userData.put("creation_date", userEntity.getCreationDate().toString());
    userData.put("last_updated_by", userEntity.getLastUpdatedBy());
    userData.put("last_update_date", userEntity.getLastUpdateDate().toString());
    jedis.hmset("user:" + userEntity.getId(), userData);
    jedis.close();
    return 1;
  }

  public int deleteUserInfoFromRedis(UserEntity userEntity){
    Jedis jedis = new Jedis("localhost", 6379);
    System.out.println(jedis.ping());
    // use database 0
    jedis.select(0);
    // delete user
    jedis.del("user:" + userEntity.getId());
    // delete user id from users
    jedis.srem("users", "user:" + userEntity.getId());
    jedis.close();
    return 1;
  }
}
