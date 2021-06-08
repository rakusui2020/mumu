package com.culnou.mumu.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.culnou.mumu.entity.jpa.Comment;



public interface CommentJpaRepository extends JpaRepository<Comment, String> {

}
