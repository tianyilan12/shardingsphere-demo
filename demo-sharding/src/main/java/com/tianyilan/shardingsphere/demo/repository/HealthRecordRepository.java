package com.tianyilan.shardingsphere.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.tianyilan.shardingsphere.demo.entity.HealthRecord;

@Mapper
public interface HealthRecordRepository extends BaseRepository<HealthRecord, Long> {

}
