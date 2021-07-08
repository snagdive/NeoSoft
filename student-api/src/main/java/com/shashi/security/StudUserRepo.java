package com.shashi.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shashi.model.Student;

@Repository
public interface StudUserRepo extends JpaRepository<User, Integer> {
	
	Optional<User> findByUsername(String username);
	
	User findByStudent(Student student);

}
