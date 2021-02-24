package com.Question_Answer_Platform.request;

public class AnswerlikesRequest {

	private Integer answerId;
	private Integer userId;
	public Integer getAnswerId() {
		return answerId;
	}
	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "AnswerlikesRequest [answerId=" + answerId + ", userId=" + userId + "]";
	}
	
	
}
