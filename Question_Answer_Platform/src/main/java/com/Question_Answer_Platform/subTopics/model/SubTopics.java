package com.Question_Answer_Platform.subTopics.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.Question_Answer_Platform.tags.model.Tags;
import com.Question_Answer_Platform.topics.model.Topics;

@Entity
public class SubTopics implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer subTopicId;
	public String subTopicText;
	@OneToMany(cascade = CascadeType.ALL)
	public List<Tags> tags;
	@ManyToOne(cascade = CascadeType.ALL)
	private Topics topics;
	
	public Integer getSubTopicId() {
		return subTopicId;
	}
	public void setSubTopicId(Integer subTopicId) {
		this.subTopicId = subTopicId;
	}
	public String getSubTopicText() {
		return subTopicText;
	}
	public void setSubTopicText(String subTopicText) {
		this.subTopicText = subTopicText;
	}
	public List<Tags> getTags() {
		return tags;
	}
	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}
	public Topics getTopics() {
		return topics;
	}
	public void setTopics(Topics topics) {
		this.topics = topics;
	}
	@Override
	public String toString() {
		return "SubTopics [subTopicId=" + subTopicId + ", subTopicText=" + subTopicText + ", tags=" + tags + ", topics="
				+ topics + "]";
	}
	
	
}
