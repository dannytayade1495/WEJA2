package com.jspiders.manytomany.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Product {

	@Id
	private int id;
	private String name;
	private double price;
	@ManyToMany(mappedBy = "products")
	private List<Customer> customers;

}
