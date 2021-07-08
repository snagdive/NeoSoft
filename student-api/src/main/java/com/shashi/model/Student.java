package com.shashi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.shashi.security.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@NoArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private Integer sid;
	
	@Getter @Setter
	private String firstname;
	
	@Getter @Setter
	private String lastname;
	
	@Getter @Setter
	private String mobile;
	
	@Getter @Setter
	private String email;
	
	@Getter @Setter
	@OneToOne(mappedBy = "student", fetch = FetchType.LAZY)
	private User user;
	
	@Getter @Setter
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Project> projects;
	


}
