package com.Question_Answer_Platform.answer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Question_Answer_Platform.answer.dao.AnswerRepo;
import com.Question_Answer_Platform.answer.model.Answer;
import com.Question_Answer_Platform.exception.AnswerNotFoundException;
import com.Question_Answer_Platform.question.model.Question;
import com.Question_Answer_Platform.user.model.User;

@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {
	
	@Autowired
	private AnswerRepo answerRepo;

	@Override
	public Answer addAnswer(Answer answer) {
		return answerRepo.save(answer);
	}

	@Override
	public List<Answer> findAllAnswer() {
		return answerRepo.findAll();
	}

	@Override
	public Answer updateAnswer(Answer answer) {
		return answerRepo.save(answer);
	}

//	@Override
//	public List<Answer> findAllAnswerByUserName(String name) {
//		List<Answer> newAnswer = null;
//		newAnswer = answerRepo.findAllAnswerByUserName(name);
//		if(newAnswer==null) {
//			throw new AnswerNotFoundException("Answer not found");
//		}
//		return newAnswer; 
//	}

//	@Override
//	public void deleteAnswerByUserName(String name) {
//
//		answerRepo.deleteAnswerByUserName(name);
//	}

	@Override
	public void deleteAnswer(Answer answer) {

		answerRepo.delete(answer);
	}

	@Override
	public List<Answer> findAllAnswerByQuestion(Question question) {
		List<Answer> newAnswer = null;
		newAnswer = answerRepo.findAllAnswerByQuestion(question);
		if(newAnswer==null) {
			throw new AnswerNotFoundException("Answer not found");
		}
		return newAnswer;
	}

	@Override
	public void deleteAnswerByQuestion(String questionText) {
		answerRepo.deleteAnswerByQuestion(questionText);
	}



	@Override
	public Answer fetchAnswerByAnswerId(Integer answerId) {
		return answerRepo.findAnswerByAnswerId(answerId);
	}

	@Override
	public List<Answer> findAllAnswerByUser(User user) {
		return answerRepo.findAllAnswerByUser(user);
	}

}
