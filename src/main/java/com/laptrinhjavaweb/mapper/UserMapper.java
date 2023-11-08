package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.RoleModel;
import com.laptrinhjavaweb.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet resultset) {

		try {
			UserModel user = new UserModel();
			user.setId(resultset.getLong("id"));
			user.setUserName(resultset.getString("username"));
			user.setPassword(resultset.getString("password"));
			user.setFullName(resultset.getString("fullname"));
			user.setStatus(resultset.getInt("status"));
			try {
				RoleModel role= new RoleModel();
				role.setCode(resultset.getString("code"));
				role.setName(resultset.getString("name"));
				user.setRole(role);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
