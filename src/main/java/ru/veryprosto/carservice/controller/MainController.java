package ru.veryprosto.carservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.veryprosto.carservice.model.Car;
import ru.veryprosto.carservice.model.Worker;
import ru.veryprosto.carservice.repos.CarRepo;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class MainController {
    @Autowired
    private CarRepo carRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String greeting(Model model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {//required = false означает, что параметр не обязательный
        Iterable<Car> cars;

        if (filter != null && !filter.isEmpty()) {
            cars = carRepo.findByGovNumber(filter);
        } else {
            cars = carRepo.findAll();
        }

        model.addAttribute("cars", cars);
        model.addAttribute("filter", filter);
        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal Worker worker,
            @RequestParam String govNumber,
            @RequestParam String mark,
            Map<String, Object> model,
            @RequestParam("file") MultipartFile file
            ) throws IOException {

        Car car = new Car(govNumber, mark, worker);
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            car.setFilename(resultFilename);
        }

        carRepo.save(car);

        Iterable<Car> cars = carRepo.findAll();

        model.put("cars", cars);
        model.put("filter", "");
        return "main";
    }
}
