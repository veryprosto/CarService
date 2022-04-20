package ru.veryprosto.carservice.repos;

import org.springframework.data.repository.CrudRepository;
import ru.veryprosto.carservice.model.Car_mark;

public interface CarMarkRepo extends CrudRepository<Car_mark, Integer> {
}
