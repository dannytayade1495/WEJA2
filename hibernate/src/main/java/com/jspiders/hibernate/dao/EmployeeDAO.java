package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.EmployeeDTO;

public class EmployeeDAO {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	private static void openConnection() {
		entityManagerFactory = Persistence.
				createEntityManagerFactory("employee");
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
		
		EmployeeDTO emp = new EmployeeDTO();
		emp.setId(1);
		emp.setName("M S Dhoni");
		emp.setEmail("mahi7@gmail.com");
		emp.setContact(9876543210L);
		emp.setAddress("Dange Chowk");
		
		entityManager.persist(emp);
		
		entityTransaction.commit();
		closeConnection();
		
	}

}
