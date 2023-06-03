package com.example.demo.service;

import com.example.demo.dao.ProjectEntityMapper;
import com.example.demo.dao.entity.ProjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import com.example.demo.common.utils.UUIDUtil;

@Service
public class ProjectService {
  @Autowired private ProjectEntityMapper projectEntityMapper;

  public List<ProjectEntity> queryProjectList(ProjectEntity projectEntity) {
    return projectEntityMapper.queryProjectList(projectEntity);
  }

  public int addProjectInfo(ProjectEntity projectEntity, String userName) {
    projectEntity.setId(UUIDUtil.getOneUUID());
//    projectEntity.setCreatedBy(userName);
//    projectEntity.setProjectContent("default_content");
    projectEntity.setCreationDate(new Date());
    int result = projectEntityMapper.insert(projectEntity);
    System.out.println("result:" + result);
    if (result != 0) {
      return 3;
    } else {
      return result;
    }
  }

  public int modifyProjectInfo(ProjectEntity projectEntity, String userName) {
    return projectEntityMapper.updateByPrimaryKeySelective(projectEntity);
  }

  public List<ProjectEntity> selectProjectInfo(ProjectEntity projectEntity) {
    return projectEntityMapper.selectProjectInfo(projectEntity);
  }

  public int deleteProjectById(ProjectEntity projectEntity) {
    return projectEntityMapper.deleteProjectById(projectEntity);
  }
}
