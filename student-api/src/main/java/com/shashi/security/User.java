package com.shashi.security;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.shashi.model.Student;

import lombok.Getter;
import lombok.Setter;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private Integer uid;
	
	@Getter @Setter
	@Column(unique = true)
	private String username;
	
	@Getter @Setter
	private String password;
	
	@Getter @Setter
	private boolean active;
	
	@Getter @Setter
	private String roles;
	
	@Getter @Setter
	@OneToOne( fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private Student student;
	

}
