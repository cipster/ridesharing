package ro.arnia.ridesharing.controllers;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import ro.arnia.ridesharing.domain.model.Data.UserData;
import ro.arnia.ridesharing.domain.model.Person;
import ro.arnia.ridesharing.domain.model.repository.PersonRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class RegisterController {
    private List<Person> listPerson;
    private Person person;
    private PersonRepository repo;


    RegisterController(PersonRepository repository){

        this.listPerson = null;
        this.person = null;
        this.repo = repository;

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

    boolean existUser() {

        this.listPerson = this.repo.findByUser(this.person.getuser());

        if (listPerson.size()!=0)
            return true;
        else
            return false;

    }



    /* @RequestMapping(value = "/log", method = RequestMethod.GET)
    public String loginGet() {

        return "{\"id\":\"2\",\"title\":\"Gigel\"}";
    }*/
}
