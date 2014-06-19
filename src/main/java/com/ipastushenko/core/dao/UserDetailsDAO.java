package com.ipastushenko.core.dao;

import com.ipastushenko.core.dao.exception.DAOException;
import com.ipastushenko.core.model.UserDetailsImpl;

/**
 * user details DAO
 */
public interface UserDetailsDAO {
    /**
     * find user details by username
     * @param username username of user
     * @return user details if user exist else null
     * @throws DAOException data access exception
     */
    public UserDetailsImpl findByUsername(String username) throws DAOException;

    /**
     * update user details
     * @param userDetails details of user
     * @throws DAOException data access exception
     */
    public void update(UserDetailsImpl userDetails) throws DAOException;
}
