package com.example.demo.controller;

import com.example.demo.beans.HttpResponseEntity;
import com.example.demo.dao.entity.FormEntity;
import com.example.demo.service.FormService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("")
public class FormController {
  @Autowired private FormService formService;

  @RequestMapping(value = "/queryFormList", method = RequestMethod.POST,
                  headers = "Accept=application/json")
  public HttpResponseEntity
  queryFormList(@RequestBody FormEntity formEntity) {
    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    try {
      List<FormEntity> hasForm = formService.queryFormList(formEntity);
      if (CollectionUtils.isEmpty(hasForm)) {
        httpResponseEntity.setCode("0");
        httpResponseEntity.setData("");
        httpResponseEntity.setMessage("查询失败");
      } else {
        httpResponseEntity.setCode("666");
        httpResponseEntity.setData(hasForm);
        httpResponseEntity.setMessage("查询成功");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    return httpResponseEntity;
  }

  
  @RequestMapping(value = "/addFormInfo", method = RequestMethod.POST,
                  headers = "Accept=application/json")
  public HttpResponseEntity
  addFormInfo(@RequestBody FormEntity formEntity) {
    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    try {
      System.out.println("Form Service entered");
      int result = formService.addFormInfo(formEntity);
      if (result != 0) {
        httpResponseEntity.setCode("666");
        httpResponseEntity.setData(formEntity.getId());
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

  @RequestMapping(value = "/deleteFormById", method = RequestMethod.POST,
                  headers = "Accept=application/json")
  public FormEntity
  deleteFormById(@RequestBody FormEntity formEntity) {
    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    try {
      int result = formService.deleteFormById(formEntity);
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
    return formEntity;
  }

  @RequestMapping(value = "/modifyFormInfo", method = RequestMethod.POST,
                  headers = "Accept=application/json")
  public HttpResponseEntity
  modifyFormInfo(@RequestBody FormEntity formEntity) {
    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    try {
      int result =
          formService.modifyFormInfo(formEntity);
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

  @RequestMapping(value = "/selectFormInfo", method = RequestMethod.POST,
                  headers = "Accept=application/json")
  public HttpResponseEntity
  selectFormInfo(@RequestBody FormEntity formEntity) {
    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    try {
      FormEntity hasForm =
          formService.selectFormInfo(formEntity);
      if (hasForm == null) {
        httpResponseEntity.setCode("0");
        httpResponseEntity.setData("");
        httpResponseEntity.setMessage("查询失败");
      } else {
        httpResponseEntity.setCode("666");
        httpResponseEntity.setData(hasForm);
        httpResponseEntity.setMessage("查询成功");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    return httpResponseEntity;
  }

  
  @RequestMapping(value = "/queryFormListByPid", method = RequestMethod.POST,
                  headers = "Accept=application/json")
  public HttpResponseEntity queryFormListByPid(@RequestBody FormEntity formEntity) {
    System.out.println(formEntity.getProjectId());
    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    try {
      List<FormEntity> hasForm = formService.queryFormListByPid(formEntity);
      if (CollectionUtils.isEmpty(hasForm)) {
        httpResponseEntity.setCode("0");
        httpResponseEntity.setData("");
        httpResponseEntity.setMessage("查询失败");
      } else {
        httpResponseEntity.setCode("666");
        httpResponseEntity.setData(hasForm);
        httpResponseEntity.setMessage("查询成功");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    return httpResponseEntity;
  }

  // @RequestMapping(value = "/release", method = RequestMethod.GET)
  // public HttpResponseEntity
  // queryFormById(@RequestParam String id) {
  //   HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
  //   FormEntity formEntity = new FormEntity();
  //   formEntity.setId(id);
  //   try {
  //     FormEntity hasForm = formService.selectFormInfo(formEntity);
  //     if (hasForm == null) {
  //       httpResponseEntity.setCode("0");
  //       httpResponseEntity.setData("");
  //       httpResponseEntity.setMessage("查询失败");
  //     } else {
  //       httpResponseEntity.setCode("666");
  //       httpResponseEntity.setData(hasForm);
  //       httpResponseEntity.setMessage("查询成功");
  //     }
  //   } catch (Exception e) {
  //     System.out.println(e.getMessage());
  //     e.printStackTrace();
  //   }
  //   return httpResponseEntity;
  // }
}
