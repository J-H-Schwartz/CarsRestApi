package com.carsRestApi.CarsRestApi.repository;

import com.carsRestApi.CarsRestApi.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsDB extends JpaRepository<Car, Integer> {
}
