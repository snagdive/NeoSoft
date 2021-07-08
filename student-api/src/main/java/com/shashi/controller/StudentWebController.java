package com.shashi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shashi.model.Project;
import com.shashi.model.Student;
import com.shashi.security.StudUserService;
import com.shashi.security.User;
import com.shashi.service.ProjectService;
import com.shashi.service.StudentService;

@Controller
public class StudentWebController {
	
	@Autowired
	private StudentService service;
	@Autowired
	private StudUserService userService;
	@Autowired
	private ProjectService projService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHome()
	{
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin(Model model, String error, String logout)
	{
		if(error != null)
			model.addAttribute("errorMsg", "Invalid Userame an Password.");
		
		if(logout != null)
			model.addAttribute("logoutMsg", "You have been logged out.");		
		
		return "login";
	}	
	
	@RequestMapping(value = "/loginSuccess")
	public ModelAndView showStudentHome()
	{
		String username = userService.getCurentUser();		
		User user = userService.getUserByUsername(username);
		Student student = user.getStudent();
		
		
		ModelAndView model = new ModelAndView();		
		model.addObject("user", user);
		model.addObject("student", student);
		if(user.getRoles().contains("USER"))
		{
			List<Project> projList = projService.getProjectByStudent(student);
			model.setViewName("StudentHome");
			model.addObject("allProjects", projList);
		}
		else
		{
			List<Student> studList = service.getAllStudents();
			model.setViewName("adminHome");
			model.addObject("allStudents", studList);
		}
		
		return model;
	}
	
	@RequestMapping(value = "/logoutSuccess")
	public ModelAndView showLoginPage()
	{
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		model.addObject("logoutMsg", "You have been Logged out.");
		return model;
	}
	
	@RequestMapping(value = "/register")
	public ModelAndView showRegistrationPage()
	{
		ModelAndView model = new ModelAndView();
		model.setViewName("registerStudent");
		return model;
	}
	
	@RequestMapping(value = "/doRegister")
	public ModelAndView saveRegistration(User newUser)
	{				
		userService.saveUser(newUser);
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		model.addObject("logoutMsg", "User have been Registered.");
		return model;
	}	
	
	@RequestMapping(value = "/student/edit/{uid}", method = RequestMethod.GET)
	public String showEditPersonalDetailsPage(@PathVariable int uid, Model model)
	{						
		User user = userService.getUserById(uid);
		model.addAttribute("user", user);
		Student stud = user.getStudent();
		if(stud==null)
			model.addAttribute("student", new Student());
		else
			model.addAttribute("student", stud);
		return "editPersonalDetails";
	}
	
	@RequestMapping(value = "/student/update", method = RequestMethod.POST)
	public ModelAndView updateUserDetails(Student newStud)
	{		
		ModelAndView model = new ModelAndView();
		String username = userService.getCurentUser();		
		User user = userService.getUserByUsername(username);
		Student stud = service.getStudentByUser(user);
		
		if(stud!=null)
		{			
			stud.setFirstname(newStud.getFirstname());
			stud.setLastname(newStud.getLastname());
			stud.setMobile(newStud.getMobile());
			stud.setEmail(newStud.getEmail());
			service.saveStudent(stud);
		}
		else
		{
			service.saveStudent(newStud);
			user.setStudent(newStud);
			userService.saveUser(user);
		}
		
		List<Project> projList = projService.getProjectByStudent(stud);
		model.setViewName("StudentHome");
		model.addObject("student", stud);
		model.addObject("user", user);
		model.addObject("allProjects", projList);
		return model;
	}
	
	@RequestMapping(value = "/student/delete/{sid}")
	public ModelAndView deleteStudent(@PathVariable int sid)
	{
		Student stud = service.getStudentById(sid);
		User user = userService.getUserByStudent(stud);
		userService.deleteUser(user);
		//service.deleteStudent(stud);
		
		ModelAndView model = new ModelAndView();
		List<Student> studList = service.getAllStudents();
		model.setViewName("adminHome");
		model.addObject("allStudents", studList);
		return model;
	}
	
}





