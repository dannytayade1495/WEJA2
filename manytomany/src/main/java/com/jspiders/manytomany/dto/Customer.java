package com.jspiders.manytomany.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Customer {

	@Id
	private int id;
	private String name;
	private String email;
	private String address;
	@ManyToMany
	@JoinTable
	(joinColumns = @JoinColumn(referencedColumnName = "id")
	, inverseJoinColumns = @JoinColumn
	(referencedColumnName = "id"))
	private List<Product> products;

}
