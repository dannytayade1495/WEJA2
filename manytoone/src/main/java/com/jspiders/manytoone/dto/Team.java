package com.jspiders.manytoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Team {

	@Id
	private int id;
	private String name;
	private String country;

}
