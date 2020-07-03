package com.tianyilan.shardingsphere.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.tianyilan.shardingsphere.demo.entity.User;

public interface UserService {
	
	public void processUsers() throws SQLException;
	
	public List<User> getUsers() throws SQLException;

}
