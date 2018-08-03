package ro.arnia.ridesharing.domain.model;

//import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

//@Document(collection="Persons")
public class Person extends BaseEntity {

    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String phone;
    private String email;
    private typeUser type;
    private Set<Rating> ratings;
    private Set<Car> ownedCars;
    private Set<Ride> rideHistory;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public typeUser getType() {
        return type;
    }

    public void setType(typeUser type) {
        this.type = type;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

    public Set<Car> getOwnedCars() {
        return ownedCars;
    }

    public void setOwnedCars(Set<Car> ownedCars) {
        this.ownedCars = ownedCars;
    }

    public Set<Ride> getRideHistory() {
        return rideHistory;
    }

    public void setRideHistory(Set<Ride> rideHistory) {
        this.rideHistory = rideHistory;
    }

    public void addCar() {

    }

    public void removeCar() {

    }

    public void modifyCar() {

    }

    public String getFirstName() {

        return this.firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return this.lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }


    public String getPassword() {

        return this.password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getPhone() {

        return this.phone;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    public String getEmail() {

        return this.email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    enum typeUser {
        DRIVER, PASSENGER;
    }


}