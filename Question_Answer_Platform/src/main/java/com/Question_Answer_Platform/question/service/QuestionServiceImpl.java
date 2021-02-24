package com.Question_Answer_Platform.question.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Question_Answer_Platform.exception.QuestionNotFoundException;
import com.Question_Answer_Platform.question.dao.QuestionRepo;
import com.Question_Answer_Platform.question.model.Question;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepo questionRepo;
	
	@Override
	public Question addQuestion(Question question) {
		
		return questionRepo.save(question);
	}

	@Override
	public List<Question> findAllQuestion() {
		return questionRepo.findAll();
	}

	@Override
	public Question updateQuestion(Question question) {
		
		return questionRepo.save(question);
	}

	@Override
	public Question findQuestionByquestionText(String questionText) {
		Question question = null;
		question = questionRepo.findQuestionByquestionText(questionText);
		if(question==null) {
			throw new QuestionNotFoundException("Company By Name "+questionText+"was not found"); 
		}
		return question;
	}

	@Override
	public void deleteQuestion(Question question) {
		questionRepo.delete(question);
		
	}

	@Override
	public Question findQuestionById(Integer questionId) {
		return questionRepo.findQuestionByQuestionId(questionId);
	}

	@Override
	public List<Question> findQuestionByCompanyCompanyId(Integer companyId) {
		
		return questionRepo.findQuestionByCompanyCompanyId(companyId);
	}

	@Override
	public List<Question> findQuestionByCompanyCompanyName(String companyName) {
		
		return questionRepo.findQuestionByCompanyCompanyName(companyName);
	}

	@Override
	public List<Question> findQuestionBySubTopicsSubTopicText(String subTopicText) {
		return questionRepo.findQuestionBySubTopicsSubTopicText(subTopicText);
	}

	@Override
	public List<Question> findQuestionByTagsTagName(String tagName) {
		
		return questionRepo.findQuestionByTagsTagName(tagName);
	}



	@Override
	public List<Question> findQuestionByQuestionDate(Date date) {
		return questionRepo.findQuestionByDate(date);
	}

	
}
