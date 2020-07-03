package com.tianyilan.shardingsphere.demo.entity;

public class HealthLevel {
	
	Long levelId;
	String levelName;
	
	public HealthLevel(Long levelId, String levelName) {
		this.levelId = levelId;
		this.levelName = levelName;		
	}
	
	public Long getLevelId() {
		return levelId;
	}
	public void setLevelId(Long levelId) {
		this.levelId = levelId;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

}
