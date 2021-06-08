package com.culnou.mumu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.culnou.mumu.entity.jpa.Work;
import com.culnou.mumu.repository.WorkJpaRepository;

@Service
@Transactional
public class WorkJpaService{
	
	@Autowired
    private WorkJpaRepository workRepository;
	

	
	public Work createWork(Work work) {
		// TODO Auto-generated method stub
		
		return workRepository.save(work);
	}

	
	public Work updateWork(Work work) {
		// TODO Auto-generated method stub
		Optional< Work > workDb = this.workRepository.findById(work.getId());

        if (workDb.isPresent()) {
            Work workUpdate = workDb.get();
            workUpdate.setId(work.getId());
            workUpdate.setName(work.getName());
            workUpdate.setDescription(work.getDescription());
            workRepository.save(workUpdate);
            return workUpdate;
        } else {
            System.out.println("error");
            return null;
        }
	}

	
	public List<Work> getAllWork() {
		// TODO Auto-generated method stub
		return this.workRepository.findAll();

	}

	
	public Work getWorkById(String workId) {
		// TODO Auto-generated method stub
		Optional< Work > workDb = this.workRepository.findById(workId);
		if (workDb.isPresent()) {
			return workDb.get();
		}else {
			System.out.println("error");
            return null;
		}
	}

	
	public void deleteWork(String workId) {
		// TODO Auto-generated method stub
		Optional < Work > workDb = this.workRepository.findById(workId);

        if (workDb.isPresent()) {
            this.workRepository.delete(workDb.get());
        } else {
        	System.out.println("error");
        }
		
	}

}
