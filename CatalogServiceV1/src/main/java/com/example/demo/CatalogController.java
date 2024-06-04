package com.example.demo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.repo.CatalogRepo;

import jakarta.transaction.Transactional;

@RestController
@Service
@Transactional
public class CatalogController 
{
	@Autowired
	CatalogRepo catalogrepo;
	@RequestMapping("/test")
	public String GetTest()
	{
		return "Test catalog demo api";
	}
	
	@RequestMapping("/get")
	public List<Object> getUseCatalog()
	{
		List<Object> list=new LinkedList<>();
		Object obj=new Product("Laptop","Desc..",78000.0f);
		list.add(new Product("Keboard","Keyboard",1500.0f));
		list.add(new Product("Battery","Batter..",2000.0f));
		list.add("USB");
		return list;
	}

}
