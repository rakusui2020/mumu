package com.culnou.mumu.my_way.temp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.culnou.mumu.my_way.temp.entity.jpa.User;
import com.culnou.mumu.my_way.temp.repository.UserJpaRepository;

@Service
@Transactional
public class UserJpaService {
	
	@Autowired
    private UserJpaRepository userRepository;
	

	
	public User createUser(User user) {
		// TODO Auto-generated method stub
		
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
