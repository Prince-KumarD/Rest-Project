package com.Question_Answer_Platform.comments.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Question_Answer_Platform.comments.model.Comments;

public interface CommentsRepo extends JpaRepository<Comments, Integer> {

	public void deleteCommentsByCommentId(Integer commentId);
	public List<Comments> findCommentsByAnswerAnswerId(Integer answerId);
	public List<Comments> findCommentsByUserUserId(Integer userId);
	public void deleteCommentsByUserUserId(Integer userId);
	public void deleteCommentsByUserUserIdAndCommentId(Integer userId, Integer commentId);
}
