package com.shashi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shashi.model.Student;
import com.shashi.repository.StudentRepository;
import com.shashi.security.User;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepo;
	
	public Student saveStudent(Student stud)
	{		
		return studentRepo.save(stud);
	}
	
	public Student getStudentById(int sid)
	{
		
		return studentRepo.getById(sid);
	}
	
	public Student getStudentByUser(User user)
	{
		Optional<Student> stud = studentRepo.findByUser(user);
		if(stud.isPresent())
			return stud.get();
		else
			return null;
	}
	
	public List<Student> getAllStudents()
	{
		return studentRepo.findAll();
	}
	
	public void deleteStudent(Student stud)
	{
		studentRepo.delete(stud);
	}

}
