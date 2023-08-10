package com.jspiders.manytoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytoone.dto.Player;
import com.jspiders.manytoone.dto.Team;

public class PlayerDao {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	private static void openConnection() {
		entityManagerFactory = 
				Persistence.createEntityManagerFactory("player");
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
		
		Player player1 = new Player();
		player1.setId(1);
		player1.setName("Virat");
		player1.setJerseyNumber(18);
		player1.setAge(34);
		
		Player player2 = new Player();
		player2.setId(2);
		player2.setName("Rohit");
		player2.setJerseyNumber(45);
		player2.setAge(38);
		
		Player player3 = new Player();
		player3.setId(3);
		player3.setName("Hardik");
		player3.setJerseyNumber(33);
		player3.setAge(30);
		
		Team team = new Team();
		team.setId(1);
		team.setName("Team A");
		team.setCountry("India");
		
		player1.setTeam(team);
		player2.setTeam(team);
		player3.setTeam(team);
		
		entityManager.persist(team);
		entityManager.persist(player1);
		entityManager.persist(player2);
		entityManager.persist(player3);

		entityTransaction.commit();
		closeConnection();

	}

}
