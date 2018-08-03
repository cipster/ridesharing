package ro.arnia.ridesharing.domain.model;

public class Car extends BaseEntity {

    private String model;
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

}
