package com.jsp.librarymanagement.service;

import java.util.List;
import com.jsp.librarymanagement.dao.AdminDao;
import com.jsp.librarymanagement.dto.Admin;
import com.jsp.librarymanagement.dto.Librarian;



public class AdminService {
	
	AdminDao adminDao=new AdminDao();
	
	public Admin saveAdmin(Admin admin) {
		if(admin!=null) {
			Admin admin2 = adminDao.saveAdmin(admin);
			return admin2;
		}else {
			return null;
		}
	}
	
	public void deleteAdmin(int id) {
		if(id>0) {
			 adminDao.deleteAdmin(id);
		}else {
			System.out.println("Invalid Admin Id");
		}
	}
	
	public Admin getAdminById(int id) {
		if(id>0) {
			Admin admin2 = adminDao.getAdminById(id);
			return admin2;
		}else {
			return null;
		}
	}
	
	 public Admin updateAdminName(int id,String name) {
		 Admin admin = adminDao.getAdminById(id);
		 admin.setAdminName(name);
		 Admin admin2 = adminDao.updateAdmin(admin);
		if(admin2!=null) {
		 return admin2;
		}else {
			return null;
		}
	 }
	 
	 public Admin updateAdminEmail(int id,String email) {
		 Admin admin = adminDao.getAdminById(id);
		 admin.setAdminEmail(email);
		 Admin admin2 = adminDao.updateAdmin(admin);
		if(admin2!=null) {
		 return admin2;
		}else {
			return null;
		}
	 }
	 
	 public void viewAllUnapprovedLibrarian(int liId){
	        
			LibrarianService librarianService=new LibrarianService();
		    List<Librarian> librarians  = librarianService.getAllLibrarians();
			for(Librarian bM:librarians) {
				if(bM.getStatus().compareToIgnoreCase("Unapproved")==0) {
					bM.setStatus("Approved");
					Librarian librarian = librarianService.updateLibrarianStatus(liId, bM.getStatus());
					if(librarian!=null) {
						System.out.println("Librarian is approved");
					}
				}
					
				}
			}
	 
	 
	 
	 

}
