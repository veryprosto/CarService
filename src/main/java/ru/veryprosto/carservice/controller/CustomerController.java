package ru.veryprosto.carservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.veryprosto.carservice.model.Customer;
import ru.veryprosto.carservice.model.Role;
import ru.veryprosto.carservice.repos.CustomerRepo;

import java.util.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    final CustomerRepo customerRepo;

    public CustomerController(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @GetMapping
    public String customerList(Model model) {
        List<Customer> customers = customerRepo.findAll();
        model.addAttribute("customers", customers);
        return "customerList";
    }

    @GetMapping("{customer}")
    public String customerEditForm(@PathVariable Customer customer, Model model) {
        model.addAttribute("customer", customer);
        model.addAttribute("roles", Role.values());
        return "customerEdit";
    }

    @GetMapping("/add")
    public String customerAddForm() {
        return "addCustomer";
    }

    @PostMapping("/add")
    public String addCustomer(
            @RequestParam String username,
            @RequestParam Map<String, String> form) {
        Customer customer = new Customer();

        customer.setUsername(username);
        customer.setPassword(form.get("password"));
        customer.setFullName(form.get("fullname"));
        customer.setPhone(form.get("phone"));
        customer.setEmail(form.get("email"));
        customer.setAddress(form.get("address"));
        customer.setInn(form.get("inn"));
        customer.setKpp(form.get("kpp"));

        customerRepo.save(customer);

        return "redirect:/customer";
    }

    @PostMapping
    public String customerSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("customerId") Customer customer) {

        customer.setUsername(username);
        customer.setPassword(form.get("password"));
        customer.setFullName(form.get("fullname"));
        customer.setPhone(form.get("phone"));
        customer.setEmail(form.get("email"));
        customer.setAddress(form.get("address"));
        customer.setInn(form.get("inn"));
        customer.setKpp(form.get("kpp"));

        customerRepo.save(customer);

        return "redirect:/customer";
    }

    @PostMapping("/delete")
    public String customerDelete(@RequestParam("customerId") Customer customer) {
        customerRepo.delete(customer);
        return "redirect:/customer";
    }
}
