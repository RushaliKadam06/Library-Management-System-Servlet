package com.jsp.librarymanagement.service;

import java.util.List;

import com.jsp.librarymanagement.dao.BooksDao;

import com.jsp.librarymanagement.dto.Books;
import com.jsp.librarymanagement.dto.Student;

public class BookService {
	
	BooksDao booksDao=new BooksDao();
	
	public Books saveBook(Books book) {
		if(book!=null) {
			Books book2 = booksDao.saveBook(book);
			return book2;
		}else {
			return null;
		}
	}
	
	public void deleteBook(int id) {
		if(id>0) {
			 booksDao.deleteBook(id);
		}else {
			System.out.println("Invalid Book Id");
		}
	}
	
	public Books getBookById(int id) {
		if(id>0) {
			Books book2 = booksDao.getBookById(id);
			return book2;
		}else {
			return null;
		}
	}
	
	public Books updateBookName(int id,String name) {
		Books book = booksDao.getBookById(id);
		 book.setBookName(name);
		 Books book2 = booksDao.updateBook(book);
		if(book2!=null) {
		 return book2;
		}else {
			return null;
		}
	 }
	
	public Books updateBookAuthor(int id,String author) {
		Books book = booksDao.getBookById(id);
		 book.setBookAuthor(author);
		 Books book2 = booksDao.updateBook(book);
		if(book2!=null) {
		 return book2;
		}else {
			return null;
		}
	 }
	
	public Books updateBookStudent(Student student,int bid) {
		Books book = booksDao.getBookById(bid);
		 book.setStudent(student);
		 Books book2 = booksDao.updateBook(book);
		if(book2!=null) {
		 return book2;
		}else {
			return null;
		}
	 }
	
	public Books updateBookStudentNull(int bid) {
		Books book = booksDao.getBookById(bid);
		 book.setStudent(null);
		 Books book2 = booksDao.updateBook(book);
		if(book2!=null) {
		 return book2;
		}else {
			return null;
		}
	 }
	
	public Books updateBookAddition(int id,String addition) {
		Books book = booksDao.getBookById(id);
		 book.setBookAddition(addition);
		 Books book2 = booksDao.updateBook(book);
		if(book2!=null) {
		 return book2;
		}else {
			return null;
		}
	 }
	
	public List<Books> getAllBooks(){
		List<Books> books = booksDao.getAllBooks();
		
		return books;
	}

}
