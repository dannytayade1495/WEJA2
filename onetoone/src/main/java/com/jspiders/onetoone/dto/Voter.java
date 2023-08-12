package com.jspiders.onetoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Voter {

	@Id
	private int id;
	private String name;
	private String address;
	@OneToOne
	@JoinColumn
	private VotingCard votingCard;

}
