package com.Question_Answer_Platform.request;

public class AnswerRequest {

	private Integer questionId;
	private String answerText;
	private Integer userId;
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public String getAnswerText() {
		return answerText;
	}
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "AnswerRequest [questionId=" + questionId + ", answerText=" + answerText + ", userId=" + userId + "]";
	}
	
}
