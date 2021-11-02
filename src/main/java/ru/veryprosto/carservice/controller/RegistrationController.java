package ru.veryprosto.carservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.veryprosto.carservice.model.Role;
import ru.veryprosto.carservice.model.Worker;
import ru.veryprosto.carservice.repos.WorkerRepo;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private WorkerRepo workerRepo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addWorker(Worker worker, Map<String, Object> model) {
        Worker workerFromDb = workerRepo.findByUsername(worker.getUsername());

        if (workerFromDb != null) {
            model.put("message", "Worker exists!");
            return "registration";
        }

        worker.setFired(false);
        worker.setRoles(Collections.singleton(Role.WORKER));
        workerRepo.save(worker);

        return "redirect:/login";
    }
}