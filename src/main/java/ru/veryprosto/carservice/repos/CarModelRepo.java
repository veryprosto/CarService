package ru.veryprosto.carservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.veryprosto.carservice.model.CarModel;

public interface CarModelRepo extends JpaRepository<CarModel, Long> {
    CarModel findByName(String name);
}
