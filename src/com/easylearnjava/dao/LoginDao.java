package com.easylearnjava.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.easylearnjava.exception.ServiceException;

@Repository
public class LoginDao {

	@Autowired
	private JdbcTemplate templates;
	
	public String getUserPassword(String userName) {

		String password = null;
		try {
			String sql = "Select user_password from user where user_name = ?";
			
			password = (String) templates.queryForObject(sql,
					new Object[] {userName}, String.class);
			
		} catch (Exception ex) {
			ex.printStackTrace(); 
			throw new ServiceException("global.exception.message");
		}
		return password;
	}

}
