package com.culnou.mumu.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.culnou.mumu.entity.jpa.Account;


public interface AccountJpaRepository extends JpaRepository<Account, String> {

}
