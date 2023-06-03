package com.jsp.librarymanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.librarymanagement.dto.Librarian;


public class LibrarianDao {
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("rushali");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction=entityManager.getTransaction();
    
    public Librarian saveLibrarian(Librarian librarian) {
    	entityTransaction.begin();
    	entityManager.persist(librarian);
    	entityTransaction.commit();
    	return librarian;
    }
    
    public void deleteLibrarian(int id) {
    	Librarian librarian = entityManager.find(Librarian.class, id);
    	entityTransaction.begin();
    	entityManager.remove(librarian);
    	entityTransaction.commit();
    	
    }
    
    public Librarian updateLibrarian(Librarian librarian) {
    	entityTransaction.begin();
    	entityManager.merge(librarian);
    	entityTransaction.commit();
    	return librarian;
    }
    public Librarian getLibrarianById(int id) {
    	Librarian librarian = entityManager.find(Librarian.class, id);
    	return librarian;
    }
    
    public List<Librarian> getAllLibrarian(){
		String sql="select s from Librarian s";
		Query query = entityManager.createQuery(sql);
		List<Librarian> librarians = query.getResultList();
		return librarians;
	}
    
    
    

}
