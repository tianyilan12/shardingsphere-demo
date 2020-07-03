package com.tianyilan.shardingsphere.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tianyilan.shardingsphere.demo.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void testProcessUsers() throws Exception {
		userService.processUsers();
	}
}
