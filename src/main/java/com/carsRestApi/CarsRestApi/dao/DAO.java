package com.carsRestApi.CarsRestApi.dao;


import com.carsRestApi.CarsRestApi.model.Car;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Dictionary;

public abstract class DAO<T> {

    protected Connection conn;
    protected String filePath;

    public DAO() {
    }

    public DAO(Connection conn) {
        this.conn = conn;
    }

    public DAO(String filePath) {
        this.filePath = filePath;
    }

    public abstract int create(T object);

    public abstract boolean update(T object);

    public abstract boolean delete(T object);

    public abstract Dictionary<Integer, T> findAll();
}
