package ru.veryprosto.carservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.veryprosto.carservice.model.Role;
import ru.veryprosto.carservice.model.Worker;
import ru.veryprosto.carservice.repos.WorkerRepo;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/worker")
@PreAuthorize("hasAuthority('ADMIN')")
public class WorkerController {

    final WorkerRepo workerRepo;

    public WorkerController(WorkerRepo workerRepo) {
        this.workerRepo = workerRepo;
    }

    @GetMapping
    public String workerList(Model model) {
        List<Worker> workers = workerRepo.findAll();
        model.addAttribute("workers", workers);
        return "workerList";
    }

    @GetMapping("{worker}")
    public String workerEditForm(@PathVariable Worker worker, Model model) {
        model.addAttribute("worker", worker);
        model.addAttribute("roles", Role.values());
        return "workerEdit";
    }

    @GetMapping("/add")
    public String workerAddForm(Model model) {
        model.addAttribute("roles", Role.values());
        return "workerCreate";
    }

    @PostMapping("/add")
    public String workerCreate(
            @RequestParam String username,
            @RequestParam Map<String, String> form) {
        Worker worker = new Worker();

        worker.setUsername(username);
        worker.setPassword(form.get("password"));
        worker.setFullName(form.get("fullname"));
        worker.setPosition(form.get("position"));
        worker.setPhone(form.get("phone"));
        worker.setSalary(form.get("salary"));
        worker.setInn(form.get("inn"));
        worker.setFired(form.get("fired") != null);

        Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());

        Set<Role> roleSet = EnumSet.of(Role.WORKER);//без этого не удавалось getRoles()
        worker.setRoles(roleSet);

        worker.getRoles().clear();
        System.out.println("asdsdf");
        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                worker.getRoles().add(Role.valueOf(key));
            }
        }

        workerRepo.save(worker);

        return "redirect:/worker";
    }

    @PostMapping
    public String workerSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form, //тут все реквестпарамы и их не требуется отдельно объявлять
            @RequestParam("workerId") Worker worker) {

        worker.setUsername(username);
        worker.setPassword(form.get("password"));
        worker.setFullName(form.get("fullname"));
        worker.setPosition(form.get("position"));
        worker.setPhone(form.get("phone"));
        worker.setSalary(form.get("salary"));
        worker.setFired(form.get("fired") != null);

        Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());

        worker.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                worker.getRoles().add(Role.valueOf(key));
            }
        }

        workerRepo.save(worker);

        return "redirect:/worker";
    }

    @PostMapping("/delete")
    public String workerDelete(@RequestParam("workerId") Worker worker) {
        workerRepo.delete(worker);
        return "redirect:/worker";
    }
}
