package com.Question_Answer_Platform.subTopics.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Question_Answer_Platform.subTopics.model.SubTopics;

public interface SubTopicsRepo extends JpaRepository<SubTopics, Integer> {

	public List<SubTopics> findSubTopicsByTopicsTopicID(Integer topicID);
	public List<SubTopics> findSubTopicsByTopicsTopicName(String topicName);
	public List<SubTopics> findSubTopicsByTagsTagId(Integer tagId);
	public List<SubTopics> findSubTopicByTagsTagName(String tagName);
	public SubTopics findSubTopicsBySubTopicId(Integer subTopicID);
}
