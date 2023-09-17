package web.dao;

import web.models.Car;
import java.util.List;

public interface CarDao {
        void add(Car car);
        List<Car> listCar(int count);
        List<Car> listAllCars();
}
