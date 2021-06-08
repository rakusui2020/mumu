package com.culnou.mumu.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.culnou.mumu.entity.jpa.Tag;



public interface TagJpaRepository extends JpaRepository<Tag, String> {

}
