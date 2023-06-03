package com.jsp.librarymanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.librarymanagement.dto.HistoryOfBooks;

public class HistoryOfBookDao {
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("rushali");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction=entityManager.getTransaction();
    
    public HistoryOfBooks addHistory(HistoryOfBooks historyOfBooks) {
    	entityTransaction.begin();
    	entityManager.persist(historyOfBooks);
    	entityTransaction.commit();
    	return historyOfBooks;
    	
    }
    
    public List<HistoryOfBooks> getAllHistory(){
    	String sql = "select s from HistoryOfBooks s";
    	Query query = entityManager.createQuery(sql);
    	return query.getResultList();
    }
    
    public void deleteHistory(int id) {
          HistoryOfBooks historyOfBooks = entityManager.find(HistoryOfBooks.class, id);
          entityTransaction.begin();
          entityManager.remove(historyOfBooks);
          entityTransaction.commit();
    }
    
    public HistoryOfBooks getHistoryById(int id) {
    HistoryOfBooks historyOfBooks =	entityManager.find(HistoryOfBooks.class, id);
    return historyOfBooks;
    }

}
