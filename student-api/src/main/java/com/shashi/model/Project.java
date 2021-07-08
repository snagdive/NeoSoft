package com.shashi.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private Integer pid;
	
	@Getter @Setter
	private String projectName;
	
	@Getter @Setter
	private Integer duration;
		
	@Getter @Setter
	@ManyToOne(fetch = FetchType.LAZY)
	private Student student;

	@Override
	public String toString() {
		return "Project [pid=" + pid + ", projectName=" + projectName + ", duration=" + duration + "]";
	}
	
}
