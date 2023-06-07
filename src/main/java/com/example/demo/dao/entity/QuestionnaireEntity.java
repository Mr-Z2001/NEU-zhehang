package com.example.demo.dao.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class QuestionnaireEntity implements Serializable
{
	private int id;
	private String questionnaireName;
	private String questionnaireType;
	private String questionnaireDescription;
	private String createdBy;
	private String belongToProject;
	private Date creationDate;
	private Date startDate;
	private Date endDate;
	private List<QuestionBase> content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestionnaireName() {
		return questionnaireName;
	}

	public void setQuestionnaireName(String questionnaireName) {
		this.questionnaireName = questionnaireName;
	}

	public String getQuestionnaireType() {
		return questionnaireType;
	}

	public void setQuestionnaireType(String questionnaireType) {
		this.questionnaireType = questionnaireType;
	}

	public String getQuestionnaireDescription() {
		return questionnaireDescription;
	}

	public void setQuestionnaireDescription(String questionnaireDescription) {
		this.questionnaireDescription = questionnaireDescription;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<QuestionBase> getContent() {
		return content;
	}

	public void setContent(List<QuestionBase> content) {
		this.content = content;
	}

	public String getBelongToProject() {
		return belongToProject;
	}

	public void setBelongToProject(String belongToProject) {
		this.belongToProject = belongToProject;
	}

	@Override
	public String toString() {
		return "QuestionnaireEntity{" +
			"id='" + id + '\'' +
			", questionnaireName='" + questionnaireName + '\'' +
			", questionnaireType='" + questionnaireType + '\'' +
			", questionnaireDescription='" + questionnaireDescription + '\'' +
			", createdBy='" + createdBy + '\'' +
			", belongToProject='" + belongToProject + '\'' +
			", creationDate=" + creationDate +
			", startDate=" + startDate +
			", endDate=" + endDate +
			", content=" + content +
			'}';
	}
}
