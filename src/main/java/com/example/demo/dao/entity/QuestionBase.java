package com.example.demo.dao.entity;

public class QuestionBase {
	private String id;
	private String questionDescription;
	private String questionType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	@Override
	public String toString() {
		return "QuestionBase{" +
			"id='" + id + '\'' +
			", questionDescription='" + questionDescription + '\'' +
			", questionType='" + questionType + '\'' +
			'}';
	}
}
