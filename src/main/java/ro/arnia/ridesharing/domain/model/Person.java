package ro.arnia.ridesharing.domain.model;

//import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import java.util.Set;

//@Document(collection="Persons")
public class Person extends BaseEntity {

    enum typeUser
    {
        DRIVER, PASSENGER;
    }

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


    public String getuserName() {

        return this.userName;
    }

    public void setuser(String user) {

        this.userName = user;
    }


    public String  getPassword() {

        return this.password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getPhone() {

        return this.phone;
    }

    public void setPhone(String phone){

        this.phone = phone;
    }

    public String getEmail(){

        return this.email;
    }

    public void setEmail(String email){

        this.email = email;
    }





}