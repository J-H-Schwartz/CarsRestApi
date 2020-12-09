package com.carsRestApi.CarsRestApi.repository;

import com.carsRestApi.CarsRestApi.model.Car;
import org.springframework.stereotype.Repository;

import java.util.Dictionary;
import java.util.Hashtable;

@Repository
public class TestRepository {

    public static Dictionary<Integer, Car> cars = new Hashtable<>();
    public static Integer cars_id = 2;

    static {
        cars.put(0, new Car(0, "Clio", "Renault", "Rouge"));
        cars.put(1, new Car(1, "Megane", "Renault", "Jaune"));
        cars.put(2, new Car(2, "308", "Peugeot", "Anthracite"));
    }

    public static Integer getCars_id() {
        return cars_id;
    }

    public static void setCars_id(Integer cars_id) {
        TestRepository.cars_id = cars_id;
    }
}
