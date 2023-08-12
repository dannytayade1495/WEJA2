package com.jspiders.onetoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class VotingCard {
	
	@Id
	private int id;
	private String cardNumber;
	private String dateOfIssue;
	@OneToOne(mappedBy = "votingCard")
	private Voter voter;

}
