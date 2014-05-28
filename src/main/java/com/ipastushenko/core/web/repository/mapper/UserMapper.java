package com.ipastushenko.core.web.repository.mapper;

import com.ipastushenko.core.web.model.User;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * user mapper
 */
public interface UserMapper {
    @Select("SELECT * FROM users WHERE id=#{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password")
    })
    User find(@Param("id") Long id);

    @Select("SELECT * FROM users WHERE username=#{username}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password")
    })
    User findByUsername(@Param("username") String username);
}
