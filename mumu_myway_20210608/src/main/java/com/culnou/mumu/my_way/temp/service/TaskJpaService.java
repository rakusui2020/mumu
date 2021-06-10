package com.culnou.mumu.my_way.temp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.culnou.mumu.my_way.temp.entity.jpa.Task;
import com.culnou.mumu.my_way.temp.repository.TaskJpaRepository;

@Service
@Transactional
public class TaskJpaService{
	
	@Autowired
    private TaskJpaRepository taskRepository;
	

	
	public Task createTask(Task task) {
		// TODO Auto-generated method stub
		
		return taskRepository.save(task);
	}

	
	public Task updateTask(Task task) {
		// TODO Auto-generated method stub
		Optional< Task > taskDb = this.taskRepository.findById(task.getId());

        if (taskDb.isPresent()) {
            Task taskUpdate = taskDb.get();
            taskUpdate.setId(task.getId());
            taskUpdate.setName(task.getName());
            taskUpdate.setDescription(task.getDescription());
            taskRepository.save(taskUpdate);
            return taskUpdate;
        } else {
            System.out.println("error");
            return null;
        }
	}

	
	public List<Task> getAllTask() {
		// TODO Auto-generated method stub
		return this.taskRepository.findAll();

	}

	
	public Task getTaskById(String taskId) {
		// TODO Auto-generated method stub
		Optional< Task > taskDb = this.taskRepository.findById(taskId);
		if (taskDb.isPresent()) {
			return taskDb.get();
		}else {
			System.out.println("error");
            return null;
		}
	}

	
	public void deleteTask(String taskId) {
		// TODO Auto-generated method stub
		Optional < Task > taskDb = this.taskRepository.findById(taskId);

        if (taskDb.isPresent()) {
            this.taskRepository.delete(taskDb.get());
        } else {
        	System.out.println("error");
        }
		
	}

}
