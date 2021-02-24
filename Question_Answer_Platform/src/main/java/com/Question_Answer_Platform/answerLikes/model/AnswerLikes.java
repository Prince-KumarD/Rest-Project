package com.Question_Answer_Platform.answerLikes.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.Question_Answer_Platform.answer.model.Answer;
import com.Question_Answer_Platform.user.model.User;

@Entity
public class AnswerLikes implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer likeId;
	@ManyToOne(cascade = CascadeType.ALL )
	public Answer answer;
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	private Date date;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getLikeId() {
		return likeId;
	}
	public void setLikeId(Integer likeId) {
		this.likeId = likeId;
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
		return "AnswerLikes [likeId=" + likeId + ", answer=" + answer + ", user=" + user + ", date=" + date + "]";
	}
	
	
}
