package com.ipastushenko.core.service;

import com.ipastushenko.core.dao.UserDetailsDAO;
import com.ipastushenko.core.dao.exception.DAOException;
import com.ipastushenko.core.model.UserDetailsImpl;
import com.ipastushenko.core.service.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * user details service
 */
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger log = Logger.getLogger(UserDetailsServiceImpl.class.getName());

    private UserDetailsDAO userDetailsDAO;

    private PlatformTransactionManager txManager;

    private DefaultTransactionDefinition txDefinition;

    public UserDetailsServiceImpl() {
        txDefinition = new DefaultTransactionDefinition();
        txDefinition.setName("txUserDetails");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetailsImpl userDetails = null;
        try {
            userDetails = userDetailsDAO.findByUsername(username);
            if (userDetails == null) {
                throw new UsernameNotFoundException("User " + username + " not found");
            }
        } catch (DAOException e) {
            log.error("Service exception: ", e);
            throw new UsernameNotFoundException("User " + username + " not found");
        }

        return userDetails;
    }

    public void update(UserDetailsImpl userDetails) throws ServiceException {
        if (userDetails == null) {
            log.error("Service exception: userDetails is null");
            throw new ServiceException();
        }
        if (userDetails.getId() == null) {
            log.error("Service exception: userDetails.id is null");
            throw new ServiceException();
        }
        TransactionStatus status = txManager.getTransaction(txDefinition);
        try {
            userDetailsDAO.update(userDetails);
            txManager.commit(status);
        } catch (DAOException e) {
            if (status != null) {
                txManager.rollback(status);
            }
            log.error("Service exception: ", e);
            throw new ServiceException();
        }
    }

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setUserDetailsDAO(UserDetailsDAO userDetailsDAO) {
        this.userDetailsDAO = userDetailsDAO;
    }
}
