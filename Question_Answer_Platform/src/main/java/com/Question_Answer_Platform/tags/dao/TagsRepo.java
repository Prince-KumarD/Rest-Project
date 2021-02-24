package com.Question_Answer_Platform.tags.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Question_Answer_Platform.tags.model.Tags;

public interface TagsRepo extends JpaRepository<Tags, Integer> {

	public String getTagByTagId(Integer tagId);
	public Tags getTagByTagName(String tagName);
}
