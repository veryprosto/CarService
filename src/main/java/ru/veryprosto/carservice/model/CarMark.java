package ru.veryprosto.carservice.model;

import javax.persistence.*;

@Entity
public class CarMark {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_mark_id")
    private Integer id;

    @Column(name = "car_mark_name")
    private String name;

    public CarMark() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
