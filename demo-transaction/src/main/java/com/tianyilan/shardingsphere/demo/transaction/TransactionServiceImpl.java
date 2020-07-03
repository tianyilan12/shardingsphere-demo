package com.tianyilan.shardingsphere.demo.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tianyilan.shardingsphere.demo.entity.HealthRecord;
import com.tianyilan.shardingsphere.demo.entity.HealthTask;

@Service
public class TransactionServiceImpl implements TransactionService {	

	static String sql_health_record_insert = "INSERT INTO health_record (user_id, level_id, remark) VALUES (?, ?, ?)";
	static String sql_health_task_insert = "INSERT INTO health_task (user_id, record_id, task_name) VALUES (?, ?, ?)";

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void processWithXA() throws SQLException {
		TransactionTypeHolder.set(TransactionType.XA);
		 
		insertHealthRecords();
	}

	@Override
	public void processWithBASE() throws SQLException {
		TransactionTypeHolder.set(TransactionType.BASE);
		 
		insertHealthRecords();
	}
	
	private List<Long> insertHealthRecords() throws SQLException {
		List<Long> result = new ArrayList<>(10);       
		jdbcTemplate.execute((ConnectionCallback<Object>) connection-> {
			connection.setAutoCommit(false);
			
        	try {        		
        		for (Long i = 1L; i <= 10; i++) {
        			HealthRecord healthRecord = createHealthRecord(i);   		   		
    	    		insertHealthRecord(healthRecord, connection);
    	    		
    	    		HealthTask healthTask = createHealthTask(i, healthRecord);
    	        	insertHealthTask(healthTask, connection);
    	        	
    	        	result.add(healthRecord.getRecordId());    	   
    	        	
    	        	//手工抛出异常
    	        	throw new SQLException("exception occur!");
                }        		
        		connection.commit();
        	} catch (final SQLException ex) {
        		connection.rollback();
                throw ex;
            }
	    	
			return connection;
	    });
		
		return result;
	}
	
	private HealthRecord createHealthRecord(Long i) {
		HealthRecord healthRecord = new HealthRecord();
    	healthRecord.setUserId(i);
    	healthRecord.setLevelId(i % 5);
    	healthRecord.setRemark("Remark" + i);	
    	
		return healthRecord;
	}
	
	private HealthTask createHealthTask(Long i, HealthRecord healthRecord) {
		HealthTask healthTask = new HealthTask();
    	healthTask.setRecordId(healthRecord.getRecordId());
    	healthTask.setUserId(i);
    	healthTask.setTaskName("TaskName" + i);
    	
    	return healthTask;
	}
    
    private void insertHealthRecord(HealthRecord healthRecord, Connection connection) throws SQLException {
    	try (PreparedStatement preparedStatement = connection.prepareStatement(sql_health_record_insert, Statement.RETURN_GENERATED_KEYS)) {
    		preparedStatement.setLong(1, healthRecord.getUserId());
            preparedStatement.setLong(2, healthRecord.getLevelId() % 5 );
            preparedStatement.setString(3, "Remark" + healthRecord.getUserId());
            preparedStatement.executeUpdate(); 
            
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                	healthRecord.setRecordId(resultSet.getLong(1));
                }
            }
    	}
    	
    }
    
    private void insertHealthTask(HealthTask healthTask, Connection connection) throws SQLException {    	
    	try (PreparedStatement preparedStatement = connection.prepareStatement(sql_health_task_insert, Statement.RETURN_GENERATED_KEYS)) {    		
        	preparedStatement.setLong(1, healthTask.getUserId());
            preparedStatement.setLong(2, healthTask.getRecordId());
            preparedStatement.setString(3, "TaskName" + healthTask.getUserId());
            preparedStatement.executeUpdate(); 
            
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                	healthTask.setTaskId(resultSet.getLong(1));
                }
            }
    	}  		
    }
    
	
	@Transactional
	@ShardingTransactionType(TransactionType.XA)  
	private List<Long> insertHealthRecords2() throws SQLException {
        List<Long> result = new ArrayList<>(10);       
        
        jdbcTemplate.execute((ConnectionCallback<Object>) connection-> {        	
        	for (Long i = 1L; i <= 10; i++) {
        		HealthRecord healthRecord = createHealthRecord(i);   		   		
	    		insertHealthRecord(healthRecord, connection);
	    		
	    		HealthTask healthTask = createHealthTask(i, healthRecord);
	        	insertHealthTask(healthTask, connection);
	        	
	        	result.add(healthRecord.getRecordId());    	        	
            }
	    	
			return connection;
	    });

        return result;
    }	
}
