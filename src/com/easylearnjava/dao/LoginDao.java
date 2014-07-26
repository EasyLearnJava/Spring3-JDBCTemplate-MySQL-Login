package com.easylearnjava.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.easylearnjava.exception.ServiceException;

@Repository
public class LoginDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}	
	
	public String getUserPassword(String userName) {

		String password = null;
		try {
			String sql = "Select user_password from user where user_name = ?";
			
			password = (String) jdbcTemplate.queryForObject(sql,
					new Object[] {userName}, String.class);
			
		} catch (Exception ex) {
			ex.printStackTrace(); 
			throw new ServiceException("global.exception.message");
		}
		return password;
	}

}
