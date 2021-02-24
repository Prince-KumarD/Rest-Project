package com.Question_Answer_Platform.answer.model;

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
public class Answer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer answerId;
	private String answerText;
	@ManyToOne(cascade = CascadeType.ALL)
	private Question question;
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;

	public Integer getAnswerId() {
		return answerId;
	}
	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}
	public String getAnswerText() {
		return answerText;
	}
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
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
		return "Answer [answerId=" + answerId + ", answerText=" + answerText + ", question=" + question + ", user="
				+ user + "]";
	}	
	
	
}
