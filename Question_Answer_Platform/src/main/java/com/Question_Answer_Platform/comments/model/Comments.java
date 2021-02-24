package com.Question_Answer_Platform.comments.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.Question_Answer_Platform.answer.model.Answer;
import com.Question_Answer_Platform.user.model.User;

@Entity
public class Comments implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer commentId;
	private String commentText;
	@ManyToOne(cascade = CascadeType.ALL)
	private Answer answer;
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public Answer getAnswer() {
		return answer;
	}
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Comments [commentId=" + commentId + ", commentText=" + commentText + ", answer=" + answer + ", user="
				+ user + "]";
	}
	
	
}
