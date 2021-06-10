package com.culnou.mumu.my_way.temp.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.culnou.mumu.my_way.temp.entity.mongo.Account;
import com.culnou.mumu.my_way.temp.repository.AccountMongoRepository;



@Service
@Transactional
public class AccountMongoService {
	
	@Autowired
    private AccountMongoRepository accountRepository;
	//@Autowired
	//private AccountJpaService accountJpaService;
	
	
	
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		/* Jpaにも記録する場合
		com.culnou.mumu.entity.jpa.Account jpaAccount = new com.culnou.mumu.entity.jpa.Account();
		jpaAccount.setId(account.getId());
		jpaAccount.setName(account.getName());
		jpaAccount.setDescription(account.getDescription());
		accountJpaService.createAccount(jpaAccount);
		*/
		return accountRepository.save(account);
		
		
	}

	
	public Account updateAccount(Account account) {
		// TODO Auto-generated method stub
		Optional< Account > accountDb = this.accountRepository.findById(account.getId());

        if (accountDb.isPresent()) {
            Account accountUpdate = accountDb.get();
            accountUpdate.setId(account.getId());
            accountUpdate.setName(account.getName());
            accountUpdate.setDescription(account.getDescription());
            accountRepository.save(accountUpdate);
            return accountUpdate;
        } else {
            System.out.println("error");
            return null;
        }
	}

	
	public List<Account> getAllAccount() {
		// TODO Auto-generated method stub
		return this.accountRepository.findAll();
	}

	
	public Account getAccountById(String accountId) {
		// TODO Auto-generated method stub
		Optional< Account > accountDb = this.accountRepository.findById(accountId);
		if (accountDb.isPresent()) {
			return accountDb.get();
		}else {
			System.out.println("error");
            return null;
		}
	}

	
	public void deleteAccount(String accountId) {
		// TODO Auto-generated method stub
		Optional < Account > accountDb = this.accountRepository.findById(accountId);

        if (accountDb.isPresent()) {
            this.accountRepository.delete(accountDb.get());
        } else {
        	System.out.println("error");
        }

	}

}
