package com.tianyilan.shardingsphere.demo.hint;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.shardingsphere.api.hint.HintManager;
import org.springframework.stereotype.Service;

@Service
public class HintServiceImpl implements HintService {

	@Override
	public void processWithHintValueForShardingDatabases() throws SQLException, IOException {
		DataSource dataSource = DataSourceHelper.getDataSourceForShardingDatabases();
		try (HintManager hintManager = HintManager.getInstance();
				Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement()) {
			HintManagerHelper.initializeHintManagerForShardingDatabases(hintManager);

			ResultSet result = statement.executeQuery("select user_id, user_name from user");
			
			while (result.next()) {
				System.out.println(result.getLong(1) + ": " + result.getString(2));
            }
		}		
	}

	@Override
	public void processWithHintValueForShardingDatabasesAndTables() throws SQLException, IOException {
		DataSource dataSource = DataSourceHelper.getDataSourceForShardingDatabasesAndTables();
		try (HintManager hintManager = HintManager.getInstance();
				Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement()) {
			HintManagerHelper.initializeHintManagerForShardingDatabasesAndTables(hintManager);

			ResultSet result = statement.executeQuery("select record_id, user_id, remark from health_record");
			
			while (result.next()) {
				System.out.println(result.getLong(1) + ": " + result.getLong(2) + ": " + result.getString(3));
            }
		}		
	}

	@Override
	public void processWithHintValueMaster() throws SQLException, IOException {
		DataSource dataSource = DataSourceHelper.getDataSourceForMaster();
		try (HintManager hintManager = HintManager.getInstance();
				Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement()) {
			HintManagerHelper.initializeHintManagerForMaster(hintManager);

			ResultSet result = statement.executeQuery("select user_id, user_name from user");
			
			while (result.next()) {
				System.out.println(result.getLong(1) + ": " + result.getString(2));
            }
		}		
	}
}
