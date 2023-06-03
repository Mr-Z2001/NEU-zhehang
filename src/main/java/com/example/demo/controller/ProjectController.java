package com.example.demo.controller;

import com.example.demo.beans.HttpResponseEntity;
import com.example.demo.dao.ProjectEntityMapper;
import com.example.demo.dao.entity.ProjectEntity;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class ProjectController {
  @Autowired private ProjectService projectService;

  @RequestMapping(
      value = "/queryProjectList",
      method = RequestMethod.POST,
      headers = "Accept=application/json")
  public HttpResponseEntity queryProjectList(@RequestBody ProjectEntity projectEntity) {
    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    try {
      List<ProjectEntity> hasProject = projectService.queryProjectList(projectEntity);
      if (CollectionUtils.isEmpty(hasProject)) {
        httpResponseEntity.setCode("0");
        httpResponseEntity.setData("");
        httpResponseEntity.setMessage("查询失败");
      } else {
        httpResponseEntity.setCode("666");
        httpResponseEntity.setData(hasProject);
        httpResponseEntity.setMessage("查询成功");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    return httpResponseEntity;
  }

  @RequestMapping(
      value = "/addProjectInfo",
      method = RequestMethod.POST,
      headers = "Accept=application/json")
  public HttpResponseEntity addProjectInfo(@RequestBody ProjectEntity projectEntity) {
    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    try {
      System.out.println("Project Service entered");
      int result = projectService.addProjectInfo(projectEntity, "default_user");
      if (result != 0) {
        httpResponseEntity.setCode("666");
        httpResponseEntity.setData(result);
        httpResponseEntity.setMessage("创建成功");
      } else {
        httpResponseEntity.setCode("0");
        httpResponseEntity.setData("");
        httpResponseEntity.setMessage("创建失败");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    return httpResponseEntity;
  }

  @RequestMapping(
      value = "/deleteProjectById",
      method = RequestMethod.POST,
      headers = "Accept=application/json")
  public ProjectEntity deleteProjectById(@RequestBody ProjectEntity projectEntity) {
    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    try {
      int result = projectService.deleteProjectById(projectEntity);
      if (result != 0) {
        httpResponseEntity.setCode("666");
        httpResponseEntity.setData(result);
        httpResponseEntity.setMessage("删除成功");
      } else {
        httpResponseEntity.setCode("0");
        httpResponseEntity.setData("");
        httpResponseEntity.setMessage("删除失败");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    return projectEntity;
  }

  @RequestMapping(
      value = "/modifyProjectInfo",
      method = RequestMethod.POST,
      headers = "Accept=application/json")
  public HttpResponseEntity modifyProjectInfo(@RequestBody ProjectEntity projectEntity) {
    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    try {
      int result = projectService.modifyProjectInfo(projectEntity, "default_user");
      if (result != 0) {
        httpResponseEntity.setCode("666");
        httpResponseEntity.setData(result);
        httpResponseEntity.setMessage("修改成功");
      } else {
        httpResponseEntity.setCode("0");
        httpResponseEntity.setData("");
        httpResponseEntity.setMessage("修改失败");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    return httpResponseEntity;
  }

  @RequestMapping(
      value = "/selectProjectInfo",
      method = RequestMethod.POST,
      headers = "Accept=application/json")
  public HttpResponseEntity selectProjectInfo(@RequestBody ProjectEntity projectEntity) {
    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    try {
      List<ProjectEntity> hasProject = projectService.selectProjectInfo(projectEntity);
      if (CollectionUtils.isEmpty(hasProject)) {
        httpResponseEntity.setCode("0");
        httpResponseEntity.setData("");
        httpResponseEntity.setMessage("查询失败");
      } else {
        httpResponseEntity.setCode("666");
        httpResponseEntity.setData(hasProject);
        httpResponseEntity.setMessage("查询成功");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    return httpResponseEntity;
  }
}
