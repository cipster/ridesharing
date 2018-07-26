package ro.arnia.ridesharing.controllers;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RegisterController {


    @RequestMapping(value="/registerServer", method=RequestMethod.POST)
    public String registerPost(@RequestBody String request) throws JSONException {
        JSONObject jsonObj = new JSONObject(request);
        String user = jsonObj.getString("user");
        String firstName = jsonObj.getString("firstName");
        String lastName = jsonObj.getString("lastName");
        String password = jsonObj.getString("password");
        String phone = jsonObj.getString("phone");
        String email = jsonObj.getString("email");

        return "{\"user\":\"" + user
                + "\",\"password\":\"" + password
                + "\",\"firstName\":\"" + firstName
                + "\",\"lastName\":\"" + lastName
                + "\",\"phone\":\"" + phone
                + "\",\"email\":\"" + email
                + "\"}";
    }

    /* @RequestMapping(value = "/log", method = RequestMethod.GET)
    public String loginGet() {

        return "{\"id\":\"2\",\"title\":\"Gigel\"}";
    }*/
}
