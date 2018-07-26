package ro.arnia.ridesharing.controllers;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import ro.arnia.ridesharing.domain.model.Person;
import ro.arnia.ridesharing.domain.model.repository.PersonRepository;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RegisterController {
    private JSONObject jsonObj;
    private Person person;
    private PersonRepository repo;
    private String user;
    private String firstName;
    private String lastName;
    private String password;
    private String phone;
    private String email;


    RegisterController(PersonRepository repository){
        this.jsonObj = null;
        this.person = null;
        this.repo = repository;
        this.user = "";
        this.firstName = "";
        this.lastName = "";
        this.password = "";
        this.phone = "";
        this.email = "";
    }

    @RequestMapping(value="/registerServer", method=RequestMethod.POST)
    public String registerPost(@RequestBody String request) throws JSONException {
        this.jsonObj = new JSONObject(request);
        this.user = this.jsonObj.getString("user");
        this.firstName = this.jsonObj.getString("firstName");
        this.lastName = this.jsonObj.getString("lastName");
        this.password = this.jsonObj.getString("password");
        this.phone = this.jsonObj.getString("phone");
        this.email = this.jsonObj.getString("email");

        this.person = new Person();
        this.person.setuser(this.user);
        this.person.setFirstName(this.firstName);
        this.person.setLastName(this.lastName);
        this.person.setPassword(this.password);
        this.person.setPhone(this.phone);
        this.person.setEmail(this.email);

        this.repo.save(person);

        return "{\"user\":\"" + this.user
                + "\",\"password\":\"" + this.password
                + "\",\"firstName\":\"" + this.firstName
                + "\",\"lastName\":\"" + this.lastName
                + "\",\"phone\":\"" + this.phone
                + "\",\"email\":\"" + this.email
                + "\"}";
    }

    /* @RequestMapping(value = "/log", method = RequestMethod.GET)
    public String loginGet() {

        return "{\"id\":\"2\",\"title\":\"Gigel\"}";
    }*/
}
