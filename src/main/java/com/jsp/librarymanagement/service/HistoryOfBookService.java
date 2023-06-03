package com.jsp.librarymanagement.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.jsp.librarymanagement.dao.HistoryOfBookDao;
import com.jsp.librarymanagement.dto.Books;
import com.jsp.librarymanagement.dto.HistoryOfBooks;
import com.jsp.librarymanagement.dto.Student;

public class HistoryOfBookService {
	
	HistoryOfBookDao historyOfBookDao=new HistoryOfBookDao();
	
	public HistoryOfBooks addHistory(HistoryOfBooks historyOfBooks,Books book,Student student) {
		if(historyOfBooks!=null) {
			LocalDateTime dt = LocalDateTime.now();
			DateTimeFormatter df = DateTimeFormatter.ISO_LOCAL_DATE;
			String dateOfIssue=dt.format(df);
			LocalDate localDate =LocalDate.now().plusDays(15);
			DateTimeFormatter df1 = DateTimeFormatter.ISO_LOCAL_DATE;
			String dateOfReturn=localDate.format(df1);
			historyOfBooks.setDateOfIssue(dateOfIssue);
			historyOfBooks.setDateOfReturn(dateOfReturn);
			historyOfBooks.setBooks(book);
			historyOfBooks.setStudent(student);
			return historyOfBookDao.addHistory(historyOfBooks);
			
			
		}else {
			return null;
		}
	}
	
	 public List<HistoryOfBooks> getAllHistory(){
		 return historyOfBookDao.getAllHistory();
	 }
	 
	 public boolean deleteHistory(int id) {
		
		 if(id>0) {
		 HistoryOfBooks historyOfBooks = historyOfBookDao.getHistoryById(id);
		 historyOfBookDao.deleteHistory(id);
		 return true;
		 }else {
			 return false;
		 }
		 
	 }
		 

}
