package com.tianyilan.shardingsphere.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.tianyilan.shardingsphere.demo.entity.EncryptUser;

public interface EncryptUserService {
	
	public void processEncryptUsers() throws SQLException;
	
	public List<EncryptUser> getEncryptUsers() throws SQLException;

}
