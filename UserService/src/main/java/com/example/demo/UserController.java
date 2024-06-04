package com.example.demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.UserConfig;
import com.example.demo.model.User;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class UserController 
{
	private int retry=0;
	@Autowired
	UserConfig userconfig;
	
	String baseusrl="";
	@RequestMapping(method = RequestMethod.GET,path = "/getmsg")
	public String userService()
	{
		return "User Service ";
	}
	@RequestMapping("/get/user/catalog")
	@Retry(name = "userService",fallbackMethod = "afterFailureMethod")
//	@CircuitBreaker(name = "UserService_callsCatalog", fallbackMethod = "afterFailureMethod")
	public Object getUSerCatalog()
	{
		System.out.println("retry Method .."+retry++);
		User user1=new User("udawale","password");
		User user2=new User("DD","password");
		Object ob=userconfig.getTemplate().getForObject("http://localhost:8081/get", Object.class);
		List<Object> list=(List<Object>) ob;
		list.add(user1);
		return list;
	}
	
	public Object afterFailureMethod(Exception e)
	{
		User user2=new User("Dummy","DummyPwd");
		List<Object> list=new LinkedList<>();
		list.add(new ArrayList<>().add("Dummy Resukt getting "));
		list.add(user2);
		return list;
		
	}

}
