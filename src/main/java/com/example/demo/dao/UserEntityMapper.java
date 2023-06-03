package com.example.demo.dao;

import com.example.demo.dao.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface UserEntityMapper {

  List<UserEntity> queryUserList(UserEntity userEntity);

  int insert(UserEntity userEntity);

  int deleteUserById(UserEntity userEntity);

  int updateByPrimaryKeySelective(UserEntity userEntity);

  List<UserEntity> selectUserInfo(UserEntity userEntity);
}
