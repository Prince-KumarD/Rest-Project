package com.Question_Answer_Platform.request;

public class QuestionLikesRequest {

	private Integer questionId;
	private Integer userId;
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "QuestionLikesRequest [questionId=" + questionId + ", userId=" + userId + "]";
	}
	
	
}
