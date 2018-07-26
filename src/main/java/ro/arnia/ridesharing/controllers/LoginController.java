package ro.arnia.ridesharing.controllers;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import ro.arnia.ridesharing.domain.model.Person;
import ro.arnia.ridesharing.domain.model.repository.PersonRepository;
import java.util.List;

@RestController
public class LoginController {
    private PersonRepository repo;
    private String user ;
    private String name ;
    private String password;
    private JSONObject jsonObj;
    private List<Person> listPerson;
    private Person person;

    public LoginController(PersonRepository repository){
        this.repo = repository;
        this.user = "";
        this.name = "";
        this.password = "";
        this.jsonObj = null;
        this.listPerson = null;
        this.person = null;
    }

    @RequestMapping(value="/loginServer", method=RequestMethod.POST)
    public String loginPost(@RequestBody String request) throws JSONException {

        jsonObj = new JSONObject(request);
        this.user = jsonObj.getString("user");
        this.password = jsonObj.getString("password");



        if(this.user==null || this.password==null)
            return "{\"id\":\""
                    + ""
                    + "\",\"title\":\""
                    + ""
                    + "\",\"response\":\""
                    + "False"
                    + "\"}";

        this.listPerson = this.repo.findByUser(this.user);

        if(listPerson.size()==0)
            return "{\"id\":\""
                    + ""
                    + "\",\"title\":\""
                    + ""
                    + "\",\"response\":\""
                    + "False"
                    + "\"}";

        this.person = this.listPerson.get(0);
        String pass = person.getPassword();

        if(this.password.equals(pass) == true)
            return "{\"id\":\""
                    + this.person.getFirstName()
                    + "\",\"title\":\""
                    + person.getPassword()
                    + "\",\"response\":\""
                    + "True"
                    + "\"}";
        else
            return "{\"id\":\""
                    + this.person.getFirstName()
                    + "\",\"title\":\""
                    + person.getPassword()
                    + "\",\"response\":\""
                    + "False"
                    + "\"}";
    }


    /* @RequestMapping(value = "/log", method = RequestMethod.GET)
    public String loginGet() {

        return "{\"id\":\"2\",\"title\":\"Gigel\"}";
    }*/
}
