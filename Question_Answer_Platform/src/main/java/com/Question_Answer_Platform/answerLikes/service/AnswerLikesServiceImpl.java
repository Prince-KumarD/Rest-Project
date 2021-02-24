package com.Question_Answer_Platform.answerLikes.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Question_Answer_Platform.answer.model.Answer;
import com.Question_Answer_Platform.answerLikes.dao.AnswerLikesRepo;
import com.Question_Answer_Platform.answerLikes.model.AnswerLikes;

@Service
@Transactional
public class AnswerLikesServiceImpl implements AnswerLikesService {

	@Autowired
	private AnswerLikesRepo answerLikesRepo;
	
	
	@Override
	public AnswerLikes saveAnswerLikes(AnswerLikes answerLikes) {
		return answerLikesRepo.save(answerLikes);
	}

	@Override
	public void deleteAnswerLikes(AnswerLikes answerLikes) {
		 answerLikesRepo.delete(answerLikes);
	}

	@Override
	public List<AnswerLikes> getAllAnswerLikes(Integer answerId) {

		return answerLikesRepo.findAnswerLikesByAnswerAnswerId(answerId);
	}

	@Override
	public Answer fetchAnswerByAnswerId(Integer answerId) {
		System.out.println(answerLikesRepo.findAnswerTextByAnswerAnswerId(answerId));
		return answerLikesRepo.findAnswerTextByAnswerAnswerId(answerId);
	}

	
}
