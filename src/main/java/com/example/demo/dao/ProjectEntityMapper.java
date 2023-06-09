package com.example.demo.dao;

import com.example.demo.dao.entity.ProjectEntity;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface ProjectEntityMapper {
  List<ProjectEntity> queryProjectList(ProjectEntity projectEntity);

  int insert(ProjectEntity projectEntity);

  int deleteProjectById(ProjectEntity projectEntity);

  int updateByPrimaryKeySelective(ProjectEntity projectEntity);

  ProjectEntity selectProjectInfo(ProjectEntity projectEntity);
}
