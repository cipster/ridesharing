package ro.arnia.ridesharing.domain.model;

//import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import javax.validation.Validator;
import javax.validation.constraints.NotNull;

//@Document(collection="Persons")
public class Person extends BaseEntity {

    @NotNull(message = "Name cannot be null")
    private String user;

    @NotNull(message = "Name cannot be null")
    private String firstName;

    @NotNull(message = "Name cannot be null")
    private String lastName;

    @NotNull(message = "Name cannot be null")
    private String password;

    @NotNull(message = "Name cannot be null")
    private String phone;

    @NotNull(message = "Name cannot be null")
    private String email;
    public String role;

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role=role;
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


    public String getuser() {

        return this.user;
    }

    public void setuser(String user) {

        this.user = user;
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