package ro.arnia.ridesharing.domain.model;

//import org.springframework.data.mongodb.core.mapping.Document;

//@Document(collection="Persons")
public class Person extends BaseEntity {


    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}