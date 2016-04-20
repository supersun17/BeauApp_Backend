package com.beauapp.server.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRep extends JpaRepository<User, Long> {

	 @Query("select u  from User u  where u.email = :email and  u.password=:pwd")
	List<User> findOneUser(@Param("email")String email,@Param("pwd")String pwd);
	 
	 @Query("select u  from User u  where u.email = :email")
	List<User> findOneUserByEmail(@Param("email")String email);
	
}
