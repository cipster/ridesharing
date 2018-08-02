package ro.arnia.ridesharing.domain.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.annotation.Annotation;


public class Car extends BaseEntity implements Annotation {


    private String brand;
    private String model;
    private String licensePlate;
    private int year;
    private int availableSeats;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int available) {
        this.availableSeats = available;
    }


    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
