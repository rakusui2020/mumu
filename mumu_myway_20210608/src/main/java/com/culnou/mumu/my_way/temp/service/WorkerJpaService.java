package com.culnou.mumu.my_way.temp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.culnou.mumu.my_way.temp.entity.jpa.Worker;
import com.culnou.mumu.my_way.temp.repository.WorkerJpaRepository;

@Service
@Transactional
public class WorkerJpaService{
	
	@Autowired
    private WorkerJpaRepository workerRepository;
	

	
	public Worker createWorker(Worker worker) {
		// TODO Auto-generated method stub
		
		return workerRepository.save(worker);
	}

	
	public Worker updateWorker(Worker worker) {
		// TODO Auto-generated method stub
		Optional< Worker > workerDb = this.workerRepository.findById(worker.getId());

        if (workerDb.isPresent()) {
            Worker workerUpdate = workerDb.get();
            workerUpdate.setId(worker.getId());
            workerUpdate.setName(worker.getName());
            workerUpdate.setDescription(worker.getDescription());
            workerRepository.save(workerUpdate);
            return workerUpdate;
        } else {
            System.out.println("error");
            return null;
        }
	}

	
	public List<Worker> getAllWorker() {
		// TODO Auto-generated method stub
		return this.workerRepository.findAll();

	}

	
	public Worker getWorkerById(String workerId) {
		// TODO Auto-generated method stub
		Optional< Worker > workerDb = this.workerRepository.findById(workerId);
		if (workerDb.isPresent()) {
			return workerDb.get();
		}else {
			System.out.println("error");
            return null;
		}
	}

	
	public void deleteWorker(String workerId) {
		// TODO Auto-generated method stub
		Optional < Worker > workerDb = this.workerRepository.findById(workerId);

        if (workerDb.isPresent()) {
            this.workerRepository.delete(workerDb.get());
        } else {
        	System.out.println("error");
        }
		
	}

}
