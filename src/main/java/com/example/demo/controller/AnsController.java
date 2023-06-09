package com.example.demo.controller;

import com.example.demo.beans.HttpResponseEntity;
import com.example.demo.dao.entity.AnsEntity;
import com.example.demo.service.AnsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class AnsController {
  @Autowired private AnsService ansService;

  @RequestMapping(value = "/queryAnsList", method = RequestMethod.POST,
                  headers = "Accept=application/json")
  public HttpResponseEntity
  previewAnsSheet(@RequestBody AnsEntity ansEntity) {
    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    try {
      List<AnsEntity> hasAns = ansService.queryAnsList(ansEntity);
      if (CollectionUtils.isEmpty(hasAns)) {
        httpResponseEntity.setCode("0");
        httpResponseEntity.setData("");
        httpResponseEntity.setMessage("查询失败");
      } else {
        httpResponseEntity.setCode("666");
        httpResponseEntity.setData(hasAns);
        httpResponseEntity.setMessage("查询成功");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    return httpResponseEntity;
  }

  @RequestMapping(value = "/addAnsInfo", method = RequestMethod.POST,
                  headers = "Accept=application/json")
  public HttpResponseEntity
  addAnsInfo(@RequestBody AnsEntity ansEntity) {
    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    try {
      System.out.println("Ans Service entered");
      int result = ansService.addAnsInfo(ansEntity);
      if (result != 0) {
        httpResponseEntity.setCode("666");
        httpResponseEntity.setData(ansEntity.getId());
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

  @RequestMapping(value = "/deleteAnsById", method = RequestMethod.POST,
                  headers = "Accept=application/json")
  public AnsEntity
  deleteAnsById(@RequestBody AnsEntity ansEntity) {
    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    try {
      int result = ansService.deleteAnsById(ansEntity);
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
    return ansEntity;
  }

  @RequestMapping(value = "/modifyAnsInfo", method = RequestMethod.POST,
                  headers = "Accept=application/json")
  public HttpResponseEntity
  modifyAnsInfo(@RequestBody AnsEntity ansEntity) {
    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    try {
      int result = ansService.modifyAnsInfo(ansEntity);
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

  @RequestMapping(value = "/selectAnsInfo", method = RequestMethod.POST,
                  headers = "Accept=application/json")
  public HttpResponseEntity
  selectAnsInfo(@RequestBody AnsEntity ansEntity) {
    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    try {
      AnsEntity hasAns = ansService.selectAnsInfo(ansEntity);
      if (hasAns == null) {
        httpResponseEntity.setCode("0");
        httpResponseEntity.setData("");
        httpResponseEntity.setMessage("查询失败");
      } else {
        httpResponseEntity.setCode("666");
        httpResponseEntity.setData(hasAns);
        httpResponseEntity.setMessage("查询成功");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    return httpResponseEntity;
  }

  @RequestMapping(value = "/queryAnsListByPid", method = RequestMethod.POST,
                  headers = "Accept=application/json")
  public HttpResponseEntity
  queryAnsListByPid(@RequestBody AnsEntity ansEntity) {
    System.out.println(ansEntity.getProjectId());
    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    try {
      List<AnsEntity> hasAns = ansService.queryAnsListByPid(ansEntity);
      if (CollectionUtils.isEmpty(hasAns)) {
        httpResponseEntity.setCode("0");
        httpResponseEntity.setData("");
        httpResponseEntity.setMessage("查询失败");
      } else {
        httpResponseEntity.setCode("666");
        httpResponseEntity.setData(hasAns);
        httpResponseEntity.setMessage("查询成功");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    return httpResponseEntity;
  }

  @RequestMapping(value = "/queryAnsListByFid", method = RequestMethod.POST,
                  headers = "Accept=application/json")
  public HttpResponseEntity
  queryAnsListByFid(@RequestBody AnsEntity ansEntity) {
    System.out.println(ansEntity.getProjectId());
    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    try {
      List<AnsEntity> hasAns = ansService.queryAnsListByFid(ansEntity);
      if (CollectionUtils.isEmpty(hasAns)) {
        httpResponseEntity.setCode("0");
        httpResponseEntity.setData("");
        httpResponseEntity.setMessage("查询失败");
      } else {
        httpResponseEntity.setCode("666");
        httpResponseEntity.setData(hasAns);
        httpResponseEntity.setMessage("查询成功");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    return httpResponseEntity;
  }
}
