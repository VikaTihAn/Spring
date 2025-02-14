package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImp implements CarService {

    private List<Car> carsList = new ArrayList<>();

    {
        carsList.add(new Car("model1", 1995, "red"));
        carsList.add(new Car("model2", 2000, "blue"));
        carsList.add(new Car("model3", 1999, "green"));
        carsList.add(new Car("model4", 1991, "black"));
        carsList.add(new Car("model5", 1996, "white"));
    }

    @Override
    public List<Car> getCars(int count) {
        if(count >= 5) {
            return carsList;
        }
        else return carsList.subList(0, count);
    }
}
