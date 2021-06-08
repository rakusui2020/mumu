package com.culnou.mumu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.culnou.mumu.entity.jpa.Comment;
import com.culnou.mumu.repository.CommentJpaRepository;

@Service
@Transactional
public class CommentJpaService{
	
	@Autowired
    private CommentJpaRepository commentRepository;
	

	
	public Comment createComment(Comment comment) {
		// TODO Auto-generated method stub
		
		return commentRepository.save(comment);
	}

	
	public Comment updateComment(Comment comment) {
		// TODO Auto-generated method stub
		Optional< Comment > commentDb = this.commentRepository.findById(comment.getId());

        if (commentDb.isPresent()) {
            Comment commentUpdate = commentDb.get();
            commentUpdate.setId(comment.getId());
            commentUpdate.setName(comment.getName());
            commentUpdate.setDescription(comment.getDescription());
            commentRepository.save(commentUpdate);
            return commentUpdate;
        } else {
            System.out.println("error");
            return null;
        }
	}

	
	public List<Comment> getAllComment() {
		// TODO Auto-generated method stub
		return this.commentRepository.findAll();

	}

	
	public Comment getCommentById(String commentId) {
		// TODO Auto-generated method stub
		Optional< Comment > commentDb = this.commentRepository.findById(commentId);
		if (commentDb.isPresent()) {
			return commentDb.get();
		}else {
			System.out.println("error");
            return null;
		}
	}

	
	public void deleteComment(String commentId) {
		// TODO Auto-generated method stub
		Optional < Comment > commentDb = this.commentRepository.findById(commentId);

        if (commentDb.isPresent()) {
            this.commentRepository.delete(commentDb.get());
        } else {
        	System.out.println("error");
        }
		
	}

}
