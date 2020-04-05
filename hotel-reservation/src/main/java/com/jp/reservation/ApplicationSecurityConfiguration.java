package com.jp.reservation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/", "/index", "/css/*", "/js/*" ,"/img/*").permitAll()
		.anyRequest().authenticated()
		.and()
		.httpBasic();
	}
	
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		// TODO Auto-generated method stub
		List<UserDetails> users = new ArrayList<UserDetails>();
		users.add(User.withDefaultPasswordEncoder().username("jigarpatel").password("password").roles("USER","ADMIN").build());
		users.add(User.withDefaultPasswordEncoder().username("jdoe").password("foobar").roles("USER").build());
		
		return new InMemoryUserDetailsManager(users);
		
	}
	
	
	

	
}
