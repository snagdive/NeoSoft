package com.shashi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shashi.exception.UserNotFoundException;
import com.shashi.model.User;
import com.shashi.service.UserService;

@SpringBootTest
public class UserControllerTest {
	
	@Autowired
	private UserService service;
	
	@Test
	public void testRegisterUser()
	{
		User user = new User(1, "Shashi", "Nagdive", "440026", new Date(), new Date(), true);
		service.saveUser(user);
		assertNotNull(service.getUserById(1));
	}
	
	@Test
	public void testGetAllUser()
	{
		List<User> users = service.getAllUsers();
		assertThat(users.size()).isGreaterThan(0);
	}
	
	@Test
	public void testGetUserById()
	{
		assertNotNull(service.getUserById(1));
	}
	
	@Test
	public void testGetUserByValue() throws Exception
	{		
		Map<String, String> nameMap = new HashMap<>();
		nameMap.put("searchBy", "name");
		nameMap.put("searchValue", "Shashi");
		assertNotNull(service.searchUserBy(nameMap));
		
		Map<String, String> surnameMap = new HashMap<>();
		surnameMap.put("searchBy", "surname");
		surnameMap.put("searchValue", "Nagdive");
		assertNotNull(service.searchUserBy(surnameMap));
		
		Map<String, String> pincodeMap = new HashMap<>();
		pincodeMap.put("searchBy", "pincode");
		pincodeMap.put("searchValue", "440026");
		assertNotNull(service.searchUserBy(pincodeMap));		
	}
	
	@Test
	public void testEditUser()
	{
		User newUser = new User();
		newUser.setName("Shashikant");
		service.updateUser(newUser, 1);
		assertNotEquals("Shashi", service.getUserById(1).getName());
	}
	
	@Test
	public void testHardDelete()
	{
		service.deleteUser(1, "hard");
		assertThrows(UserNotFoundException.class, ()->service.getUserById(1));
	}
	
	@Test
	public void testSoftDelete()
	{
		service.deleteUser(1, "soft");
		assertThat(service.getUserById(1).getActiveStatus()).isEqualTo(false);
	}

}
