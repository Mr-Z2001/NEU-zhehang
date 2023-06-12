package com.example.demo.controller;

import com.example.demo.beans.HttpResponseEntity;
import com.example.demo.dao.entity.UserEntity;
import com.example.demo.service.UserService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class UserController {
  @Autowired private UserService userService;

  @RequestMapping(value = "/userLogin", method = RequestMethod.POST,
                  headers = "Accept=application/json")
  public HttpResponseEntity
  userLogin(@RequestBody UserEntity userEntity) {
    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    try {
      List<UserEntity> hasUser = userService.queryUserListByRedis(userEntity);
      System.out.println(hasUser);
      System.out.println(hasUser==null);
      if(hasUser==null) hasUser = userService.selectUserInfo(userEntity);
//      List<UserEntity> hasUser = userService.selectUserInfo(userEntity);
      if (CollectionUtils.isEmpty(hasUser)) {
        httpResponseEntity.setCode("0");
        httpResponseEntity.setData("");
        httpResponseEntity.setMessage("用户名或密码错误");
      } else {
        httpResponseEntity.setCode("666");
        httpResponseEntity.setData(hasUser.get(0));
        httpResponseEntity.setMessage("登陆成功");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    return httpResponseEntity;
  }

  @RequestMapping(value = "/addUserinfo", method = RequestMethod.POST,
                  headers = "Accept=application/json")
  public HttpResponseEntity
  addUserinfo(@RequestBody UserEntity userEntity) {

    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    try {
      int result = userService.addUserInfo(userEntity);
      if (result != 0) {
        userService.addUserInfoToRedis(userEntity);
        httpResponseEntity.setCode("666");
        httpResponseEntity.setData(result);
        httpResponseEntity.setMessage("创建成功");
      } else {
        httpResponseEntity.setCode("0");
        httpResponseEntity.setData(0);
        httpResponseEntity.setMessage("创建失败");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    return httpResponseEntity;
  }

  @RequestMapping(value = "/modifyUserinfo", method = RequestMethod.POST,
                  headers = "Accept=application/json")
  public HttpResponseEntity
  modifyUserinfo(@RequestBody UserEntity userEntity) {
    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    try {
      int result = userService.modifyUserInfo(userEntity);
      if (result != 0) {
        userService.modifyUserInfoToRedis(userEntity);
        httpResponseEntity.setCode("666");
        httpResponseEntity.setData(result);
        httpResponseEntity.setMessage("修改成功");
      } else {
        httpResponseEntity.setCode("0");
        httpResponseEntity.setData(0);
        httpResponseEntity.setMessage("修改失败");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    return httpResponseEntity;
  }

  @RequestMapping(value = "/deleteUserById", method = RequestMethod.POST,
                  headers = "Accept=application/json")
  public HttpResponseEntity
  deleteUserinfo(@RequestBody UserEntity userEntity) {
    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    try {
      int result = userService.deleteUserById(userEntity);
      if (result != 0) {
        userService.deleteUserInfoFromRedis(userEntity);
        httpResponseEntity.setCode("666");
        httpResponseEntity.setData(result);
        httpResponseEntity.setMessage("删除成功");
      } else {
        httpResponseEntity.setCode("0");
        httpResponseEntity.setData(0);
        httpResponseEntity.setMessage("删除失败");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    return httpResponseEntity;
  }

  @RequestMapping(value = "/queryUserList", method = RequestMethod.POST,
                  headers = "Accept=application/json")
  public HttpResponseEntity
  queryUserList(@RequestBody UserEntity userEntity) {
    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    try {
      List<UserEntity> hasUser = userService.queryUserList(userEntity);
      if (CollectionUtils.isEmpty(hasUser)) {
        httpResponseEntity.setCode("0");
        httpResponseEntity.setData("");
        httpResponseEntity.setMessage("无用户信息");
      } else {
        httpResponseEntity.setCode("666");
        httpResponseEntity.setData(hasUser);
        httpResponseEntity.setMessage("查询成功");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    return httpResponseEntity;
  }
}
