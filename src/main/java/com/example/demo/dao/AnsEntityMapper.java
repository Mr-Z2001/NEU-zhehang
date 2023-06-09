package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.example.demo.dao.entity.AnsEntity;

@Component
@Mapper
public interface AnsEntityMapper {
    List<AnsEntity> queryAnsList(AnsEntity ansEntity);

    List<AnsEntity> queryAnsListByPid(AnsEntity ansEntity);

    List<AnsEntity> queryAnsListByFid(AnsEntity ansEntity);

    int insert(AnsEntity ansEntity);

    int deleteAnsById(AnsEntity ansEntity);

    int updateByPrimaryKeySelective(AnsEntity ansEntity);

    AnsEntity selectAnsInfo(AnsEntity ansEntity);
}
