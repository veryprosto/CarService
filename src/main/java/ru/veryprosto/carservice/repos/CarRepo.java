package ru.veryprosto.carservice.repos;

import org.springframework.data.repository.CrudRepository;
import ru.veryprosto.carservice.model.Car;

import java.util.List;

public interface CarRepo extends CrudRepository<Car, Long> {
    List<Car> findByGovNumber(String govNumber);
}
