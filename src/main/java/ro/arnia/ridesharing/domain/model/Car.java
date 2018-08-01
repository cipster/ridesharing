package ro.arnia.ridesharing.domain.model;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Validated
public class Car extends BaseEntity{

    @NotNull
    @Size( min = 2, max = 100, message = "Size 2<X<10")
    private String brand;

    @NotNull
    @Size( min = 1, max = 100)
    private String model;


    @NotNull
    @Size( min = 7, max = 100)
    private String licensePlate;

    @NotNull
    @Size( min = 4, max = 4)
    private int year;

    @NotNull
    @Size( min = 1, max = 2)
    private int available;

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

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }




}
