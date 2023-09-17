package web.service;

import web.models.Car;

import java.util.List;

public interface CarService {
    void add(Car car);
    List<Car> listCar(int count);
    List<Car> listAllCars();
}
