package com.jspiders.onetomany.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Company {

	@Id
	private int id;
	private String name;
	private String email;
	private String address;
	@OneToMany
	private List<Employee> employees;

}
