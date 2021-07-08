package com.shashi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shashi.model.Student;
import com.shashi.security.User;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	Optional<Student> findByUser(User user);

}
