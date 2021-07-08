package com.shashi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shashi.model.Project;
import com.shashi.model.Student;
import com.shashi.security.StudUserService;
import com.shashi.security.User;
import com.shashi.service.ProjectService;
import com.shashi.service.StudentService;

@Controller
public class ProjectController {
	
	@Autowired
	private ProjectService projectServce;
	@Autowired
	private StudentService service;
	@Autowired
	private StudUserService userService;
	
	@RequestMapping(value = "/project/add", method = RequestMethod.POST)
	public ModelAndView addProject(Project newProj)
	{
		String username = userService.getCurentUser();		
		User user = userService.getUserByUsername(username);		
		Student student = service.getStudentByUser(user);		
		newProj.setStudent(student);
		
		projectServce.saveProject(newProj);
		
		List<Project> projList = projectServce.getProjectByStudent(student);
		ModelAndView model = new ModelAndView();
		model.setViewName("StudentHome");
		model.addObject("user", user);
		model.addObject("student", student);
		model.addObject("allProjects", projList);
		return model;
	}
	
	@RequestMapping(value = "/project/delete/{pid}")
	public ModelAndView deleteProject(@PathVariable int pid)
	{
		
		String username = userService.getCurentUser();		
		User user = userService.getUserByUsername(username);		
		Student student = service.getStudentByUser(user);		
		
		projectServce.deleteProject(pid);
		
		List<Project> projList = projectServce.getProjectByStudent(student);
		ModelAndView model = new ModelAndView();
		model.setViewName("StudentHome");
		model.addObject("user", user);
		model.addObject("student", student);
		model.addObject("allProjects", projList);
		return model;
	}

}
