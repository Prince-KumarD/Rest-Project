package com.Question_Answer_Platform.questionLikes.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.Question_Answer_Platform.question.model.Question;
import com.Question_Answer_Platform.user.model.User;

@Entity
public class QuestionLikes implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer likeId;
	@ManyToOne(cascade = CascadeType.ALL)
	public Question question;
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	public Integer getLikeId() {
		return likeId;
	}
	public void setLikeId(Integer likeId) {
		this.likeId = likeId;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "QuestionLikes [likeId=" + likeId + ", question=" + question + ", user=" + user + "]";
	}
	
	
}
