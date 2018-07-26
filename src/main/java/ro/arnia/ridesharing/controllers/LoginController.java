package ro.arnia.ridesharing.controllers;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import ro.arnia.ridesharing.domain.model.Person;
import ro.arnia.ridesharing.domain.model.repository.PersonRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class LoginController {
    private PersonRepository repo;
    private String name ;
    private String password;
    private JSONObject jsonObj;
    private List<Person> listPerson;
    private Person person;

    public LoginController(PersonRepository repository){
        this.repo = repository;
        this.name = "";
        this.password = "";
        this.jsonObj = null;
        this.listPerson = null;
        this.person = null;
    }

    @RequestMapping(value="/loginServer", method=RequestMethod.POST)
    public String loginPost(@RequestBody String request) throws JSONException {

        jsonObj = new JSONObject(request);
        this.name = jsonObj.getString("name");
        this.password = jsonObj.getString("password");

        if(this.name==null || this.password==null)
            return "{\"id\":\"" + "" + "\",\"title\":\"" + "" + "\"}";


        this.listPerson = this.repo.findByLastName(name);
        if(listPerson.size()==0)
            return "{\"id\":\"" + "" + "\",\"title\":\"" + "" + "\"}";

        this.person = this.listPerson.get(0);

        return "{\"id\":\"" + this.person.getFirstName() + "\",\"title\":\"" + password + "\"}";
    }


    /* @RequestMapping(value = "/log", method = RequestMethod.GET)
    public String loginGet() {

        return "{\"id\":\"2\",\"title\":\"Gigel\"}";
    }*/
}
