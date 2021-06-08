package com.culnou.mumu.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.culnou.mumu.entity.mongo.Job;
import com.culnou.mumu.repository.JobMongoRepository;

@Service
@Transactional
public class JobMongoService {
	
	@Autowired
    private JobMongoRepository jobRepository;
	//@Autowired
	//private JobJpaService jobJpaService;
	
	
	
	public Job createJob(Job job) {
		// TODO Auto-generated method stub
		//Jpaにも記録する場合
		/*
		com.culnou.mumu.entity.jpa.Job jpaJob = new com.culnou.mumu.entity.jpa.Job();
		jpaJob.setId(job.getId());
		jpaJob.setName(job.getName());
		jpaJob.setDescription(job.getDescription());
		jobJpaService.createJob(jpaJob);
		*/
		return jobRepository.save(job);
		
		
	}

	
	public Job updateJob(Job job) {
		// TODO Auto-generated method stub
		Optional< Job > jobDb = this.jobRepository.findById(job.getId());

        if (jobDb.isPresent()) {
            Job jobUpdate = jobDb.get();
            jobUpdate.setId(job.getId());
            jobUpdate.setName(job.getName());
            jobUpdate.setDescription(job.getDescription());
            jobRepository.save(jobUpdate);
            return jobUpdate;
        } else {
            System.out.println("error");
            return null;
        }
	}

	
	public List<Job> getAllJob() {
		// TODO Auto-generated method stub
		return this.jobRepository.findAll();
	}

	
	public Job getJobById(String jobId) {
		// TODO Auto-generated method stub
		Optional< Job > jobDb = this.jobRepository.findById(jobId);
		if (jobDb.isPresent()) {
			return jobDb.get();
		}else {
			System.out.println("error");
            return null;
		}
	}

	
	public void deleteJob(String jobId) {
		// TODO Auto-generated method stub
		Optional < Job > jobDb = this.jobRepository.findById(jobId);

        if (jobDb.isPresent()) {
            this.jobRepository.delete(jobDb.get());
        } else {
        	System.out.println("error");
        }

	}

}
