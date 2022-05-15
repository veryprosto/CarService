package ru.veryprosto.carservice.repos;

import org.springframework.data.repository.CrudRepository;
import ru.veryprosto.carservice.model.CarMark;

public interface CarMarkRepo extends CrudRepository<CarMark, Integer> {
    CarMark findByName(String name);
}
