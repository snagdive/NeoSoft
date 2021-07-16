package com.shashi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shashi.exception.InvalidRequestException;
import com.shashi.exception.UserNotFoundException;
import com.shashi.model.User;
import com.shashi.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping
	public List<User> getAllUsers()
	{
		return service.getAllUsers();
	}
	
	@GetMapping("/{uid}")
	public User getUserById(@PathVariable int uid) throws UserNotFoundException
	{		
		return service.getUserById(uid);
	}
	
	@GetMapping("/sortedlist")
	public List<User> getUsersSorted(@RequestParam Optional<String> sortBy) 
	{		
		System.out.println("Sort By : "+sortBy);
		return service.getUsersSorted(sortBy);
	}
	
	@GetMapping("/findby")
	public List<User> searchUserBy(@RequestParam String searchBy, @RequestParam String searchValue) throws InvalidRequestException 
	{		
		System.out.println("Search By: "+searchBy+" SearchValue : "+searchValue);
		Map<String, String> mapParam = new HashMap<>();
		mapParam.put("searchBy", searchBy);
		mapParam.put("searchValue", searchValue);
		return service.searchUserBy(mapParam);
	}	
	
	@PostMapping("/register")
	public ResponseEntity<Object> saveUser(@RequestBody User user)
	{
		return service.saveUser(user);
	}
	
	@PutMapping("/update/{uid}")
	public ResponseEntity<Object> updateUser(@RequestBody User newUser, @PathVariable int uid)
	{
		return service.updateUser(newUser, uid);
	}
	
	@DeleteMapping("/delete/{uid}")
	public void deleteUser(@PathVariable int uid, @RequestParam String type)
	{
		System.out.println(type);
		service.deleteUser(uid, type);
	}

}



