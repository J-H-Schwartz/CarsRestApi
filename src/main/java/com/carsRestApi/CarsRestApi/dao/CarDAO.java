package com.carsRestApi.CarsRestApi.dao;

import com.carsRestApi.CarsRestApi.model.Car;
import com.carsRestApi.CarsRestApi.repository.TestRepository;

import java.util.Dictionary;

public class CarDAO {

    public CarDAO()
    {
        super();
    }

    public int create(Car car) {
        TestRepository.setCars_id(TestRepository.getCars_id() + 1);
        car.setId(TestRepository.getCars_id());
        TestRepository.cars.put(TestRepository.getCars_id(), car);
        return TestRepository.getCars_id();
    }

    public boolean update(Car car) {
        TestRepository.cars.get(car.getId()).setBrand(car.getBrand());
        TestRepository.cars.get(car.getId()).setModel(car.getModel());
        TestRepository.cars.get(car.getId()).setColor(car.getColor());
        return true;
    }

    public boolean delete(Car car) {
        TestRepository.cars.remove(car.getId());
        System.out.println(TestRepository.cars);
        return true;
    }

    public Dictionary<Integer, Car> findAll() {
        return TestRepository.cars;
    }

}
