package com.beauapp.server.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beauapp.server.database.User;
import com.beauapp.server.database.UserRep;
import com.beauapp.server.utilities.MD5PwdEncrption;
import com.beauapp.server.utilities.Routers;
import com.beauapp.server.utilities.Status;

@Controller
public class RegisterController {
	
	 @Autowired
	 private UserRep userRep;
	
	@RequestMapping(value =  Routers.USER_REGISTER, method = RequestMethod.POST)
	public @ResponseBody String userRegister(@RequestParam("email") String email,
			 @RequestParam("password") String password,
			 @RequestParam("username") String username){
		List<User> user_list=userRep.findOneUserByEmail(email);
		if(user_list!=null&& user_list.size()>0){
			return "The email has been registered ";
		}
		User user= new User();
		user.setEmail(email);
		user.setUsername((username!=null && !username.trim().equals(""))?username:email);
		user.setCreated_at(new Date());
		user.setStatus(Status.ACTIVE);
		user.setPassword(MD5PwdEncrption.generateHashedPwd(password));
		userRep.save(user);
		return "success";
		
	}
}
