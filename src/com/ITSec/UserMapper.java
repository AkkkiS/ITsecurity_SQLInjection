package com.ITSec;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<Users> {


	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		Users user = new Users();
		user.setUserId(rs.getLong("USERID"));
		user.setUserName(rs.getString("USERNAME"));
		user.setUserPassword(rs.getString("USERPASSWORD"));
		return user;
	}
}