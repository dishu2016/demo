package com.example.demo.mapper;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.User;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}