package com.Question_Answer_Platform.topics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Question_Answer_Platform.topics.model.Topics;
import com.Question_Answer_Platform.topics.service.TopicsService;

@RestController
@RequestMapping("/topics")
public class TopicsRestController {

	@Autowired
	private TopicsService topicsService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Topics>> getAllTopics(){
		List<Topics> topics =  topicsService.findAllTopics();
		return new ResponseEntity<>(topics, HttpStatus.OK);
	}
	
	@GetMapping("/find/{name}")
	public ResponseEntity<Topics> getTopicsByName(@PathVariable("name") String name){
		Topics topics = topicsService.findTopicsByName(name);
		return new ResponseEntity<>(topics, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Topics> addTopics(@RequestBody Topics topics){
		Topics newTopics = topicsService.addTopics(topics);
		return new ResponseEntity<>(newTopics, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Topics> updateTopics(@RequestBody Topics topics){
		Topics updateTopics = topicsService.updateTopics(topics);
		return new ResponseEntity<>(updateTopics, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{name}")
	public ResponseEntity<?> deleteTopics(@PathVariable("name") String name){
		System.out.println("Hii");
		topicsService.deleteTopicsByName(name);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
