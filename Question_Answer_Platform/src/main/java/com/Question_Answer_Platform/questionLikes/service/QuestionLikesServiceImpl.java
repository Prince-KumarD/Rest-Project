package com.Question_Answer_Platform.questionLikes.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Question_Answer_Platform.question.model.Question;
import com.Question_Answer_Platform.questionLikes.dao.QuestionLikesRepo;
import com.Question_Answer_Platform.questionLikes.model.QuestionLikes;

@Service
@Transactional
public class QuestionLikesServiceImpl implements QuestionLikesService {

	@Autowired
	private QuestionLikesRepo questionLikesRepo;
	
	@Override
	public QuestionLikes saveQuestionLikes(QuestionLikes questionLikes) {
		return questionLikesRepo.save(questionLikes);
	}

	@Override
	public QuestionLikes updateQuestionLikes(QuestionLikes questionLikes) {
		return questionLikesRepo.save(questionLikes);
	}

	@Override
	public void deleteQuestionLikes(QuestionLikes questionLikes) {
		questionLikesRepo.delete(questionLikes);
		
	}

	@Override
	public int getAllQuestionLikes() {
		return questionLikesRepo.findAll().size();
	}

	@Override
	public Question findQuestionByQuestionLikes(Integer questionLikes) {
//		return questionLikesRepo.findQuestionByQuestionLikes(questionLikes);
		return null;
	}
	
	@Override
	public List<QuestionLikes> getAllQuestionLikes(Integer questionId) {
		
		return questionLikesRepo.findQuestionLikesByQuestionQuestionId(questionId);
	}
	
	

}
