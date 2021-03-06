package com.carsRestApi.CarsRestApi.controller;

import com.carsRestApi.CarsRestApi.service.CarsService;
import com.carsRestApi.CarsRestApi.model.Car;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import java.util.Dictionary;
import java.util.Hashtable;



@Controller
public class MainController {
    private final CarsService cars;

    @Autowired
    public MainController(CarsService cars){
        this.cars = cars;
    }


    @RequestMapping(value = {"/cars"}, method = RequestMethod.GET)
    @ResponseBody
    Dictionary<Integer, Car> getCars() {
        return cars.getCars();
    }

    @RequestMapping(value = {"/cars/{id}"}, method = RequestMethod.GET)
    @ResponseBody
    Car getById(@PathVariable("id") Integer id) {
        return cars.getCarById(id);
    }

    @RequestMapping(value = {"/cars"}, method = RequestMethod.POST)
    @ResponseBody
    Dictionary<Integer, Car> addCar(@RequestBody String body) {
        JSONObject json = new JSONObject(body);
        Dictionary<Integer, Car> carsDict = new Hashtable<>();
        Car car = new Car(json.getString("model"), json.getString("brand"), json.getString("color"));
        return cars.createCar(car);
    }

    @RequestMapping(value = {"/cars/{id}"}, method = RequestMethod.PUT)
    @ResponseBody
    Dictionary<Integer, Car> updateById(@RequestBody String body, @PathVariable("id") int id) {
        JSONObject json = new JSONObject(body);
        Car car = new Car(id, json.getString("model"), json.getString("brand"), json.getString("color"));
        return cars.updateCar(car);
    }

    @RequestMapping(value = {"/cars/{id}"}, method = RequestMethod.DELETE)
    @ResponseBody
    Dictionary<Integer, Car> deleteById(@PathVariable("id") Integer id) {
        return cars.deleteCar(id);
    }
}
