package com.Question_Answer_Platform.questionLikes.controller;


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

import com.Question_Answer_Platform.question.model.Question;
import com.Question_Answer_Platform.question.service.QuestionService;
import com.Question_Answer_Platform.questionLikes.model.QuestionLikes;
import com.Question_Answer_Platform.questionLikes.service.QuestionLikesService;
import com.Question_Answer_Platform.request.QuestionLikesRequest;
import com.Question_Answer_Platform.user.model.User;
import com.Question_Answer_Platform.user.service.UserService;

@RestController
@RequestMapping("/questionLikes")
public class QuestionLikesRestController {

	@Autowired
	private QuestionLikesService questionLikesService;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addQuestionLikes")
	public ResponseEntity<QuestionLikes> addQuestionLikes(@RequestBody QuestionLikesRequest questionlikesRequest ){
		Question question = questionService.findQuestionById(questionlikesRequest.getQuestionId());
		User user = userService.findUserByUserId(questionlikesRequest.getUserId());
		QuestionLikes questionLikes = new QuestionLikes();
		questionLikes.setQuestion(question);
		question.setUser(user);
		QuestionLikes newQuestionLikes =  questionLikesService.saveQuestionLikes(questionLikes);
		return new ResponseEntity<>(newQuestionLikes, HttpStatus.CREATED);
	}
	

	
	@DeleteMapping("/deleteQuestionLikes/{questionId}/{userId}")
	public ResponseEntity<?> deleteQuestionLikes(@PathVariable("questionId") Integer questionId,@PathVariable("userId") Integer userId){
		Question question = questionService.findQuestionById(questionId);
		User user = userService.findUserByUserId(userId);
		QuestionLikes questionLikes = new QuestionLikes();
		questionLikes.setQuestion(question);
		questionLikes.setUser(user);
		questionLikesService.deleteQuestionLikes(questionLikes);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/all/{questionId}")
	public ResponseEntity<Integer> getAllQuestionLikes(@PathVariable("questionId") Integer questionId){
		
		return new ResponseEntity<>(questionLikesService.getAllQuestionLikes(questionId).size(), HttpStatus.OK);
	}
}
