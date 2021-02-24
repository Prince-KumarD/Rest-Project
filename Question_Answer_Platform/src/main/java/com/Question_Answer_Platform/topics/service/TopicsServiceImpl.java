package com.Question_Answer_Platform.topics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Question_Answer_Platform.exception.TopicsNotFoundException;
import com.Question_Answer_Platform.topics.dao.TopicRepo;
import com.Question_Answer_Platform.topics.model.Topics;

@Service
@Transactional
public class TopicsServiceImpl implements TopicsService {
	
	@Autowired
	private TopicRepo topicRepo;

	@Override
	public Topics addTopics(Topics topics) {
		
		return topicRepo.save(topics);
	}

	@Override
	public List<Topics> findAllTopics() {
		return topicRepo.findAll();
	}

	@Override
	public Topics updateTopics(Topics topics) {
		return topicRepo.save(topics);
	}

	@Override
	public Topics findTopicsByName(String name) {
		Topics topic = null;
		topic = topicRepo.findTopicsByTopicName(name);
		if(topic==null) {
			throw new TopicsNotFoundException("Topic By Name "+name+"was not found"); 
		}
		return topic;
	}

	@Override
	public void deleteTopicsByName(String topicsName) {
		topicRepo.deleteByTopicName(topicsName);
	}

}
