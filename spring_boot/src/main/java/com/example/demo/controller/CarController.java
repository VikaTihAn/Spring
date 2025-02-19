package com.example.demo.controller;

import com.example.demo.model.Car;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getCars() {
       return carService.getCars();
    }

    @PostMapping
    public Car saveCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    @GetMapping("/{model}")
    public Optional<Car> getCarByModel(@PathVariable String model) {
        return carService.getCarByModel(model);
    }

    @GetMapping("/user_id/{user_id}")
    public List<Car> getCarsByUserId(@PathVariable(value = "user_id") Long id) {
        return carService.getCarsByUserId(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCarById(@PathVariable Long id) {
        carService.deleteCarById(id);
    }

    @PutMapping("/update/{id}")
    public void updateCar(@PathVariable Long id, @RequestBody Car newCar) {
        carService.updateCar(id, newCar);
    }
}
