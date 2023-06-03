package com.jsp.librarymanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.jsp.librarymanagement.dto.Admin;


public class AdminDao {
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("rushali");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction=entityManager.getTransaction();
    
    public Admin saveAdmin(Admin admin) {
    	entityTransaction.begin();
    	entityManager.persist(admin);
    	entityTransaction.commit();
    	return admin;
    }
    
    public void deleteAdmin(int id) {
    	Admin admin = entityManager.find(Admin.class, id);
    	entityTransaction.begin();
    	entityManager.remove(admin);
    	entityTransaction.commit();
    	
    }
    
    public Admin updateAdmin(Admin admin) {
    	entityTransaction.begin();
    	entityManager.merge(admin);
    	entityTransaction.commit();
    	return admin;
    }
    
    public Admin getAdminById(int id) {
    	Admin admin = entityManager.find(Admin.class, id);
    	return admin;
    }
    
    
}
