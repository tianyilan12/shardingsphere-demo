package com.tianyilan.shardingsphere.demo.hint;

import org.apache.shardingsphere.api.hint.HintManager;

public class HintManagerHelper {

	static void initializeHintManagerForShardingDatabasesAndTables(final HintManager hintManager) {
		hintManager.addDatabaseShardingValue("health_record", 3L);
		hintManager.addTableShardingValue("health_record", 2L);
	}

	static void initializeHintManagerForShardingDatabases(final HintManager hintManager) {			
		hintManager.setDatabaseShardingValue(1L);
	}

	static void initializeHintManagerForMaster(final HintManager hintManager) {
		hintManager.setMasterRouteOnly();
	}
}
