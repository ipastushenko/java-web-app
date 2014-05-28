package com.ipastushenko.core.repository.mapper;

import com.ipastushenko.core.model.User;
import org.apache.ibatis.annotations.*;

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
}
