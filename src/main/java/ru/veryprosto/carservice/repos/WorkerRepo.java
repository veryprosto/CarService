package ru.veryprosto.carservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.veryprosto.carservice.model.Worker;

public interface WorkerRepo extends JpaRepository<Worker, Long> {
    Worker findByUsername(String username);
}