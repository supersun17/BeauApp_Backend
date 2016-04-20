package com.beauapp.server.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beauapp.server.database.User;
import com.beauapp.server.database.UserRep;
import com.beauapp.server.utilities.JsonResponse;
import com.beauapp.server.utilities.MD5PwdEncrption;
import com.beauapp.server.utilities.Routers;
import com.fasterxml.jackson.annotation.JsonRawValue;

import java.util.Map;


@Controller
public class LoginController {
	
	 @Autowired
     private UserRep userRep;
    
	 @RequestMapping(value =  "/test", method = RequestMethod.GET)
	 public String test(Model model){
		  model.addAttribute("greeting", "MVC framework construction successed!");
	      return "index"; 
	 }
	 
	 @RequestMapping(value =  "/test1", method = RequestMethod.GET)
	 public @ResponseBody JsonResponse test1(){
		 
	      return new JsonResponse("Please register first"); 
	 }
	 
	 @RequestMapping(value =  Routers.USER_LOGIN, method = RequestMethod.POST)
	 public  @JsonRawValue @ResponseBody JsonResponse userLogin(@RequestParam("email") String email,
			 @RequestParam("password") String password,
			 @RequestParam("deviceID") String deviceID,
			 HttpServletRequest request){
		 //first time login
		 if(password!=null&& !password.trim().equals("")){
			 List<User> user_list=userRep.findOneUser(email,MD5PwdEncrption.generateHashedPwd(password));
			 if(user_list!=null && user_list.size()>0){
				 User user=user_list.get(0);
				 user.setLastLoginDevice(deviceID);
				 user.setLastLoginTime(new Date());
				 user.setLastLoginIP(request.getLocalAddr());
				 user.setIsLogin("true");
				 userRep.save(user);
				 return new JsonResponse("success"); 
			 }
			 return new JsonResponse("error");
		 }else{		 //second time login
			 List<User> user_list=userRep.findOneUserByEmail(email);
			 if(user_list!=null && user_list.size()!=0){
				 User user=user_list.get(0);
				 if(deviceID.equals(user.getLastLoginDevice()))return new JsonResponse("success");
				 else return new JsonResponse("Please enter password");
			 }
			 else return new JsonResponse("Please register first");
		 }
		
	 }
}
