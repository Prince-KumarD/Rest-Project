package com.Question_Answer_Platform.comments.controller;

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

import com.Question_Answer_Platform.answer.model.Answer;
import com.Question_Answer_Platform.answer.service.AnswerService;
import com.Question_Answer_Platform.comments.model.Comments;
import com.Question_Answer_Platform.comments.service.CommentsService;
import com.Question_Answer_Platform.request.CommentsRequest;
import com.Question_Answer_Platform.user.model.User;
import com.Question_Answer_Platform.user.service.UserService;

@RestController
@RequestMapping("/comments")
public class CommentsRestController {

	@Autowired
	private CommentsService commentsService;
	
	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addComments")
	public ResponseEntity<Comments> addComments(@RequestBody CommentsRequest commentsRequest){
		Answer answer = answerService.fetchAnswerByAnswerId(commentsRequest.getAnswerId());
		User user = userService.findUserByUserId(commentsRequest.getUserId());
		Comments comments = new Comments();
		comments.setCommentText(commentsRequest.getCommentText());
		comments.setAnswer(answer);
		comments.setUser(user);
		Comments newComments = commentsService.addComments(comments);
		return new ResponseEntity<>(newComments,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateComments")
	public ResponseEntity<Comments> updateComments(@RequestBody Comments comments){
		Comments newComments = commentsService.addComments(comments);
		return new ResponseEntity<>(newComments,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteComments/{commentsId}")
	public ResponseEntity<?> deleteComments(@PathVariable("commentsId") Integer commentsId){
		commentsService.deleteCommentsByCommentId(commentsId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUserComments/{userId}/{commentsId}")
	public ResponseEntity<?> deleteCommentsByUserId(@PathVariable("userId") Integer userId,@PathVariable("commentsId") Integer commentsId){
		commentsService.deleteCommentsByUserIdAndCommentId(userId, commentsId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/getCommentsByAnswerId/{answerId}")
	public ResponseEntity<List<Comments>> getAllCommentsByAnswerId(@PathVariable("answerId") Integer answerId){
		List<Comments> comments = commentsService.findCommentsByAnswerId(answerId);
		return new ResponseEntity<>(comments, HttpStatus.OK);
	}
	
	@GetMapping("/getCommentsByUserId/{userId}")
	public ResponseEntity<List<Comments>> getAllCommentsByUserId(@PathVariable("userId") Integer userId){
		List<Comments> comments = commentsService.findCommentsByUserId(userId);
		return new ResponseEntity<>(comments, HttpStatus.OK);
	}
}
