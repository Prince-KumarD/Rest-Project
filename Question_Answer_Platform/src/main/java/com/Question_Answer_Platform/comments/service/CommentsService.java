package com.Question_Answer_Platform.comments.service;

import java.util.List;

import com.Question_Answer_Platform.comments.model.Comments;

public interface CommentsService {

	public Comments addComments(Comments comments);
	public List<Comments> findAllComments();
	public Comments updateComments(Comments comments);
	public List<Comments> findCommentsByAnswerId(Integer answerId);
	public List<Comments> findCommentsByUserId(Integer userId);
	public void deleteComments(Comments comments);
	public void deleteAllComments();
	public void deleteCommentsByCommentId(Integer commentId);
	public void deleteCommentsByUserId(Integer userId);
	public void deleteCommentsByUserIdAndCommentId(Integer userId, Integer commentId);
}
