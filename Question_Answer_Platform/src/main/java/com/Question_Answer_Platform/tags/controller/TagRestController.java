package com.Question_Answer_Platform.tags.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Question_Answer_Platform.tags.model.Tags;
import com.Question_Answer_Platform.tags.service.TagsService;

@RestController
@RequestMapping("/tag")
public class TagRestController {

	@Autowired
	private TagsService tagService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Tags>> getAllTags(){
		List<Tags> tags =  tagService.getAllTags();
		return new ResponseEntity<>(tags, HttpStatus.OK);
	}
	
	@GetMapping("/find/{tagId}")
	public ResponseEntity<String> getTagsByTagsId(@PathVariable("tagId") Integer tagId){
		String tagName = tagService.getTagsByTagId(tagId);
		return new ResponseEntity<>(tagName, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Tags> addTags(@RequestBody Tags tags){
		Tags newTags = tagService.saveTags(tags);
		return new ResponseEntity<>(newTags, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Tags> updateTags(@RequestBody Tags tags){
		Tags updateTags = tagService.updateTags(tags);
		return new ResponseEntity<>(updateTags, HttpStatus.OK);
	}
}
