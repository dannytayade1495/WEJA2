package com.jspiders.onetoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class AadharCard {

	@Id
	private int id;
	private long aadharNumber;
	private String dateOfIssue;

}
