package com.Question_Answer_Platform.questionLikes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Question_Answer_Platform.question.model.Question;
import com.Question_Answer_Platform.questionLikes.model.QuestionLikes;

public interface QuestionLikesRepo extends JpaRepository<QuestionLikes, Integer> {

	public Question findQuestionTextByQuestionQuestionId(Integer questionId);
	public List<QuestionLikes> findQuestionLikesByQuestionQuestionId(Integer questionId);
//	@Query("select question.questionText from question q inner join questionLikes l on q.questionId = l.questionId group by q.questionId having count(*)>questionLikes")
//	public Question findQuestionByMaxQuestionLikes(Integer questionLikes);
}
