package com.culnou.mumu.my_way.temp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.culnou.mumu.my_way.temp.entity.jpa.Tag;



public interface TagJpaRepository extends JpaRepository<Tag, String> {

}
