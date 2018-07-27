package ro.arnia.ridesharing.controllers;

import org.json.JSONException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.arnia.ridesharing.domain.model.Person;
import ro.arnia.ridesharing.domain.model.repository.PersonRepository;

import java.util.List;

@RestController
public class RegisterController {
    private List<Person> listPerson;
    private Person person;
    private PersonRepository repo;
<<<<<<< HEAD
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String phone;
    private String email;
=======
>>>>>>> fa27a06f344ac7534b04b697fa4f127ae28cc1cd


    RegisterController(PersonRepository repository){

        this.listPerson = null;
        this.person = null;
        this.repo = repository;
<<<<<<< HEAD
        this.username = "";
        this.firstName = "";
        this.lastName = "";
        this.password = "";
        this.phone = "";
        this.email = "";
    }

    @RequestMapping(value="/registerServer", method=RequestMethod.POST)
    public String registerPost(@RequestBody String request) throws JSONException {
        this.jsonObj = new JSONObject(request);
        this.username = this.jsonObj.getString("user");
        this.firstName = this.jsonObj.getString("firstName");
        this.lastName = this.jsonObj.getString("lastName");
        this.password = this.jsonObj.getString("password");
        this.phone = this.jsonObj.getString("phone");
        this.email = this.jsonObj.getString("email");

        this.person = new Person();
        this.person.setuser(this.username);
        this.person.setFirstName(this.firstName);
        this.person.setLastName(this.lastName);
        this.person.setPassword(this.password);
        this.person.setPhone(this.phone);
        this.person.setEmail(this.email);

        this.repo.save(person);

        return "{\"user\":\"" + this.username
                + "\",\"password\":\"" + this.password
                + "\",\"firstName\":\"" + this.firstName
                + "\",\"lastName\":\"" + this.lastName
                + "\",\"phone\":\"" + this.phone
                + "\",\"email\":\"" + this.email
                + "\"}";
=======

    }

    @RequestMapping(value="/registerServer", method=RequestMethod.POST)
    public String registerPost(@RequestBody Person personData) throws JSONException {

         this.person = personData;

         if(existUser()==false) {
             this.repo.save(person);
             return "{\"user\":\"" + this.person.getuser()
                     + "\",\"resonse\":\"" + "OK"
                     + "\"}";
         }
         else
            return "{\"response\":\"" + "existUserName" + "\"}";
    }

    private boolean existUser() {

        this.listPerson = this.repo.findByUser(this.person.getuser());

        if (listPerson.size()!=0)
            return true;
        else
            return false;

>>>>>>> fa27a06f344ac7534b04b697fa4f127ae28cc1cd
    }



    /* @RequestMapping(value = "/log", method = RequestMethod.GET)
    public String loginGet() {

        return "{\"id\":\"2\",\"title\":\"Gigel\"}";
    }*/
}
