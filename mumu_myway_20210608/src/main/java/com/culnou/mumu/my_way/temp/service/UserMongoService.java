package com.culnou.mumu.my_way.temp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.culnou.mumu.my_way.temp.entity.mongo.User;
import com.culnou.mumu.my_way.temp.repository.UserMongoRepository;

@Service
@Transactional
public class UserMongoService {
	
	@Autowired
    private UserMongoRepository userRepository;
	//@Autowired
	//private UserJpaService userJpaService;
	
	
	
	public User createUser(User user) {
		// TODO Auto-generated method stub
		//Jpaにも記録する場合
		/*
		com.culnou.mumu.entity.jpa.User jpaUser = new com.culnou.mumu.entity.jpa.User();
		jpaUser.setId(user.getId());
		jpaUser.setName(user.getName());
		jpaUser.setDescription(user.getDescription());
		Job job = new Job();
		job.setId(user.getJobs().get(0).getId());
		//両側にセットするとリンクする。2020/11/08
		job.setUser(jpaUser);
		jpaUser.getJobs().add(job);
		userJpaService.createUser(jpaUser);
		*/
		return userRepository.save(user);
		
		
	}

	
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		Optional< User > userDb = this.userRepository.findById(user.getId());

        if (userDb.isPresent()) {
            User userUpdate = userDb.get();
            userUpdate.setId(user.getId());
            userUpdate.setName(user.getName());
            userUpdate.setDescription(user.getDescription());
            userRepository.save(userUpdate);
            return userUpdate;
        } else {
            System.out.println("error");
            return null;
        }
	}

	
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return this.userRepository.findAll();
	}

	
	public User getUserById(String userId) {
		// TODO Auto-generated method stub
		Optional< User > userDb = this.userRepository.findById(userId);
		if (userDb.isPresent()) {
			return userDb.get();
		}else {
			System.out.println("error");
            return null;
		}
	}

	
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		Optional < User > userDb = this.userRepository.findById(userId);

        if (userDb.isPresent()) {
            this.userRepository.delete(userDb.get());
        } else {
        	System.out.println("error");
        }

	}

}
