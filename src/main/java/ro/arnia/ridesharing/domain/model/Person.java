package ro.arnia.ridesharing.domain.model;

//import org.springframework.data.mongodb.core.mapping.Document;

//@Document(collection="Persons")
public class Person extends BaseEntity {

    private String user;
    private String firstName;
    private String lastName;
    private String password;
    private String phone;
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