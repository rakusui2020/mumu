package com.culnou.mumu.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.culnou.mumu.entity.jpa.Member;



public interface MemberJpaRepository extends JpaRepository<Member, String> {

}
