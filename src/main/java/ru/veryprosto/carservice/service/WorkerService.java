package ru.veryprosto.carservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.veryprosto.carservice.model.Worker;
import ru.veryprosto.carservice.repos.WorkerRepo;

@Service
public class WorkerService implements UserDetailsService {
    @Autowired
    private WorkerRepo workerRepo;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Worker worker = workerRepo.findByUsername(login);
        if (worker == null) {
            throw new UsernameNotFoundException("Unknown worker with login: " + login);
        }
        return worker;
    }
}
