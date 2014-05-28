package com.ipastushenko.core.web.service;

import org.postgresql.ds.PGPoolingDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * test service
 */
@Service
public class TestService {
    @Autowired
    private PGPoolingDataSource dataSource;

    public TestService() {
    }

    public PGPoolingDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(PGPoolingDataSource dataSource) {
        this.dataSource = dataSource;
    }
}
