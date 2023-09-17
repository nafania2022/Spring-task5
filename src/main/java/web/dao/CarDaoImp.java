package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.models.Car;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class CarDaoImp implements CarDao {

    private  SessionFactory sessionFactory;

    @Autowired
    CarDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public List<Car> listAllCars() {
        List<Car> cars = sessionFactory.getCurrentSession()
                .createQuery("from Car")
                .getResultList();
        return cars;
    }

    @Override
    public List<Car> listCar(int count) {
        List<Car> cars = listAllCars().stream()
                .limit(count)
                .collect(Collectors.toList());
        return cars;
    }
}
