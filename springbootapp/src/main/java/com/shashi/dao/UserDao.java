package com.shashi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shashi.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	
	public List<User> findByName(String name);
	
	public List<User> findBySurname(String surname);
	
	public List<User> findByPincode(String pincode);
	
	public List<User> findByOrderByDob();
	
	public List<User> findByOrderByDoj();

}
