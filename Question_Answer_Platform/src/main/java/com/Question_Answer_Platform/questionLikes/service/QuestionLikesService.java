package com.Question_Answer_Platform.questionLikes.service;

import java.util.List;

import com.Question_Answer_Platform.question.model.Question;
import com.Question_Answer_Platform.questionLikes.model.QuestionLikes;

public interface QuestionLikesService {
	
	public QuestionLikes saveQuestionLikes(QuestionLikes questionLikes);
	public QuestionLikes updateQuestionLikes(QuestionLikes questionLikes);
	public void deleteQuestionLikes(QuestionLikes questionLikes);
	public int getAllQuestionLikes();
	public List<QuestionLikes> getAllQuestionLikes(Integer questionId);
	public Question findQuestionByQuestionLikes(Integer questionLikes);
}
