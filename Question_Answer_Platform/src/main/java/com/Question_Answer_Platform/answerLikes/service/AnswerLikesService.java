package com.Question_Answer_Platform.answerLikes.service;


import java.util.List;

import com.Question_Answer_Platform.answer.model.Answer;
import com.Question_Answer_Platform.answerLikes.model.AnswerLikes;

public interface AnswerLikesService {
	
	public AnswerLikes saveAnswerLikes(AnswerLikes answerLikes);
	public void deleteAnswerLikes(AnswerLikes answerLikes);
	public List<AnswerLikes> getAllAnswerLikes(Integer answerId);
	public Answer fetchAnswerByAnswerId(Integer answerId);
}
