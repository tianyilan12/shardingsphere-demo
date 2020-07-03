package com.tianyilan.shardingsphere.demo;

import java.io.IOException;
import java.sql.SQLException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.tianyilan.shardingsphere.demo.transaction.TransactionService;

@ComponentScan("com.tianyilan.shardingsphere.demo")
@MapperScan(basePackages = "com.tianyilan.shardingsphere.demo.repository")
@SpringBootApplication(exclude = JtaAutoConfiguration.class)
public class DemoApplication {
	
    public static void main(final String[] args) throws SQLException, IOException {
        try (ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args)) {
        	
        	TransactionService transactionService = applicationContext.getBean(TransactionService.class);
//        	transactionService.processWithXA();
        	transactionService.processWithBASE();
        }
    }
}
