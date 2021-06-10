package com.culnou.mumu.my_way.temp.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.culnou.mumu.my_way.temp.entity.mongo.Comment;
import com.culnou.mumu.my_way.temp.repository.CommentMongoRepository;


@Service
@Transactional
public class CommentMongoService {
	
	@Autowired
    private CommentMongoRepository commentRepository;
	//@Autowired
	//private CommentJpaService commentJpaService;
	
	
	
	public Comment createComment(Comment comment) {
		// TODO Auto-generated method stub
		/* Jpaにも記録する場合
		com.culnou.mumu.entity.jpa.Comment jpaComment = new com.culnou.mumu.entity.jpa.Comment();
		jpaComment.setId(comment.getId());
		jpaComment.setName(comment.getName());
		jpaComment.setDescription(comment.getDescription());
		commentJpaService.createComment(jpaComment);
		*/
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
