package com.example.demo.dao.entity;

import java.util.Date;

public class AnsEntity {
  String id;
  String projectId;
  String formId;
  String ansContent;
  String createdBy;
  Date creationDate;

  public String getId() { return id; }

  public void setId(String id) { this.id = id; }

  public String getProjectId() { return projectId; }

  public void setProjectId(String projectId) { this.projectId = projectId; }

  public String getFormId() { return formId; }

  public void setFormId(String formId) { this.formId = formId; }

  public String getAnsContent() { return ansContent; }

  public void setAnsContent(String ansContent) { this.ansContent = ansContent; }

  public String getCreatedBy() { return createdBy; }

  public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

  public Date getCreationDate() { return creationDate; }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  @Override
  public String toString() {
    return "AnsEntity [id=" + id + ", projectId=" + projectId +
        ", formId=" + formId + ", ansContent=" + ansContent +
        ", createdBy=" + createdBy + ", creationDate=" + creationDate + "]";
  }
}
