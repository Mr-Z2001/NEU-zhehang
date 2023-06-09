package com.example.demo.dao;

import com.example.demo.dao.entity.FormEntity;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Component
@Mapper
public interface FormEntityMapper {
  List<FormEntity> queryFormList(FormEntity formEntity);

  List<FormEntity> queryFormListByPid(FormEntity formEntity);

  int insert(FormEntity formEntity);

  int deleteFormById(FormEntity formEntity);

  int updateByPrimaryKeySelective(FormEntity formEntity);

  FormEntity selectFormInfo(FormEntity formEntity);
}
