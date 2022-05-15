package ru.veryprosto.carservice.model;

import javax.persistence.*;

@Entity
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_model_id")
    private Long id;

    @Column(name = "car_model_name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_mark_id")
    private CarMark carMark;

    public CarModel() {
    }

    public CarModel(String name, CarMark carMark) {
        this.name = name;
        this.carMark = carMark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarMark getCarMark() {
        return carMark;
    }

    public void setCarMark(CarMark carMark) {
        this.carMark = carMark;
    }
}
