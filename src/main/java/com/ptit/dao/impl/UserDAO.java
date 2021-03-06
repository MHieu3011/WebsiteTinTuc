package com.ptit.dao.impl;

import java.util.List;

import com.ptit.dao.IUserDAO;
import com.ptit.mapper.impl.UserMapper;
import com.ptit.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

	@Override
	public UserModel findByUsernameAndPasswordAndStatus(String username, String password, Integer status) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user AS u");
		sql.append(" INNER JOIN role AS r ON r.id = u.roleid");
		sql.append(" WHERE username = ? AND password = ? AND status = ?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), username, password, status);
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public UserModel findByStament(String username, String password, Integer status) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user AS u");
		sql.append(" INNER JOIN role AS r ON r.id = u.roleid");
		sql.append(" WHERE username = ? AND password = ? AND status = ?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), "user", "C4CA4238A0B923820DCC509A6F75849B", 1);
		return users.isEmpty() ? null : users.get(0);
	}

}
