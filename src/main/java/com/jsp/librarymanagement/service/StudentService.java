package com.jsp.librarymanagement.service;

import java.security.PublicKey;
import java.util.List;
import com.jsp.librarymanagement.dao.StudentDao;
import com.jsp.librarymanagement.dto.Books;
import com.jsp.librarymanagement.dto.Student;

public class StudentService {
	
	StudentDao studentDao=new StudentDao();
	
	public Student saveStudent(Student student) {
		if(student!=null) {
			Student student2 =studentDao.saveStudent(student);
			return student2;
		}else {
			return null;
		}
	}
	
	public void deleteStudent(int id) {
		if(id>0) {
			studentDao.deleteStudent(id);
		}else {
			System.out.println("Invalid Student Id");
		}
	}
	
	public Student getStudentById(int id) {
		if(id>0) {
			Student student= studentDao.getStudentById(id);
			return student;
		}else {
			return null;
		}
	}
	
	 public Student updateStudentName(int id,String name) {
		 Student student = studentDao.getStudentById(id);
		 student.setStudentName(name);
		Student student2= studentDao.updateStudent(student);
		if(student2!=null) {
		 return student2;
		}else {
			return null;
		}
	 }
	 
	 public Student updateStudentContactNo(int id,String no) {
		 Student student = studentDao.getStudentById(id);
		 student.setContactNo(no);
		Student student2= studentDao.updateStudent(student);
		if(student2!=null) {
		 return student2;
		}else {
			return null;
		}
	 }
	 
	 public Student updateStudentEmail(int id,String email) {
		 Student student = studentDao.getStudentById(id);
		 student.setStudentEmail(email);
		Student student2= studentDao.updateStudent(student);
		if(student2!=null) {
		 return student2;
		}else {
			return null;
		}
	 }
	 
	 public Student updateStudentBookList(int id) {
		 Student student = studentDao.getStudentById(id);
		 student.setBooks(null);
		Student student2= studentDao.updateStudent(student);
		if(student2!=null) {
		 return student2;
		}else {
			return null;
		}
	 }
	 
	 public List<Student> getAllStudent(){
		 List<Student> students = studentDao.getAllStudent();
		 return students;
	 }
	 
	 public boolean borrowBook(int bookId,int stuId) {
		 LibrarianService librarianService=new LibrarianService();
		 Books b = librarianService.issueBook(bookId, stuId);
		 if(b!=null) {
			 return true;
		 }else {
			 return false;
		 }
	 }

}
