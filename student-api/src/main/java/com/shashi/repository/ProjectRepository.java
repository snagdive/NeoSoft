package com.shashi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shashi.model.Project;
import com.shashi.model.Student;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
	
	List<Project> findByStudent(Student stud);

}
