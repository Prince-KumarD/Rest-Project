package com.Question_Answer_Platform.question.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Question_Answer_Platform.company.model.Company;
import com.Question_Answer_Platform.company.service.CompanyService;
import com.Question_Answer_Platform.question.model.Question;
import com.Question_Answer_Platform.question.service.QuestionService;
import com.Question_Answer_Platform.questionLikes.service.QuestionLikesService;
import com.Question_Answer_Platform.request.QuestionRequest;
import com.Question_Answer_Platform.subTopics.model.SubTopics;
import com.Question_Answer_Platform.subTopics.service.SubTopicsService;
import com.Question_Answer_Platform.tags.model.Tags;
import com.Question_Answer_Platform.tags.service.TagsService;
import com.Question_Answer_Platform.user.model.User;
import com.Question_Answer_Platform.user.service.UserService;

@RestController
@RequestMapping("/question")
public class QuestionRestController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private UserService userService;

	@Autowired
	private TagsService tagsService;
	@Autowired
	private SubTopicsService subTopicsService;
	@Autowired
	private QuestionLikesService questionLikesService;
	
	@PostMapping("/addQuestion")
	public ResponseEntity<Question> addQuestion(@RequestBody QuestionRequest questionRequest){
		List<Company> company = null;
		List<Tags> tagList = null;
		List<SubTopics> subTopic = new ArrayList<SubTopics>();
		User user = null;
		if(questionRequest.getCompanyId() != 00) {
			company = new ArrayList<Company>();
			company.add(companyService.findCompanyByCompanyId(questionRequest.getCompanyId())); 
		}
		if(questionRequest.getTags()!=null) {
			for (int i = 0; i < questionRequest.getTags().size(); i++) {
				Tags tag = tagsService.getTagByTagName(questionRequest.getTags().get(i));
				tagList = new ArrayList<Tags>();
				tagList.add(tag);
			}
		}
		subTopic.add(subTopicsService.findSubTopicsBySubTopicID(questionRequest.getSubTopicId()));
		user = userService.findUserByUserId(questionRequest.getUserId());
		Question question = new Question();
		question.setQuestionText(questionRequest.getQuestionText());
		question.setDate(new Date());
		question.setUser(user);
		question.setTags(tagList);
		question.setCompany(company);
		question.setSubTopics(subTopic);
		Question saveQuestion = questionService.addQuestion(question);
		return new ResponseEntity<>(saveQuestion, HttpStatus.CREATED);
	}
	
		@GetMapping("/getFilteredQuestionByCompanyList")
		public ResponseEntity<List<Question>> getFilteredQuestionByCompanyList(
				@RequestHeader List<String> company
				){
			
			List<Question> question = new ArrayList<Question>();
			if(company == null) {
				return new ResponseEntity<>(HttpStatus.OK);
			}
			for(int i=0;i<company.size();i++) {
				question.addAll(questionService.findQuestionByCompanyCompanyName(company.get(i)));
			}
				
			return new ResponseEntity<>(question, HttpStatus.OK);
		}
	
		@GetMapping("/getFilteredQuestionBySubTopicsList")
		public ResponseEntity<List<Question>> getFilteredQuestionBySubTopicsList(
				@RequestBody List<String> subTopics
				){
			
			List<Question> question = new ArrayList<Question>();
			if(subTopics == null) {
				return new ResponseEntity<>(HttpStatus.OK);
			}
			for (int i = 0; i < subTopics.size(); i++) {
				question.addAll(questionService.findQuestionBySubTopicsSubTopicText(subTopics.get(i)));
			}
				
			return new ResponseEntity<>(question, HttpStatus.OK);
		}
		
		@GetMapping("getFilteredQuestionByLikes/{numberOfLikes}")
		public ResponseEntity<Question> getFilteredQuestionByLikes(@PathVariable("numberOfLikes")Integer likes){
			Question question = null;
				question = questionLikesService.findQuestionByQuestionLikes(likes);
			return new ResponseEntity<>(question, HttpStatus.OK);
		}
		
		@GetMapping("/getFilteredQuestionByTagsList")
		public ResponseEntity<List<Question>> getFilteredQuestionByTagsList(@RequestBody List<String> tags){
			List<Question> question = new ArrayList<Question>();
			if(tags == null) {
				return new ResponseEntity<>(HttpStatus.OK);
			}
			for(int i=0; i<tags.size();i++) {
				question.addAll(questionService.findQuestionByTagsTagName(tags.get(i)));
			}
				
			return new ResponseEntity<>(question, HttpStatus.OK);
		}
		
		@GetMapping("/getFilteredQuestionByDate/{date}")
		public ResponseEntity<List<Question>> getFilteredQuestionByDate(@PathVariable("date")Date date){
			List<Question> question = null;
			if(date == null) {
				return new ResponseEntity<>(HttpStatus.OK);
			}
				question = questionService.findQuestionByQuestionDate(date);
			return new ResponseEntity<>(question, HttpStatus.OK);
		}
		
		@GetMapping("/getQuestionByQuestionId/{questionId}")
		public ResponseEntity<Question> getQuestionByQuestionId(@PathVariable("questionId")Integer questionId){
			Question question = null;
				question = questionService.findQuestionById(questionId);
			return new ResponseEntity<>(question, HttpStatus.OK);
		}
}
