package com.culnou.mumu.my_way.temp.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.culnou.mumu.my_way.temp.entity.mongo.Task;
import com.culnou.mumu.my_way.temp.repository.TaskMongoRepository;


@Service
@Transactional
public class TaskMongoService {
	
	@Autowired
    private TaskMongoRepository taskRepository;
	
	
	
	
	public Task createTask(Task task) {
		// TODO Auto-generated method stub
		/* Jpaにも記録する場合
		com.culnou.mumu.entity.jpa.Task jpaTask = new com.culnou.mumu.entity.jpa.Task();
		jpaTask.setId(task.getId());
		jpaTask.setName(task.getName());
		jpaTask.setDescription(task.getDescription());
		taskJpaService.createTask(jpaTask);
		*/
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
