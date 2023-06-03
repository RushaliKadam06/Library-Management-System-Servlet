package com.jsp.librarymanagement.service;

import java.util.List;

import com.jsp.librarymanagement.dao.HistoryOfBookDao;
import com.jsp.librarymanagement.dao.LibrarianDao;
import com.jsp.librarymanagement.dto.Books;
import com.jsp.librarymanagement.dto.HistoryOfBooks;
import com.jsp.librarymanagement.dto.Librarian;
import com.jsp.librarymanagement.dto.Student;


public class LibrarianService {
	
	LibrarianDao librarianDao=new LibrarianDao();
	HistoryOfBookService historyOfBookService=new HistoryOfBookService();
	HistoryOfBooks historyOfBooks=new HistoryOfBooks();
	
	public Librarian saveLibrarian(Librarian librarian) {
		if(librarian!=null) {
			Librarian librarian2 = librarianDao.saveLibrarian(librarian);
			return librarian2;
		}else {
			return null;
		}
	}
	
	public void deleteLibrarian(int id) {
		if(id>0) {
			librarianDao.deleteLibrarian(id);
		}else {
			System.out.println("Invalid Student Id");
		}
	}
	
	public Librarian getLibrarianById(int id) {
		if(id>0) {
			Librarian librarian= librarianDao.getLibrarianById(id);
			return librarian;
		}else {
			return null;
		}
	}
	
	public Librarian updateLibrarianName(int id,String name) {
		Librarian librarian= librarianDao.getLibrarianById(id);
		 librarian.setLibrarianName(name);
		 Librarian librarian2 = librarianDao.updateLibrarian(librarian);
		if(librarian2!=null) {
		 return librarian2;
		}else {
			return null;
		}
	 }
	
	public Librarian updateLibrarianStatus(int id,String status) {
		Librarian librarian= librarianDao.getLibrarianById(id);
		 librarian.setStatus(status);
		 Librarian librarian2 = librarianDao.updateLibrarian(librarian);
		if(librarian2!=null) {
		 return librarian2;
		}else {
			return null;
		}
	 }
	
	public Librarian updateLibrarianContact(int id,String contact) {
		Librarian librarian= librarianDao.getLibrarianById(id);
		 librarian.setContactNo(contact);
		 Librarian librarian2 = librarianDao.updateLibrarian(librarian);
		if(librarian2!=null) {
		 return librarian2;
		}else {
			return null;
		}
	 }
	
	public Librarian updateLibrarianEmail(int id,String email) {
		Librarian librarian= librarianDao.getLibrarianById(id);
		 librarian.setLibrarianEmail(email);
		 Librarian librarian2 = librarianDao.updateLibrarian(librarian);
		if(librarian2!=null) {
		 return librarian2;
		}else {
			return null;
		}
	 }
	
	public List<Librarian> getAllLibrarians(){
		 List<Librarian> librarians = librarianDao.getAllLibrarian();
		 return librarians;
	 }
	
	public Books issueBook(int bookId,int stuId) {
	   BookService bookService=new BookService();
	   Books book = bookService.getBookById(bookId);
	   
	   StudentService studentService=new StudentService();
	   Student student = studentService.getStudentById(stuId);
	   
	   book.setStudent(student);
	   bookService.updateBookStudent(student, bookId);
	   historyOfBooks.setBooks(book);
	   historyOfBooks.setStudent(student);
	   HistoryOfBooks historyOfBooks1 = historyOfBookService.addHistory(historyOfBooks, book, student);
	   if(historyOfBooks1.getBooks()!=null) {
		   return historyOfBooks1.getBooks();
	   }else {
		   return null;
	   }
	   
	   
	}
	
	public void returnBooks(int histId,int stuId) {
		   StudentService studentService=new StudentService();
		   Student student = studentService.getStudentById(stuId);
		   student.setBooks(null);
		   studentService.updateStudentBookList(stuId);
		   HistoryOfBookService historyOfBookService=new HistoryOfBookService();
		   historyOfBookService.deleteHistory(histId);
		   
	}
	
	

}


