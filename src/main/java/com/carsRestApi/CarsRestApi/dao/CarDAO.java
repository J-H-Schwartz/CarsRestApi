package com.carsRestApi.CarsRestApi.dao;

import com.carsRestApi.CarsRestApi.model.Car;
import org.springframework.stereotype.Repository;

import java.util.Dictionary;
import java.util.Hashtable;

@Repository
public class CarDAO extends DAO<Car> {

    public static Dictionary<Integer, Car> cars = new Hashtable<>();
    public static Integer cars_id = 2;

    static {
        cars.put(0, new Car(0, "Clio", "Renault", "Rouge"));
        cars.put(1, new Car(1, "Megane", "Renault", "Jaune"));
        cars.put(2, new Car(2, "308", "Peugeot", "Anthracite"));
    }

    public CarDAO() {
        super();
    }

    @Override
    public int create(Car car) {
        cars_id += 1;
        car.setId(cars_id);
        cars.put(cars_id, car);
        return cars_id;
    }

    @Override
    public boolean update(Car car) {
        cars.get(car.getId()).setBrand(car.getBrand());
        cars.get(car.getId()).setModel(car.getModel());
        cars.get(car.getId()).setColor(car.getColor());
        return true;
    }

    @Override
    public boolean delete(Car car) {
        cars.remove(car.getId());
        System.out.println(cars);
        return true;
    }

    @Override
    public Dictionary<Integer, Car> findAll() {
        return cars;
    }

}
