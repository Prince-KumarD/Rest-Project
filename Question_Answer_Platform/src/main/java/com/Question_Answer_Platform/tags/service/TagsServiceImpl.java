package com.Question_Answer_Platform.tags.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Question_Answer_Platform.tags.dao.TagsRepo;
import com.Question_Answer_Platform.tags.model.Tags;

@Service
@Transactional
public class TagsServiceImpl implements TagsService {
	
	@Autowired
	private TagsRepo tagRepo;

	@Override
	public Tags saveTags(Tags tags) {
		return tagRepo.save(tags);
	}

	@Override
	public List<Tags> getAllTags() {
		return tagRepo.findAll();
	}

	@Override
	public Tags updateTags(Tags tags) {
		return tagRepo.save(tags);
	}

	@Override
	public String getTagsByTagId(Integer tagId) {
		return tagRepo.getTagByTagId(tagId);
	}

	

	@Override
	public Tags getTagByTagName(String tagName) {
		return tagRepo.getTagByTagName(tagName);
	}

	
}
