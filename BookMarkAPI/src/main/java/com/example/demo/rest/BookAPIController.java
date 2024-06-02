package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookAPIController 
{
	@GetMapping("/get")
	public String getdata()
	{
		return "Welcome ..";
	}
	
	@PostMapping
	public String postProcess()
	{
		return "post data submitted ..";
	}
	
	
	@GetMapping("/delet")
	public String delet()
	{
		return "Data has been deleted..";
		
	}
	
}
