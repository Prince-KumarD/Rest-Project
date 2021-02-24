package com.Question_Answer_Platform.subTopics.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Question_Answer_Platform.subTopics.dao.SubTopicsRepo;
import com.Question_Answer_Platform.subTopics.model.SubTopics;

@Service
@Transactional
public class SubTopicsServiceImpl implements SubTopicsService {

	@Autowired
	private SubTopicsRepo subTopicsRepo;
	
	@Override
	public SubTopics saveSubTopics(SubTopics subTopics) {
		return subTopicsRepo.save(subTopics);
	}

	@Override
	public SubTopics updateSubTopics(SubTopics subTopics) {
		return subTopicsRepo.save(subTopics);
	}

	@Override
	public List<SubTopics> findSubTopics() {
		return subTopicsRepo.findAll();
	}

	@Override
	public List<SubTopics> findSubTopicsByTopicID(Integer topicID) {
		return subTopicsRepo.findSubTopicsByTopicsTopicID(topicID);
	}
	
	@Override
	public SubTopics findSubTopicsBySubTopicID(Integer subTopicID) {
		return subTopicsRepo.findSubTopicsBySubTopicId(subTopicID);
	}

	@Override
	public List<SubTopics> findSubTopicsByTopicName(String topicName) {
		return subTopicsRepo.findSubTopicsByTopicsTopicName(topicName);
	}

	@Override
	public List<SubTopics> findSubTopicsByTagId(Integer tagId) {
		return subTopicsRepo.findSubTopicsByTagsTagId(tagId);
	}

	@Override
	public List<SubTopics> findSubTopicByTagName(String tagName) {
		return subTopicsRepo.findSubTopicByTagsTagName(tagName);
	}

}
