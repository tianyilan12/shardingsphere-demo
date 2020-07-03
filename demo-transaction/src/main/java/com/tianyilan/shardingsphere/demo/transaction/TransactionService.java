package com.tianyilan.shardingsphere.demo.transaction;

import java.sql.SQLException;

public interface TransactionService {
	
	public void processWithXA() throws SQLException ;
	
	public void processWithBASE() throws SQLException;

}
