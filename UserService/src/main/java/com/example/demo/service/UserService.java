package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class UserService 
{
	@Autowired
	UserRepo repo;
	public void UserService() {
		User user=new User("udawale","password");
	repo.save(user);
	}
	
}
