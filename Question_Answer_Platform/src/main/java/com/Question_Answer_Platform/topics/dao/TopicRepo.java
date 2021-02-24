package com.Question_Answer_Platform.topics.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Question_Answer_Platform.topics.model.Topics;

public interface TopicRepo extends JpaRepository<Topics, Integer> {
	
	public Topics findTopicsByTopicName(String Name);
	public void deleteByTopicName(String topicName);


}
