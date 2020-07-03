package com.tianyilan.shardingsphere.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.tianyilan.shardingsphere.demo.entity.EncryptUser;

@Mapper
public interface EncryptUserRepository extends BaseRepository<EncryptUser, Long> {

}
