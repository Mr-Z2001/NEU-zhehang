package com.example.demo.controller;

import com.example.demo.beans.HttpResponseEntity;
import com.example.demo.dao.entity.QuestionnaireEntity;
import com.example.demo.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class QuestionnaireController {
  @Autowired private QuestionnaireService questionnaireService;

  @RequestMapping(
      value = "/queryQuestionnaireList",
      method = RequestMethod.POST,
      headers = "Accept=application/json")
  public HttpResponseEntity queryQuestionnaireList(
      @RequestBody QuestionnaireEntity questionnaireEntity) {
    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    try {
      httpResponseEntity.setCode("666");
      httpResponseEntity.setData(questionnaireService.queryQuestionnaireList(questionnaireEntity));
      httpResponseEntity.setMessage("查询成功");
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    return httpResponseEntity;
  }

  @RequestMapping(
      value = "/addQuestionnaire",
      method = RequestMethod.POST,
      headers = "Accept=application/json")
  public HttpResponseEntity addQuestionnaire(@RequestBody QuestionnaireEntity questionnaireEntity) {
    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    try {
      int result = questionnaireService.addQuestionnaire(questionnaireEntity);
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
      value = "/deleteQuestionnaireById",
      method = RequestMethod.POST,
      headers = "Accept=application/json")
  public HttpResponseEntity deleteQuestionnaireById(
      @RequestBody QuestionnaireEntity questionnaireEntity) {
    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    try {
      int result = questionnaireService.deleteQuestionnaireById(questionnaireEntity);
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
    return httpResponseEntity;
  }

  @RequestMapping(
      value = "/updateQuestionnaireById",
      method = RequestMethod.POST,
      headers = "Accept=application/json")
  public HttpResponseEntity updateQuestionnaireById(
      @RequestBody QuestionnaireEntity questionnaireEntity) {
    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    try {
      int result = questionnaireService.modifyQuestionnaireById(questionnaireEntity);
      if (result != 0) {
        httpResponseEntity.setCode("666");
        httpResponseEntity.setData(result);
        httpResponseEntity.setMessage("更新成功");
      } else {
        httpResponseEntity.setCode("0");
        httpResponseEntity.setData("");
        httpResponseEntity.setMessage("更新失败");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    return httpResponseEntity;
  }

  @RequestMapping(
      value = "/selectQuestionnaireById",
      method = RequestMethod.POST,
      headers = "Accept=application/json")
  public HttpResponseEntity selectQuestionnaireById(
      @RequestBody QuestionnaireEntity questionnaireEntity) {
    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    try {
      httpResponseEntity.setCode("666");
      httpResponseEntity.setData(questionnaireService.selectQuestionnaireById(questionnaireEntity));
      httpResponseEntity.setMessage("查询成功");
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    return httpResponseEntity;
  }
}
