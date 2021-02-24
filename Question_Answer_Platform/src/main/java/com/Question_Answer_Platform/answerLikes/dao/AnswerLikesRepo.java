package com.Question_Answer_Platform.answerLikes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Question_Answer_Platform.answer.model.Answer;
import com.Question_Answer_Platform.answerLikes.model.AnswerLikes;

public interface AnswerLikesRepo extends JpaRepository<AnswerLikes, Integer> {

	public Answer findAnswerTextByAnswerAnswerId(Integer answerId);
	public List<AnswerLikes> findAnswerLikesByAnswerAnswerId(Integer answerId); 
}
