package com.tianyilan.shardingsphere.demo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.tianyilan.shardingsphere.demo.entity.EncryptUser;
import com.tianyilan.shardingsphere.demo.hint.HintService;
import com.tianyilan.shardingsphere.demo.service.EncryptUserService;
import com.tianyilan.shardingsphere.demo.service.HealthLevelService;
import com.tianyilan.shardingsphere.demo.service.HealthRecordService;
import com.tianyilan.shardingsphere.demo.service.UserService;

@ComponentScan("com.tianyilan.shardingsphere.demo")
@MapperScan(basePackages = "com.tianyilan.shardingsphere.demo.repository")
@SpringBootApplication
public class DemoApplication {
	
    public static void main(final String[] args) throws SQLException, IOException {
        try (ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args)) {
        	UserService userService = applicationContext.getBean(UserService.class);
        	userService.processUsers();        	
        	userService.getUsers(); 
        	
//        	HealthLevelService healthLevelService = applicationContext.getBean(HealthLevelService.class);
//        	healthLevelService.processLevels();
//        	
//        	HealthRecordService healthRecordService = applicationContext.getBean(HealthRecordService.class);
//        	healthRecordService.processHealthRecords(); 
        	
//        	HintService hintService = applicationContext.getBean(HintService.class);
//        	hintService.processWithHintValueForShardingDatabases();
//        	hintService.processWithHintValueForShardingDatabasesAndTables();
//        	hintService.processWithHintValueMaster();
        }
    }
}
