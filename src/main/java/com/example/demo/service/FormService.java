package com.example.demo.service;

import com.example.demo.common.utils.UUIDUtil;
import com.example.demo.dao.FormEntityMapper;
import com.example.demo.dao.entity.FormEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormService {
  @Autowired private FormEntityMapper formEntityMapper;

  public List<FormEntity> queryFormList(FormEntity formEntity) {
    return formEntityMapper.queryFormList(formEntity);
  }

  public List<FormEntity> queryFormListByPid(FormEntity formEntity) {
    return formEntityMapper.queryFormListByPid(formEntity);
  }

  public int addFormInfo(FormEntity formEntity) {
    formEntity.setId(UUIDUtil.getOneUUID());
    int result = formEntityMapper.insert(formEntity);
    if (result != 0) {
      return 3;
    } else {
      return result;
    }
  }

  public int modifyFormInfo(FormEntity formEntity) {
    return formEntityMapper.updateByPrimaryKeySelective(formEntity);
  }

  public FormEntity selectFormInfo(FormEntity formEntity) {
    return formEntityMapper.selectFormInfo(formEntity);
  }

  public int deleteFormById(FormEntity formEntity) {
    return formEntityMapper.deleteFormById(formEntity);
  }
}
