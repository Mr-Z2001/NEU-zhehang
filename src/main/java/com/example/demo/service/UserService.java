package com.example.demo.service;

import com.example.demo.common.utils.UUIDUtil;
import com.example.demo.dao.UserEntityMapper;
import com.example.demo.dao.entity.UserEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
      return 3;
      // 3代表用户存在
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
}
