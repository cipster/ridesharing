package ro.arnia.ridesharing.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.arnia.ridesharing.domain.model.Data.ChangeRoleData;
import ro.arnia.ridesharing.domain.model.Person;
import ro.arnia.ridesharing.domain.model.repository.PersonRepository;

import java.util.List;

@RestController
public class ChangeRoleController {

    //private String role;
    private String user;
    private PersonRepository repository;
    private JSONObject jsonObj;
    private List<Person> listperson;
    private Person person;
    private String role;


    public ChangeRoleController(PersonRepository repository) {
        this.repository = repository;
        this.user = "";
        this.role = "";
        this.jsonObj = null;
        this.person = null;
        listperson = null;

    }

    @RequestMapping(value = "changeRole", method = RequestMethod.POST)
    public void changeRole(@RequestBody ChangeRoleData request) throws JSONException {

    }
}
