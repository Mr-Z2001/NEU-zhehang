package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.utils.UUIDUtil;
import com.example.demo.dao.AnsEntityMapper;
import com.example.demo.dao.entity.AnsEntity;

@Service
public class AnsService {
    @Autowired private AnsEntityMapper ansEntityMapper;

    public List<AnsEntity> queryAnsList(AnsEntity ansEntity) {
        return ansEntityMapper.queryAnsList(ansEntity);
    }

    public List<AnsEntity> queryAnsListByPid(AnsEntity ansEntity) {
        return ansEntityMapper.queryAnsListByPid(ansEntity);
    }

    public List<AnsEntity> queryAnsListByFid(AnsEntity ansEntity) {
        return ansEntityMapper.queryAnsListByFid(ansEntity);
    }

    
  public int addAnsInfo(AnsEntity ansEntity) {
    ansEntity.setId(UUIDUtil.getOneUUID());
    int result = ansEntityMapper.insert(ansEntity);
    if (result != 0) {
      return 3;
    } else {
      return result;
    }
  }

  public int modifyAnsInfo(AnsEntity ansEntity) {
    return ansEntityMapper.updateByPrimaryKeySelective(ansEntity);
  }

  public AnsEntity selectAnsInfo(AnsEntity ansEntity) {
    return ansEntityMapper.selectAnsInfo(ansEntity);
  }

  public int deleteAnsById(AnsEntity ansEntity) {
    return ansEntityMapper.deleteAnsById(ansEntity);
  }
}
