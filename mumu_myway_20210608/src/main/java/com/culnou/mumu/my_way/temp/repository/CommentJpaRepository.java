package com.culnou.mumu.my_way.temp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.culnou.mumu.my_way.temp.entity.jpa.Comment;



public interface CommentJpaRepository extends JpaRepository<Comment, String> {

}
