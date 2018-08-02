package ro.arnia.ridesharing.domain.model;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.lang.annotation.Annotation;

public class Car extends BaseEntity implements Annotation {

    @NotBlank
    private String model;
    @NotBlank
    private String brand;
    private String licensePlate;
    private Integer year;
    private Integer availableSeats;

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
