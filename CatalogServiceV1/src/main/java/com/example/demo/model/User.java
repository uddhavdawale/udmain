package com.example.demo.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Component
@Entity
public class User 
{
	@Id
	@Column(name= "bid")
	@SequenceGenerator(name = "bm_id_seq", sequenceName = "bm_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bm_id_seq" )
	Long uid;
	
	@Column(name= "username")
	String username;

	@Column(name= "password")
	String password;
	
	public User() {}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}
	
}
