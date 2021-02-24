package com.Question_Answer_Platform.request;

import java.util.List;

import com.Question_Answer_Platform.tags.model.Tags;

public class QuestionRequest {

	private String questionText;
	private Integer companyId;
	private Integer subTopicId;
	private List<String> tags;
	private Integer userId;
	
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public Integer getSubTopicId() {
		return subTopicId;
	}
	public void setSubTopicId(Integer subTopicId) {
		this.subTopicId = subTopicId;
	}
	public Integer getUserId() {
		return userId;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "QuestionRequest [questionText=" + questionText + ", companyId=" + companyId + ", subTopicId="
				+ subTopicId + ", tags=" + tags + ", userId=" + userId + "]";
	}
	
	
}
