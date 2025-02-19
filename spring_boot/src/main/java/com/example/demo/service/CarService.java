package com.example.demo.service;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

   public Car saveCar(Car car) {
        return carRepository.save(car);
   }

   public List<Car> getCars() {
        return carRepository.findAll();
   }

   public Optional<Car> getCarByModel(String model) {
       return carRepository.findByModel(model);
   }

   public List<Car> getCarsByUserId(Long id) {
        return carRepository.findCarsByUserId(id);
   }

   public void deleteCarById(Long id) {
        carRepository.deleteById(id);
   }

   public void updateCar(Long id, Car newCar) {
        Optional<Car> car = carRepository.findById(id);
        if(car.isPresent()) {
            Car car1 = car.get();
            car1.setModel(newCar.getModel());
            car1.setSeries(newCar.getSeries());
            car1.setColor(newCar.getColor());
            carRepository.save(car1);
        }
        else {
            try {
                throw new IllegalAccessException();
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
   }
}
