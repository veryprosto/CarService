package ru.veryprosto.carservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car_mark {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer car_mark_id;

    private String car_mark_name;

    public Car_mark() {
    }

    public Integer getCar_mark_id() {
        return car_mark_id;
    }

    public void setCar_mark_id(Integer car_mark_id) {
        this.car_mark_id = car_mark_id;
    }

    public String getCar_mark_name() {
        return car_mark_name;
    }

    public void setCar_mark_name(String car_mark_name) {
        this.car_mark_name = car_mark_name;
    }
}
