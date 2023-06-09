package com.example.demo.dao.entity;

import java.util.Date;

public class FormEntity {
  private String id;
  private String projectId;
  private String formName;
  private String formType;
  private String formInfo;
  private Date startTime;
  private Date endTime;
  private String createdBy;
  private Date creationDate;
  private String lastUpdatedBy;
  private Date lastUpdateDate;
  private String formContent;

  public String getId() { return id; }

  public void setId(String id) { this.id = id; }

  public String getProjectId() { return projectId; }

  public void setProjectId(String projectId) { this.projectId = projectId; }

  public String getFormName() { return formName; }

  public void setFormName(String formName) { this.formName = formName; }

  public String getFormType() { return formType; }

  public void setFormType(String formType) { this.formType = formType; }

  public String getFormInfo() { return formInfo; }

  public void setFormInfo(String formInfo) { this.formInfo = formInfo; }

  public Date getStartTime() { return startTime; }

  public void setStartTime(Date startTime) { this.startTime = startTime; }

  public Date getEndTime() { return endTime; }

  public void setEndTime(Date endTime) { this.endTime = endTime; }

  public String getCreatedBy() { return createdBy; }

  public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

  public Date getCreationDate() { return creationDate; }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public String getLastUpdatedBy() { return lastUpdatedBy; }

  public void setLastUpdatedBy(String lastUpdatedBy) {
    this.lastUpdatedBy = lastUpdatedBy;
  }

  public Date getLastUpdateDate() { return lastUpdateDate; }

  public void setLastUpdateDate(Date lastUpdateDate) {
    this.lastUpdateDate = lastUpdateDate;
  }

  public String getFormContent() { return formContent; }

  public void setFormContent(String formContent) {
    this.formContent = formContent;
  }

  @Override
  public String toString() {
    return "FormEntity [id=" + id + ", projectId=" + projectId +
        ", formName=" + formName + ", formType=" + formType +
        ", formInfo=" + formInfo + ", startTime=" + startTime +
        ", endTime=" + endTime + ", createdBy=" + createdBy +
        ", creationDate=" + creationDate + ", lastUpdatedBy=" + lastUpdatedBy +
        ", lastUpdateDate=" + lastUpdateDate + ", formContent=" + formContent +
        "]";
  }
}
