package com.shashi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	StudUserService studUserService;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(studUserService);
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	public void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
			.antMatchers("/admin").hasRole("ADMIN")		
			.antMatchers("/student/delete/*").hasAnyRole("ADMIN") 	 				 //  If using hasRole() or hasAnyRole()
			.antMatchers("/student/*","/project/*").hasAnyRole("USER","ADMIN")      //   roles must be prefixed with 'ROLE_' in Database.	
			.antMatchers("/*").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/login").loginProcessingUrl("/doLogin")
			.defaultSuccessUrl("/loginSuccess",true).permitAll()
			.and()
			.logout().logoutUrl("/doLogout")
			.logoutSuccessUrl("/logoutSuccess").permitAll();
		
		http.csrf().disable();
	}

}
