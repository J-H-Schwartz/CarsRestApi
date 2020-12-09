package com.carsRestApi.CarsRestApi.service;

import com.carsRestApi.CarsRestApi.dao.CarDAO;
import com.carsRestApi.CarsRestApi.model.Car;
import org.springframework.stereotype.Service;

import java.util.Dictionary;

@Service
public class CarsService {

    private static final CarDAO carDAO = new CarDAO();

    public Dictionary<Integer, Car> getCars() {
        return carDAO.findAll();
    }

    public int createCar(Car car) {
        return carDAO.create(car);
    }

    public boolean updateCar(Car car) {
        return carDAO.update(car);
    }

    public boolean deleteCar(Car car) {
        return carDAO.delete(car);
    }
}
