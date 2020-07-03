package com.tianyilan.shardingsphere.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.tianyilan.shardingsphere.demo.entity.HealthTask;

@Mapper
public interface HealthTaskRepository extends BaseRepository<HealthTask, Long> {

}
