package ru.veryprosto.carservice.repos;

import org.springframework.data.repository.CrudRepository;
import ru.veryprosto.carservice.model.Car;

public interface CarRepo extends CrudRepository<Car, String> {
    //Car findByCar_gov_number(String car_gov_number);
}
