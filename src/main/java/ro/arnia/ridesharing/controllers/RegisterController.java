package ro.arnia.ridesharing.controllers;

import org.json.JSONException;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.arnia.ridesharing.domain.model.Person;
import ro.arnia.ridesharing.domain.model.repository.PersonRepository;

import javax.validation.Valid;
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
    public Person registerPost (@Valid  @RequestBody Person personData, Errors errors) throws JSONException {
        List<ObjectError> listErrors = errors.getAllErrors();

        this.repo.deleteAll();
        if (listErrors.size() != 0) {


        }

        this.person = personData;

        return this.repo.save(person);

    }

    private boolean existUser() {

        this.listPerson = this.repo.findByUserName(this.person.getuserName());

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
