package com.Question_Answer_Platform.request;

public class CommentsRequest {

	private Integer answerId;
	private Integer userId;
	private String commentText;
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
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	@Override
	public String toString() {
		return "CommentsRequest [answerId=" + answerId + ", userId=" + userId + ", commentText=" + commentText + "]";
	}
	
	
}
