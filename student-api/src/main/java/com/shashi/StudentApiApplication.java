package com.shashi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.shashi.repository.ProjectRepository;
import com.shashi.repository.StudentRepository;
import com.shashi.security.StudUserRepo;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {StudUserRepo.class, ProjectRepository.class, StudentRepository.class})
public class StudentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApiApplication.class, args);
	}

}
