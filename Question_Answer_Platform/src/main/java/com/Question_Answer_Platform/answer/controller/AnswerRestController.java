package com.Question_Answer_Platform.answer.controller;

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

import com.Question_Answer_Platform.answer.model.Answer;
import com.Question_Answer_Platform.answer.service.AnswerService;
import com.Question_Answer_Platform.question.model.Question;
import com.Question_Answer_Platform.question.service.QuestionService;
import com.Question_Answer_Platform.request.AnswerRequest;
import com.Question_Answer_Platform.user.model.User;
import com.Question_Answer_Platform.user.service.UserService;

@RestController
@RequestMapping("/answer")
public class AnswerRestController {

	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addAnswer")
	public ResponseEntity<Answer> addAnswer(@RequestBody AnswerRequest answerRequest){
		Question question = questionService.findQuestionById(answerRequest.getQuestionId());
		User user = userService.findUserByUserId(answerRequest.getUserId());
		Answer answer = new Answer();
		answer.setAnswerText(answerRequest.getAnswerText());
		answer.setQuestion(question);
		answer.setUser(user);
		Answer newAnswer = answerService.addAnswer(answer);
		return new ResponseEntity<>(newAnswer, HttpStatus.CREATED);
	}

	@GetMapping("/getAllAnswerByQuestionId/{questionId}")
	public ResponseEntity<List<Answer>> getAllAnswerByQuestionId(@PathVariable("questionId") Integer questionId){
		Question question = questionService.findQuestionById(questionId);
		List<Answer> answer = answerService.findAllAnswerByQuestion(question);
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}
	
	@GetMapping("/getAllAnswerByUserId/{userId}")
	public ResponseEntity<List<Answer>> getAllAnswerByUserId(@PathVariable("userId") Integer userId){
		User user = userService.findUserByUserId(userId);
		List<Answer> answer = answerService.findAllAnswerByUser(user);
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}
	
	@PutMapping("/updateAnswer")
	public ResponseEntity<Answer> updateAnswer(@RequestBody Answer answer){
		return new ResponseEntity<>(answerService.updateAnswer(answer), HttpStatus.OK);
	}
}
