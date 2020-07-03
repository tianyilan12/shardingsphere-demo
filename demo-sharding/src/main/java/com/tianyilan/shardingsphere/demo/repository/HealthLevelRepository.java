package com.tianyilan.shardingsphere.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.tianyilan.shardingsphere.demo.entity.HealthLevel;

@Mapper
public interface HealthLevelRepository extends BaseRepository<HealthLevel, Long> {

}
