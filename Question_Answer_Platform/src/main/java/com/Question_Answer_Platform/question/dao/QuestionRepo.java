package com.Question_Answer_Platform.question.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Question_Answer_Platform.question.model.Question;

public interface QuestionRepo extends JpaRepository<Question, Integer> {
	
	public Question findQuestionByquestionText(String questionText);

	public Question findQuestionByQuestionId(Integer questionId);
	public List<Question> findQuestionByCompanyCompanyId(Integer companyId);
	public List<Question> findQuestionByCompanyCompanyName(String companyName);
	public List<Question> findQuestionBySubTopicsSubTopicText(String subTopicText);
	
	public List<Question> findQuestionByDate(Date date);
	public List<Question> findQuestionByTagsTagName(String tagName);

}
