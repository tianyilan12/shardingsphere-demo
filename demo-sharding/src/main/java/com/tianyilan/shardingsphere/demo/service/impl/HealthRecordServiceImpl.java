package com.tianyilan.shardingsphere.demo.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianyilan.shardingsphere.demo.entity.HealthRecord;
import com.tianyilan.shardingsphere.demo.entity.HealthTask;
import com.tianyilan.shardingsphere.demo.repository.HealthRecordRepository;
import com.tianyilan.shardingsphere.demo.repository.HealthTaskRepository;
import com.tianyilan.shardingsphere.demo.service.HealthRecordService;

@Service
public class HealthRecordServiceImpl implements HealthRecordService {	

	@Autowired
	private HealthRecordRepository healthRecordRepository;	

	@Autowired
	private HealthTaskRepository healthTaskRepository;

	@Override
	public void processHealthRecords() throws SQLException{
		insertHealthRecords();
	}
	
	private List<Long> insertHealthRecords() throws SQLException {
        List<Long> result = new ArrayList<>(10);
        for (Long i = 1L; i <= 10; i++) {
        	HealthRecord healthRecord = insertHealthRecord(i);
            insertHealthTask(i, healthRecord);
            result.add(healthRecord.getRecordId());
        }
        return result;
    }	
    
    private HealthRecord insertHealthRecord(final Long i) throws SQLException {
    	HealthRecord healthRecord = new HealthRecord();
    	healthRecord.setUserId(i);
    	healthRecord.setLevelId(i % 5);
    	healthRecord.setRemark("Remark" + i);
        healthRecordRepository.addEntity(healthRecord);
        return healthRecord;
    }
    
    private void insertHealthTask(final Long i, final HealthRecord healthRecord) throws SQLException {
    	HealthTask healthTask = new HealthTask();
    	healthTask.setRecordId(healthRecord.getRecordId());
    	healthTask.setUserId(i);
    	healthTask.setTaskName("TaskName" + i);
    	healthTaskRepository.addEntity(healthTask);
    }
}
