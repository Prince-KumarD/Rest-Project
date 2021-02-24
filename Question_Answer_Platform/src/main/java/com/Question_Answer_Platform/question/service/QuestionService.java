package com.Question_Answer_Platform.question.service;


import java.util.Date;
import java.util.List;

import com.Question_Answer_Platform.question.model.Question;

public interface QuestionService {

	public Question addQuestion(Question question);
	public List<Question> findAllQuestion();
	public Question updateQuestion(Question question);
	public Question findQuestionByquestionText(String questionText);
	public void deleteQuestion(Question question);
	public Question findQuestionById(Integer questionId);
	public List<Question> findQuestionByCompanyCompanyId(Integer companyId);
	public List<Question> findQuestionByCompanyCompanyName(String companyName);
	public List<Question> findQuestionBySubTopicsSubTopicText(String subTopicText);
	public List<Question> findQuestionByTagsTagName(String tagName);
	
	public List<Question> findQuestionByQuestionDate(Date date);
}
