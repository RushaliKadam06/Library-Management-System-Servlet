package com.jsp.librarymanagement.service;

import com.jsp.librarymanagement.dao.LoginDao;
import com.jsp.librarymanagement.dto.Login;

public class LoginService {
	
	LoginDao loginDao = new LoginDao();
	
	public Login saveLogin(Login login) {
		if(login!=null) {
			return loginDao.saveLogin(login);
		}else {
			return null;
		}
	}
	
	public Login getLoginById(String id) {
		if(id!=null) {
			return loginDao.getLoginById(id);
		}else {
			return null;
		}
	}
	
	public Login updateLoginPass(String id,String pass) {
		Login login = loginDao.getLoginById(id);
	if(login!=null) {
		login.setPassword(pass);
		return loginDao.updateLogin(login);
	}else {
		return null;
	}
	}

}
