package com.shashi.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.shashi.dao.UserDao;
import com.shashi.exception.InvalidRequestException;
import com.shashi.exception.UserNotFoundException;
import com.shashi.model.User;

@Service
public class UserService {
	
	@Autowired
	UserDao repo;
	
	public List<User> getAllUsers()
	{
		List<User> users = repo.findAll();
		Iterator<User> itr = users.listIterator();
		while(itr.hasNext())
		{
			User user = itr.next();
			if(!user.getActiveStatus())
				itr.remove();
		}
		return users;
	}
	
	public User getUserById(Integer uid)
	{
		User user = repo.findById(uid).orElse(null);
		if(user == null)
			throw new UserNotFoundException("User Not Found with ID : "+uid);	
			
		return user;
	}
	
	public List<User> getUsersSorted(Optional<String> sortBy)
	{				
		if(sortBy.isPresent())
		{
			if(sortBy.get().equals("dob"))
				return repo.findByOrderByDob();
			if(sortBy.get().equals("doj"))
				return repo.findByOrderByDoj();
		}
		return repo.findAll();
		
	}
	
	public List<User> getUserByName(String name)
	{
		return repo.findByName(name);
	}
	
	public ResponseEntity<Object> saveUser(User user)
	{
		User savedUser = repo.save(user);
		java.net.URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{uid}")
				.buildAndExpand(savedUser.getUid()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	public ResponseEntity<Object> updateUser(User newUser, int uid)
	{
		User savedUser = repo.findById(uid).map(user -> {			
			if(newUser.getName()!=null)
				user.setName(newUser.getName());
			if(newUser.getSurname()!=null)
				user.setSurname(newUser.getSurname());
			if(newUser.getPincode()!=null)
				user.setPincode(newUser.getPincode());
			if(newUser.getDob()!=null)
				user.setDob(newUser.getDob());
			if(newUser.getDoj()!=null)
				user.setDoj(newUser.getDoj());
			if(newUser.getActiveStatus()!=null)
				user.setActiveStatus(newUser.getActiveStatus());
			
			return repo.save(user);
		})
		.orElseGet(()->{
			throw new UserNotFoundException("User Not Found with ID : "+uid) ;
		});
			
		java.net.URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{uid}")
				.buildAndExpand(savedUser.getUid()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	public void deleteUser(int uid, String type)
	{	
		User deleteUser = repo.findById(uid).orElseGet(()->{
			throw new UserNotFoundException("User Not Found with ID : "+uid);
		});
		
		if(type.equals("hard"))
		{
			repo.delete(deleteUser);
			return;
		}
		
		deleteUser.setActiveStatus(false);
		repo.save(deleteUser);
		return;	
	}
	
	public List<User> searchUserBy(Map<String, String> mapParam) throws InvalidRequestException
	{
		List<User> userList = null;
		String searchBy     = mapParam.getOrDefault("searchBy", null);
		String searchValue  = mapParam.getOrDefault("searchValue", null);
		if(searchBy!=null && searchValue!=null)
		{
			if(searchBy.equals("name"))
			{
				userList = repo.findByName(searchValue);
			}
			if(searchBy.equals("surname"))
				userList = repo.findBySurname(searchValue);
			if(searchBy.equals("pincode"))
				userList = repo.findByPincode(searchValue);
		}
		else
			throw new InvalidRequestException("All Required Data Not Provided.");
		return userList;
	}

}
