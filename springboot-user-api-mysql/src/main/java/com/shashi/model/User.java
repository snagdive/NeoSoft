package com.shashi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Getter @Setter 
	private Integer uid;
	
	@NotNull(message = "Name can not be empty.")
	@Getter @Setter
	private String name;
	
	@NotNull(message = "Surname can not be empty.")
	@Getter @Setter
	private  String surname;
	
	@Size(min = 6, message = "Pincode must have atleat 6 digits.")
	@Getter @Setter 
	private String pincode;
	
	@Past(message = "Date of birth must be a date in past.")
	@Getter @Setter 
	private Date dob;
	
	@Getter @Setter 
	private Date doj;
	
	@Getter @Setter 
	private Boolean activeStatus;	

}
