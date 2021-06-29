package com.shashi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter 
	private Integer uid;
	@Getter @Setter
	private String name;
	@Getter @Setter
	private  String surname;
	@Getter @Setter 
	private String pincode;
	@Getter @Setter 
	private Date dob;
	@Getter @Setter 
	private Date doj;
	@Getter @Setter 
	private Boolean activeStatus;	

}
