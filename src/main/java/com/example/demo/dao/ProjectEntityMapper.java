package com.example.demo.dao;

import com.example.demo.dao.entity.ProjectEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.List;

@Component
@Mapper
public interface ProjectEntityMapper {
	List<ProjectEntity> queryProjectList(ProjectEntity projectEntity);

	int insert(ProjectEntity projectEntity);

	int deleteProjectById(ProjectEntity projectEntity);

	int updateByPrimaryKeySelective(ProjectEntity projectEntity);

	List<ProjectEntity> selectProjectInfo(ProjectEntity projectEntity);
}
