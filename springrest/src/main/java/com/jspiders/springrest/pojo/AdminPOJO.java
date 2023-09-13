package com.jspiders.springrest.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class AdminPOJO {

	@Id
	private String username;
	private String password;
}
