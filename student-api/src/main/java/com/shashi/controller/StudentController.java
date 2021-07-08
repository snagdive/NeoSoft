package com.shashi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shashi.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
//	@GetMapping(value = "/")
//	public String showHome()
//	{
//		return "Home";
//	}
//	
	@GetMapping(value = "/student")
	public String showHomeStudent()
	{
		return "<h1>Student Home</h1>";
	}
	
	@GetMapping(value = "/admin")
	public String showHomeAdmin()
	{
		return "Admin Home";
	}
	

}
