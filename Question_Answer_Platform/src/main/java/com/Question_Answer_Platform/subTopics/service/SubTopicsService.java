package com.Question_Answer_Platform.subTopics.service;

import java.util.List;
import java.util.Optional;

import com.Question_Answer_Platform.subTopics.model.SubTopics;

public interface SubTopicsService {

	public SubTopics saveSubTopics(SubTopics subTopics);
	public SubTopics updateSubTopics(SubTopics subTopics);
	public List<SubTopics> findSubTopics();
	public List<SubTopics> findSubTopicsByTopicID(Integer topicID);
	public List<SubTopics> findSubTopicsByTopicName(String topicName);
	public List<SubTopics> findSubTopicsByTagId(Integer tagId);
	public List<SubTopics> findSubTopicByTagName(String tagName);
	public SubTopics findSubTopicsBySubTopicID(Integer subTopicID);
}
