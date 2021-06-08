package com.culnou.mumu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.culnou.mumu.entity.mongo.Job;
//import com.culnou.mumu.entity.jpa.Job;
import com.culnou.mumu.service.JobMongoService;
//import com.culnou.mumu.service.JobJpaService;


@RestController
public class JobController {
	
	@Autowired
    private JobMongoService jobService;

    @GetMapping("/jobs")
    public ResponseEntity< List< Job >> getAllJob() {
        return ResponseEntity.ok().body(jobService.getAllJob());
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity < Job > getJobById(@PathVariable String id) {
        return ResponseEntity.ok().body(jobService.getJobById(id));
    }

    @PostMapping("/jobs")
    public ResponseEntity < Job > createJob(@RequestBody Job job) {
        return ResponseEntity.ok().body(this.jobService.createJob(job));
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity < Job > updateJob(@PathVariable String id, @RequestBody Job job) {
        job.setId(id);
        return ResponseEntity.ok().body(this.jobService.updateJob(job));
    }

    @DeleteMapping("/jobs/{id}")
    public HttpStatus deleteJob(@PathVariable String id) {
        this.jobService.deleteJob(id);
        return HttpStatus.OK;
    }
    
    

}
