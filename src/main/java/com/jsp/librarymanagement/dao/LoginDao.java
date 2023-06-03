package com.jsp.librarymanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.librarymanagement.dto.Login;

public class LoginDao {
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("rushali");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public Login saveLogin(Login login) {
		entityTransaction.begin();
		entityManager.persist(login);
		entityTransaction.commit();
		return login;
	}
	
	public Login updateLogin(Login login) {
		entityTransaction.begin();
		entityManager.merge(login);
		entityTransaction.commit();
		return login;
	}
	
    public Login getLoginById(String id) {
    	 return entityManager.find(Login.class, id);
    }
}
