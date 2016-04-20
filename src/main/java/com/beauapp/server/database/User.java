package com.beauapp.server.database;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.beauapp.server.utilities.Status;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "email", unique=true)
	private String email;
	
	private String username;

	private String password;
	
	private String lastLoginDevice;
	
	private String lastLoginIP;
	
	private String isLogin;
	
	@Temporal(TemporalType.DATE)
	private Date created_at;
	
	@Temporal(TemporalType.DATE)
	private Date lastLoginTime;
	
	@Enumerated(EnumType.STRING)
	private Status status;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastLoginDevice() {
		return lastLoginDevice;
	}

	public void setLastLoginDevice(String lastLoginDevice) {
		this.lastLoginDevice = lastLoginDevice;
	}

	public String getLastLoginIP() {
		return lastLoginIP;
	}

	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
	}

	public String getIsLogin() {
		return isLogin;
	}

	public void setIsLogin(String isLogin) {
		this.isLogin = isLogin;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}



