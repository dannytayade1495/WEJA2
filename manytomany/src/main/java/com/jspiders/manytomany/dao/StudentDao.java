package com.jspiders.manytomany.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytomany.dto.Course;
import com.jspiders.manytomany.dto.Student;

public class StudentDao {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("student");
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

		Student student1 = new Student();
		student1.setId(1);
		student1.setName("Rahul");
		student1.setEmail("rahul@gmail.com");
		student1.setAddress("Pune");

		Student student2 = new Student();
		student2.setId(2);
		student2.setName("Rakesh");
		student2.setEmail("rakesh@gmail.com");
		student2.setAddress("Kolhapur");

		Course course1 = new Course();
		course1.setId(1);
		course1.setName("Core Java");
		course1.setFees(15000.00);

		Course course2 = new Course();
		course2.setId(2);
		course2.setName("SQL");
		course2.setFees(10000.00);

		List<Course> courses1 = new ArrayList<>();
		courses1.add(course2);

		List<Course> courses2 = new ArrayList<>();
		courses2.add(course1);
		courses2.add(course2);

		student1.setCourses(courses1);
		student2.setCourses(courses2);

		entityManager.persist(course1);
		entityManager.persist(course2);
		entityManager.persist(student1);
		entityManager.persist(student2);

		entityTransaction.commit();
		closeConnection();

	}

}
