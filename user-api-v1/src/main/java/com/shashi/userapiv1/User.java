package com.shashi.userapiv1;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel.DynamoDBAttributeType;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;


@DynamoDBTable(tableName = "users")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@DynamoDBHashKey
	private String id;
	
	@DynamoDBAttribute
	private String name;
	
	@DynamoDBAttribute
	private String surname;
	
	@DynamoDBAttribute
	private String pincode;
	
	@DynamoDBTyped(DynamoDBAttributeType.BOOL)
	@DynamoDBAttribute
	private Boolean isActive;
	

	public User() {
		
	}

	public User(String id, String name, String surname, String pincode, Boolean isActive) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.pincode = pincode;
		this.isActive = isActive;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", pincode=" + pincode + ", isActive="
				+ isActive + "]";
	}

	
}
