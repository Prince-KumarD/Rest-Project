package com.Question_Answer_Platform.answer.service;

import java.util.List;

import com.Question_Answer_Platform.answer.model.Answer;
import com.Question_Answer_Platform.question.model.Question;
import com.Question_Answer_Platform.user.model.User;

public interface AnswerService {
	
	public Answer addAnswer(Answer answer);
	public List<Answer> findAllAnswer();
	public Answer updateAnswer(Answer answer);
	public void deleteAnswer(Answer answer);
	public List<Answer> findAllAnswerByQuestion(Question question);
	public void deleteAnswerByQuestion(String questionText);
	public Answer fetchAnswerByAnswerId(Integer answerId);
	public List<Answer> findAllAnswerByUser(User user);
}
