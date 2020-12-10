package com.carsRestApi.CarsRestApi.service;

import com.carsRestApi.CarsRestApi.dao.CarDAO;
import com.carsRestApi.CarsRestApi.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

@Service
public class CarsService {

    private final CarDAO carDAO;

    @Autowired
    public CarsService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public Dictionary<Integer, Car> getCars() {
        List<Car> carsList = carDAO.findAll();
        return this.listToDict(carsList);
    }

    public Dictionary<Integer, Car> createCar(Car car) {

        List<Car> carsList = carDAO.create(car);
        return this.listToDict(carsList);
    }

    public Dictionary<Integer, Car> updateCar(Car car) {
        List<Car> carsList = carDAO.update(car);
        return this.listToDict(carsList);
    }

    public Dictionary<Integer, Car> deleteCar(Integer id) {
        Car car = this.getCarById(id);
        List<Car> carsList = carDAO.delete(car);
        return this.listToDict(carsList);
    }

    public Car getCarById(Integer id) {
        return carDAO.findById(id + 1);
    }

    private Dictionary<Integer, Car> listToDict(List<Car> carsList){
        Dictionary<Integer, Car> carsDict = new Hashtable<>();
        for (Car listed_car:carsList){
            carsDict.put(listed_car.getId(), listed_car);
        }
        return carsDict;
    }
}
