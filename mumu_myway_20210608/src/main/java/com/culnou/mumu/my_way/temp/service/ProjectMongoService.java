package com.culnou.mumu.my_way.temp.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.culnou.mumu.my_way.temp.entity.mongo.Project;
import com.culnou.mumu.my_way.temp.repository.ProjectMongoRepository;



@Service
@Transactional
public class ProjectMongoService {
	
	@Autowired
    private ProjectMongoRepository projectRepository;
	//@Autowired
	//private ProjectJpaService projectJpaService;
	
	
	
	public Project createProject(Project project) {
		// TODO Auto-generated method stub
		/* Jpaにも記録する場合
		com.culnou.mumu.entity.jpa.Project jpaProject = new com.culnou.mumu.entity.jpa.Project();
		jpaProject.setId(project.getId());
		jpaProject.setName(project.getName());
		jpaProject.setDescription(project.getDescription());
		projectJpaService.createProject(jpaProject);
		*/
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
