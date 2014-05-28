package com.ipastushenko.core.repository.mapper;

import com.ipastushenko.core.model.User;
import com.ipastushenko.core.model.UserDetailsImpl;
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

    @Select("SELECT u.username as u_username, u.password as u_password, r.name as r_name, r.id as r_id " +
            "FROM users u " +
            "   LEFT OUTER JOIN users_roles ur ON u.id = ur.user_id " +
            "   LEFT OUTER JOIN roles r ON ur.role_id = r.id " +
            "WHERE u.username=#{username}")
    @ResultMap(value = "UserDetailsMap")
    UserDetailsImpl findByUsername(@Param("username") String username);
}
