package com.Question_Answer_Platform.tags.service;

import java.util.List;

import com.Question_Answer_Platform.tags.model.Tags;

public interface TagsService {

	public Tags saveTags(Tags tags);
	public List<Tags> getAllTags();
	public Tags updateTags(Tags tags);
	public String getTagsByTagId(Integer tagId);
	public Tags getTagByTagName(String tagName);
}
