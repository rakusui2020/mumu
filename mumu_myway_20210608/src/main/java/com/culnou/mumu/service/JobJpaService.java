package com.culnou.mumu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.culnou.mumu.entity.jpa.Job;
import com.culnou.mumu.repository.JobJpaRepository;

@Service
@Transactional
public class JobJpaService{
	
	@Autowired
    private JobJpaRepository jobRepository;
	

	
	public Job createJob(Job job) {
		// TODO Auto-generated method stub
		
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
