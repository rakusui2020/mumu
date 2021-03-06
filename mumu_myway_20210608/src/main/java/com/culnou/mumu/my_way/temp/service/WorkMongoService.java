package com.culnou.mumu.my_way.temp.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.culnou.mumu.my_way.temp.entity.mongo.Work;
import com.culnou.mumu.my_way.temp.repository.WorkMongoRepository;



@Service
@Transactional
public class WorkMongoService {
	
	@Autowired
    private WorkMongoRepository workRepository;
	//@Autowired
	//private WorkJpaService workJpaService;
	
	
	
	public Work createWork(Work work) {
		// TODO Auto-generated method stub
		/* Jpaにも記録する場合
		com.culnou.mumu.entity.jpa.Work jpaWork = new com.culnou.mumu.entity.jpa.Work();
		jpaWork.setId(work.getId());
		jpaWork.setName(work.getName());
		jpaWork.setDescription(work.getDescription());
		workJpaService.createWork(jpaWork);
		*/
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
