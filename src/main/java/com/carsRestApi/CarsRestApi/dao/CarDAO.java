package com.carsRestApi.CarsRestApi.dao;

import com.carsRestApi.CarsRestApi.model.Car;
import com.carsRestApi.CarsRestApi.repository.CarsDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CarDAO {

    private final CarsDB carsDB;

    @Autowired
    public CarDAO(CarsDB carsDB)
    {
        this.carsDB = carsDB;
    }

    public List<Car> create(Car car) {
        carsDB.save(car);
        return carsDB.findAll();
    }

    public List<Car> update(Car car) {
        carsDB.save(car);
        System.out.println(carsDB.findAll());
        return carsDB.findAll();
    }

    public List<Car> delete(Car car) {
        carsDB.delete(car);
        return carsDB.findAll();
    }

    public List<Car> findAll() {
        return carsDB.findAll();
    }

    public Car findById(Integer id) {
        Optional<Car> car_opt = carsDB.findById(id);
        return car_opt.orElse(null);
    }
}
