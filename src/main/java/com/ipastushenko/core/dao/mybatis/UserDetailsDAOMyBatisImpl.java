package com.ipastushenko.core.dao.mybatis;

import com.ipastushenko.core.dao.UserDetailsDAO;
import com.ipastushenko.core.dao.exception.DAOException;
import com.ipastushenko.core.model.UserDetailsImpl;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;

import java.sql.Timestamp;

/**
 * user details dao
 */
public class UserDetailsDAOMyBatisImpl extends SqlSessionDaoSupport implements UserDetailsDAO {
    private static final Logger log = Logger.getLogger(UserDetailsDAOMyBatisImpl.class.getName());

    public UserDetailsImpl findByUsername(String username) throws DAOException {
        try {
            return getSqlSession().selectOne(
                    "com.ipastushenko.core.dao.mybatis.mapper.UserDetailsMapper.findByUsername",
                    username
            );
        } catch (DataAccessException e) {
            log.error("Data access exception: ", e);
            throw new DAOException();
        }
    }

    public void update(UserDetailsImpl userDetails) throws DAOException {
        try {
            userDetails.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            getSqlSession().update("com.ipastushenko.core.dao.mybatis.mapper.UserDetailsMapper.update", userDetails);
        } catch (DataAccessException e) {
            log.error("Data access exception: ", e);
            throw new DAOException();
        }
    }
}
