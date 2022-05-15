package ru.veryprosto.carservice.model;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    private String car_gov_number;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_model_id")
    private CarModel car_model;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer owner;

    private String car_year;
    private String car_color;
    private String car_body;
    private String car_engine_type;
    private String car_engine_capacity;
    private String car_drive;
    private String car_transmission;
    private String car_vin;
    private String note;
    private Boolean car_conditioner;
    private Boolean car_abs;
    private Boolean car_esp;
    private Boolean car_light_sensor;
    private Boolean car_rain_sensor;

    private String filename;

    public Car() {
    }

    public Car(String car_gov_number) {
        this.car_gov_number = car_gov_number;
    }

    public String getOwnerName() {
        return owner != null ? owner.getUsername() : "<No owner>";
    }

    public String getCar_gov_number() {
        return car_gov_number;
    }

    public void setCar_gov_number(String car_gov_number) {
        this.car_gov_number = car_gov_number;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public CarModel getCar_model() {
        return car_model;
    }

    public void setCar_model(CarModel car_model) {
        this.car_model = car_model;
    }

    public String getCar_year() {
        return car_year;
    }

    public void setCar_year(String car_year) {
        this.car_year = car_year;
    }

    public String getCar_color() {
        return car_color;
    }

    public void setCar_color(String car_color) {
        this.car_color = car_color;
    }

    public String getCar_body() {
        return car_body;
    }

    public void setCar_body(String car_body) {
        this.car_body = car_body;
    }

    public String getCar_engine_type() {
        return car_engine_type;
    }

    public void setCar_engine_type(String car_engine_type) {
        this.car_engine_type = car_engine_type;
    }

    public String getCar_engine_capacity() {
        return car_engine_capacity;
    }

    public void setCar_engine_capacity(String car_engine_capacity) {
        this.car_engine_capacity = car_engine_capacity;
    }

    public String getCar_drive() {
        return car_drive;
    }

    public void setCar_drive(String car_drive) {
        this.car_drive = car_drive;
    }

    public String getCar_transmission() {
        return car_transmission;
    }

    public void setCar_transmission(String car_transmission) {
        this.car_transmission = car_transmission;
    }

    public String getCar_vin() {
        return car_vin;
    }

    public void setCar_vin(String car_vin) {
        this.car_vin = car_vin;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getCar_conditioner() {
        return car_conditioner;
    }

    public void setCar_conditioner(Boolean car_conditioner) {
        this.car_conditioner = car_conditioner;
    }

    public Boolean getCar_abs() {
        return car_abs;
    }

    public void setCar_abs(Boolean car_abs) {
        this.car_abs = car_abs;
    }

    public Boolean getCar_esp() {
        return car_esp;
    }

    public void setCar_esp(Boolean car_esp) {
        this.car_esp = car_esp;
    }

    public Boolean getCar_light_sensor() {
        return car_light_sensor;
    }

    public void setCar_light_sensor(Boolean car_light_sensor) {
        this.car_light_sensor = car_light_sensor;
    }

    public Boolean getCar_rain_sensor() {
        return car_rain_sensor;
    }

    public void setCar_rain_sensor(Boolean car_rain_sensor) {
        this.car_rain_sensor = car_rain_sensor;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public CarMark getCarMark(){
        return getCar_model().getCarMark();
    }
}
