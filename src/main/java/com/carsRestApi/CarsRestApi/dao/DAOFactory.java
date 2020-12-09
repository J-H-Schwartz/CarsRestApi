package com.carsRestApi.CarsRestApi.dao;


import com.carsRestApi.CarsRestApi.model.Car;

public class DAOFactory {

    public static DAO<Car> getCarDAO() {
        return new CarDAO();
    }
}