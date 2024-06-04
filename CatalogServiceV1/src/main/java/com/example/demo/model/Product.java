package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Product {
	
	@Id
	@Column(name= "pid")
	@SequenceGenerator(name = "pr_id_seq", sequenceName = "pr_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pr_id_seq" )
	Long pid;
	String PName;
	String pdesc;
	float price;
	
	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getPName() {
		return PName;
	}

	public void setPName(String pName) {
		PName = pName;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Product() {}

	public Product(String pName, String pdesc, float price) {
		super();
		PName = pName;
		this.pdesc = pdesc;
		this.price = price;
	}
	

}
