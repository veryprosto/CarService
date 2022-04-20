package ru.veryprosto.carservice.model;

import javax.persistence.*;

@Entity
public class Car_model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer car_model_id;

    private String car_model_name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_mark_id")
    private Car_mark car_mark;

    public Car_model() {
    }

    public Integer getCar_model_id() {
        return car_model_id;
    }

    public void setCar_model_id(Integer car_model_id) {
        this.car_model_id = car_model_id;
    }

    public String getCar_model_name() {
        return car_model_name;
    }

    public void setCar_model_name(String car_model_name) {
        this.car_model_name = car_model_name;
    }

    public Car_mark getCar_mark() {
        return car_mark;
    }

    public void setCar_mark(Car_mark car_mark) {
        this.car_mark = car_mark;
    }
}
