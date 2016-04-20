package com.beauapp.server.service;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauapp.server.database.User;
import com.beauapp.server.database.UserRep;

@Service
public class iniDBService {
	@Autowired
	private UserRep userRep;
	

	@PostConstruct
	public void init(){
		
		User tester =new User();
		tester.setEmail("zc_tao13@hotmail.com");
		tester.setPassword("password");
		userRep.save(tester);
		System.out.println("----------------------!!!!!!!!!!!!!!!!!-------------------------------");
		
	}
}
