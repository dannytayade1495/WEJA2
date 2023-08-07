package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.AadharCard;
import com.jspiders.hibernate.dto.Person;

public class PersonDao {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("person");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	private static void closeConnection() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction != null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}

	public static void main(String[] args) {

		openConnection();
		entityTransaction.begin();
		
		Person person = new Person();
		person.setId(1);
		person.setName("Rahul");
		person.setEmail("rahul123@gmail.com");
		
		AadharCard aadharCard = new AadharCard();
		aadharCard.setId(1);
		aadharCard.setAadharNumber(445536734587l);
		aadharCard.setDateOfIssue("01/06/2000");
		entityManager.persist(aadharCard);
		
		person.setAadharCard(aadharCard);
		
		entityManager.persist(person);

		entityTransaction.commit();
		closeConnection();

	}

}
