package com.tianyilan.shardingsphere.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.tianyilan.shardingsphere.demo.entity.User;

@Mapper
public interface UserRepository extends BaseRepository<User, Long> {

}
