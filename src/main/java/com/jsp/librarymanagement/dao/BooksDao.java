package com.jsp.librarymanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.jsp.librarymanagement.dto.Books;


public class BooksDao {
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("rushali");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction=entityManager.getTransaction();
    
    public Books saveBook(Books book) {
    	entityTransaction.begin();
    	entityManager.persist(book);
    	entityTransaction.commit();
    	return book;
    }
    
    public void deleteBook(int id) {
    	Books book = entityManager.find(Books.class, id);
    	entityTransaction.begin();
    	entityManager.remove(book);
    	entityTransaction.commit();
    	
    }
    
    public Books updateBook(Books book) {
    	entityTransaction.begin();
    	entityManager.merge(book);
    	entityTransaction.commit();
    	return book;
    }
    
    public Books getBookById(int id) {
    	Books book = entityManager.find(Books.class, id);
    	return book;
    }
    
    public List<Books> getAllBooks(){
		String sql="select s from Books s";
		Query query = entityManager.createQuery(sql);
		List<Books> books = query.getResultList();
		return books;
	}

}
