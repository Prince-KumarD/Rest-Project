package com.Question_Answer_Platform.topics.service;

import java.util.List;

import com.Question_Answer_Platform.topics.model.Topics;


public interface TopicsService {


	public Topics addTopics(Topics topics);
	public List<Topics> findAllTopics();
	public Topics updateTopics(Topics topics);
	public Topics findTopicsByName(String Name);
	public void deleteTopicsByName(String topicsName);
}
