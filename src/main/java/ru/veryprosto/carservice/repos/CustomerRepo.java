package ru.veryprosto.carservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.veryprosto.carservice.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Customer findByUsername(String username);
}
