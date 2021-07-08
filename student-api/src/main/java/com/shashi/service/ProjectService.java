package com.shashi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shashi.model.Project;
import com.shashi.model.Student;
import com.shashi.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepo;
	
	public List<Project> getProjectByStudent(Student stud)
	{
		return projectRepo.findByStudent(stud);		
	}
	
	public Project saveProject(Project project)
	{
		return projectRepo.save(project);
	}
	
	public void deleteProject(int pid)
	{
		projectRepo.deleteById(pid);
	}
	

}
