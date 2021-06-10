package com.culnou.mumu.my_way.temp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.culnou.mumu.my_way.temp.entity.jpa.Project;
import com.culnou.mumu.my_way.temp.repository.ProjectJpaRepository;

@Service
@Transactional
public class ProjectJpaService{
	
	@Autowired
    private ProjectJpaRepository projectRepository;
	

	
	public Project createProject(Project project) {
		// TODO Auto-generated method stub
		
		return projectRepository.save(project);
	}

	
	public Project updateProject(Project project) {
		// TODO Auto-generated method stub
		Optional< Project > projectDb = this.projectRepository.findById(project.getId());

        if (projectDb.isPresent()) {
            Project projectUpdate = projectDb.get();
            projectUpdate.setId(project.getId());
            projectUpdate.setName(project.getName());
            projectUpdate.setDescription(project.getDescription());
            projectRepository.save(projectUpdate);
            return projectUpdate;
        } else {
            System.out.println("error");
            return null;
        }
	}

	
	public List<Project> getAllProject() {
		// TODO Auto-generated method stub
		return this.projectRepository.findAll();

	}

	
	public Project getProjectById(String projectId) {
		// TODO Auto-generated method stub
		Optional< Project > projectDb = this.projectRepository.findById(projectId);
		if (projectDb.isPresent()) {
			return projectDb.get();
		}else {
			System.out.println("error");
            return null;
		}
	}

	
	public void deleteProject(String projectId) {
		// TODO Auto-generated method stub
		Optional < Project > projectDb = this.projectRepository.findById(projectId);

        if (projectDb.isPresent()) {
            this.projectRepository.delete(projectDb.get());
        } else {
        	System.out.println("error");
        }
		
	}

}
