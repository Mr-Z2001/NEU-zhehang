package com.example.demo.dao;

import com.example.demo.dao.entity.UserEntity;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserEntityMapper {

  List<UserEntity> queryUserList(UserEntity userEntity);

  int insert(UserEntity userEntity);

  int deleteUserById(UserEntity userEntity);

  int updateByPrimaryKeySelective(UserEntity userEntity);

  List<UserEntity> selectUserInfo(UserEntity userEntity);
}
