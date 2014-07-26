package com.easylearnjava.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.easylearnjava.dto.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {

		User userObj = new User(rs.getInt("user_id"), rs.getString("user_name"),
				rs.getString("user_password"));
		return userObj;
	}

}
