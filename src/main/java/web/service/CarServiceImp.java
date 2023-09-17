package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.models.Car;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarServiceImp implements web.service.CarService {

    CarDao carDao;

    @Autowired
    CarServiceImp(CarDao carDao) {
        this.carDao = carDao;
    }


    @Override
    @Transactional
    public void add(Car car) {
        carDao.add(car);

    }

    @Override
    @Transactional
    public List<Car> listCar(int count) {
        return carDao.listCar(count);
    }

    @Override
    @Transactional
    public List<Car> listAllCars() {
        return carDao.listAllCars();
    }
}
