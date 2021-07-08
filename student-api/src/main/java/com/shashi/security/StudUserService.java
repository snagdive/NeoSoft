package com.shashi.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shashi.model.Student;

@Service
public class StudUserService implements UserDetailsService {

	@Autowired
	private StudUserRepo studUserRepo; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			
		Optional<User> user = studUserRepo.findByUsername(username);
		
		if(!user.isPresent())
			throw new UsernameNotFoundException("User Not Found With Username:"+ username);
		
		StudUseDetails userDetails = new StudUseDetails(user.get());
		
		return userDetails;
	}
	
	public String getCurentUser()
	{
		String username = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
		   username = ((UserDetails)principal).getUsername();
		} else {
		   username = principal.toString();
		}
		
		return username;
	}
	
	public User saveUser(User newUser)
	{
		return studUserRepo.save(newUser);
	}
	
	public User getUserByUsername(String username)
	{
		Optional<User> user = studUserRepo.findByUsername(username);
		if(!user.isPresent())
			new UsernameNotFoundException("User not found with Username : "+username);
		
		return user.get();
	}
	
	public User getUserById(int uid)
	{
		Optional<User> user = studUserRepo.findById(uid);
		if(!user.isPresent())
			new UsernameNotFoundException("User not found with User ID : "+uid);
		
		return user.get();
	}
	
	public User getUserByStudent(Student stud)
	{
		return studUserRepo.findByStudent(stud);
	}
	
	public void deleteUser(User User)
	{
		studUserRepo.delete(User);
	}

}
