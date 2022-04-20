package ru.veryprosto.carservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.veryprosto.carservice.model.Car;
import ru.veryprosto.carservice.model.Car_mark;
import ru.veryprosto.carservice.model.Car_model;
import ru.veryprosto.carservice.model.Customer;
import ru.veryprosto.carservice.repos.CarMarkRepo;
import ru.veryprosto.carservice.repos.CarRepo;
import ru.veryprosto.carservice.repos.CustomerRepo;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarRepo carRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CarMarkRepo carMarkRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping
    public String carList(Model model) {
        Iterable<Car> cars = carRepo.findAll();

        model.addAttribute("cars", cars);

        return "carList";
    }

    @GetMapping("/add")
    public String carAddForm(Model model) {
        List<Customer> customers = customerRepo.findAll();
        Iterable<Car_mark> marks = carMarkRepo.findAll();

        model.addAttribute("customers", customers);
        model.addAttribute("marks", marks);
        return "addCar";
    }

    @PostMapping("/add")
    public String addCar(
            @RequestParam String car_gov_number,
            @RequestParam String car_mark,
            //@RequestParam Car_model car_model,
            @RequestParam String car_color,
            @RequestParam String car_year,
            @RequestParam String car_transmission,
            @RequestParam String car_engine_capacity,
            @RequestParam String car_engine_type,
            @RequestParam String car_vin,
            @RequestParam String car_body,
            @RequestParam String car_drive,
            @RequestParam Customer owner,
            @RequestParam Boolean car_conditioner,
            @RequestParam Boolean car_abs,
            @RequestParam Boolean car_esp,
            @RequestParam Boolean car_light_sensor,
            @RequestParam Boolean car_rain_sensor,
            @RequestParam String note,
            Map<String, Object> model,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        Car car = new Car(car_gov_number);
        //car.setCar_model(car_model);
        car.setCar_color(car_color);
        car.setCar_year(car_year);
        car.setCar_transmission(car_transmission);
        car.setCar_engine_capacity(car_engine_capacity);
        car.setCar_engine_type(car_engine_type);
        car.setCar_vin(car_vin);
        car.setCar_body(car_body);
        car.setCar_drive(car_drive);
        car.setOwner(owner);
        car.setCar_conditioner(car_conditioner);
        car.setCar_abs(car_abs);
        car.setCar_esp(car_esp);
        car.setCar_light_sensor(car_light_sensor);
        car.setCar_rain_sensor(car_rain_sensor);
        car.setNote(note);

        /*if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            car.setFilename(resultFilename);
        }//это все для фотки машины*/

        carRepo.save(car);

        Iterable<Car> cars = carRepo.findAll();

        model.put("cars", cars);
        return "redirect:/car";
    }
}
