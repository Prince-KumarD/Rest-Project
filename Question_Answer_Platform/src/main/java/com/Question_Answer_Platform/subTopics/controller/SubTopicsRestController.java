package com.Question_Answer_Platform.subTopics.controller;

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

import com.Question_Answer_Platform.subTopics.model.SubTopics;
import com.Question_Answer_Platform.subTopics.service.SubTopicsService;

@RestController
@RequestMapping("/subTopics")
public class SubTopicsRestController {

	@Autowired
	private SubTopicsService subTopicsService;
	
	@GetMapping("/all")
	public ResponseEntity<List<SubTopics>> getAllSubTopics(){
		List<SubTopics> subTopics =  subTopicsService.findSubTopics();
		return new ResponseEntity<>(subTopics, HttpStatus.OK);
	}
	
	@GetMapping("/findSubTopicsByTopicID/{topicId}")
	public ResponseEntity<List<SubTopics>> getSubTopicsByTopicID(@PathVariable("topicId")Integer topicID){
		List<SubTopics> subTopicList = subTopicsService.findSubTopicsByTopicID(topicID);
		return new ResponseEntity<>(subTopicList, HttpStatus.OK);
	}
	
	@GetMapping("/findSubTopicsByTagId/{tagId}")
	public ResponseEntity<List<SubTopics>> getSubTopicsByTagId(@PathVariable("tagId")Integer tagId){
		List<SubTopics> subTopicList = subTopicsService.findSubTopicsByTagId(tagId);
		return new ResponseEntity<>(subTopicList, HttpStatus.OK);
	}
	
	@GetMapping("/findSubTopicsByTopicName/{topicName}")
	public ResponseEntity<List<SubTopics>> getSubTopicsByTopicName(@PathVariable("topicId")String topicName){
		List<SubTopics> subTopicList = subTopicsService.findSubTopicsByTopicName(topicName);
		return new ResponseEntity<>(subTopicList, HttpStatus.OK);
	}
	
	@GetMapping("/findSubTopicsByTagName/{tagName}")
	public ResponseEntity<List<SubTopics>> getSubTopicsByTagName(@PathVariable("tagName")String tagName){
		List<SubTopics> subTopicList = subTopicsService.findSubTopicByTagName(tagName);
		return new ResponseEntity<>(subTopicList, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<SubTopics> addSubTopics(@RequestBody SubTopics subTopics){
		SubTopics subTopic = subTopicsService.saveSubTopics(subTopics);
		return new ResponseEntity<>(subTopic, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<SubTopics> updateSubTopics(@RequestBody SubTopics subTopics){
		SubTopics subTopic = subTopicsService.updateSubTopics(subTopics);
		return new ResponseEntity<>(subTopic, HttpStatus.OK);
	}
}
