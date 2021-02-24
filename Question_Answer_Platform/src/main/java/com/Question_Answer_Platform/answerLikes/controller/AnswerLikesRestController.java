package com.Question_Answer_Platform.answerLikes.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Question_Answer_Platform.answer.model.Answer;
import com.Question_Answer_Platform.answer.service.AnswerService;
import com.Question_Answer_Platform.answerLikes.model.AnswerLikes;
import com.Question_Answer_Platform.answerLikes.service.AnswerLikesService;
import com.Question_Answer_Platform.request.AnswerlikesRequest;
import com.Question_Answer_Platform.user.model.User;
import com.Question_Answer_Platform.user.service.UserService;

@RestController
@RequestMapping("/answerLikes")
public class AnswerLikesRestController {

	@Autowired
	private AnswerLikesService answerLikesService;
	
	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/add")
	public ResponseEntity<AnswerLikes> addAnswerLikes(@RequestBody AnswerlikesRequest answerLikesRequest ){
		Answer answer = answerService.fetchAnswerByAnswerId(answerLikesRequest.getAnswerId());
		User user = userService.findUserByUserId(answerLikesRequest.getUserId());
		AnswerLikes answerLikes = new AnswerLikes();
		answerLikes.setAnswer(answer);
		answerLikes.setUser(user);
		answerLikes.setDate(new Date());
		AnswerLikes newAnswerLikes =  answerLikesService.saveAnswerLikes(answerLikes);
		return new ResponseEntity<>(newAnswerLikes, HttpStatus.CREATED);
	}
	

	
	@DeleteMapping("/deleteAnswerLikes/{answerId}/{userId}")
	public ResponseEntity<?> deleteAnswerLikes(@PathVariable("answerId") Integer answerId,@PathVariable("userId") Integer userId){
		Answer answer = answerService.fetchAnswerByAnswerId(answerId);
		User user = userService.findUserByUserId(userId);
		AnswerLikes answerLikes = new AnswerLikes();
		answerLikes.setAnswer(answer);
		answerLikes.setUser(user);
		answerLikesService.deleteAnswerLikes(answerLikes);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/all/{answerId}")
	public ResponseEntity<Integer> getAllAnswerLikes(@PathVariable("answerId") Integer answerId){
		
		return new ResponseEntity<>(answerLikesService.getAllAnswerLikes(answerId).size(), HttpStatus.OK);
	}
}
