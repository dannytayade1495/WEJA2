package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.EmployeeDTO;

public class EmployeeDAO2 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	private static void openConnection() {

		entityManagerFactory = 
				Persistence.createEntityManagerFactory("employee");
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
		EmployeeDTO emp1 = new EmployeeDTO();
		emp1.setId(10);
		emp1.setName("Ramesh");
		emp1.setEmail("ramesh@gmail.com");
		emp1.setContact(9876543210l);
		emp1.setAddress("Mumbai");

		entityManager.persist(emp1);

		EmployeeDTO emp2 = new EmployeeDTO();
		emp2.setId(20);
		emp2.setName("Suresh");
		emp2.setEmail("suresh@gmail.com");
		emp2.setContact(9876543211l);
		emp2.setAddress("Pune");

		entityManager.persist(emp2);

		entityTransaction.commit();
		closeConnection();

	}

}
