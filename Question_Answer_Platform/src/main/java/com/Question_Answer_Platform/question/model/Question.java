package com.Question_Answer_Platform.question.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.lang.Nullable;

import com.Question_Answer_Platform.answer.model.Answer;
import com.Question_Answer_Platform.company.model.Company;
import com.Question_Answer_Platform.subTopics.model.SubTopics;
import com.Question_Answer_Platform.tags.model.Tags;
import com.Question_Answer_Platform.topics.model.Topics;
import com.Question_Answer_Platform.user.model.User;



@Entity
public class Question implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer questionId;
	private String questionText;
	@Column(nullable=true)
	@OneToMany(cascade = CascadeType.ALL)
	private List<Answer> answer;
	@Column(nullable=true)
	@OneToMany(cascade = CascadeType.ALL)
	private List<Company> company;
	@Nullable
	@ManyToOne(cascade = CascadeType.ALL)
	private Topics topics;
	@OneToMany(cascade = CascadeType.ALL)
	private List<SubTopics> subTopics;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	@Nullable
	@OneToMany(cascade = CascadeType.ALL)
	private List<Tags> tags;
	
	private Date date;
	
	
	public List<Tags> getTags() {
		return tags;
	}
	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public List<Answer> getAnswer() {
		return answer;
	}
	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}
	public List<Company> getCompany() {
		return company;
	}
	public void setCompany(List<Company> company) {
		this.company = company;
	}
	public Topics getTopics() {
		return topics;
	}
	public void setTopics(Topics topics) {
		this.topics = topics;
	}
	public List<SubTopics> getSubTopics() {
		return subTopics;
	}
	public void setSubTopics(List<SubTopics> subTopics) {
		this.subTopics = subTopics;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionText=" + questionText + ", answer=" + answer
				+ ", company=" + company + ", topics=" + topics + ", subTopics=" + subTopics + ", user=" + user
				+ ", tags=" + tags + ", date=" + date + "]";
	}
	
	
}