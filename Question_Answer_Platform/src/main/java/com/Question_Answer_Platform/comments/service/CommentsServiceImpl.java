package com.Question_Answer_Platform.comments.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Question_Answer_Platform.comments.dao.CommentsRepo;
import com.Question_Answer_Platform.comments.model.Comments;
import com.Question_Answer_Platform.exception.CommentsNotFoundException;

@Service
@Transactional
public class CommentsServiceImpl implements CommentsService {
	
	@Autowired
	private CommentsRepo commentRepo;
	

	@Override
	public Comments addComments(Comments comments) {
		return commentRepo.save(comments);
	}

	@Override
	public List<Comments> findAllComments() {
		return commentRepo.findAll();
	}

	@Override
	public Comments updateComments(Comments comments) {
		return commentRepo.save(comments);
	}



	@Override
	public void deleteComments(Comments comments) {

		commentRepo.delete(comments);
	}

	@Override
	public void deleteAllComments() {

		commentRepo.deleteAll();
	}

	@Override
	public void deleteCommentsByCommentId(Integer commentId) {
		commentRepo.deleteCommentsByCommentId(commentId);
		
	}

	@Override
	public List<Comments> findCommentsByAnswerId(Integer answerId) {
		List<Comments> comment = commentRepo.findCommentsByAnswerAnswerId(answerId);
		if(comment==null) {
			throw new CommentsNotFoundException("Comments not found");
		}
		return comment;
	}

	@Override
	public List<Comments> findCommentsByUserId(Integer userId) {
		List<Comments> comment = commentRepo.findCommentsByUserUserId(userId);
		if(comment==null) {
			throw new CommentsNotFoundException("Comments not found");
		}
		return comment;
	}

	@Override
	public void deleteCommentsByUserId(Integer userId) {
	
		commentRepo.deleteCommentsByUserUserId(userId);
		
	}

	@Override
	public void deleteCommentsByUserIdAndCommentId(Integer userId, Integer commentId) {
		commentRepo.deleteCommentsByUserUserIdAndCommentId(userId, commentId);
		
	}

}
