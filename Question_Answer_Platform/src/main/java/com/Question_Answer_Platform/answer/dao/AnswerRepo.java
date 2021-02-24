package com.Question_Answer_Platform.answer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Question_Answer_Platform.answer.model.Answer;
import com.Question_Answer_Platform.question.model.Question;
import com.Question_Answer_Platform.user.model.User;


public interface AnswerRepo extends JpaRepository<Answer, Integer> {

//	public List<Answer> findAllAnswerByUserName(String name);
//	public void deleteAnswerByUserName(String name);
	public void deleteAnswerByQuestion(String questionText);
	public List<Answer> findAllAnswerByQuestion(Question question);
	public Answer findAnswerByAnswerId(Integer answerId);
	public List<Answer> findAllAnswerByUser(User user);
	
}
