package ro.arnia.ridesharing.controllers;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {


    @RequestMapping(value="/loginServer", method=RequestMethod.POST)
    public String loginPost(@RequestBody String request) throws JSONException {
        JSONObject jsonObj = new JSONObject(request);
        String name = jsonObj.getString("name");
        String password = jsonObj.getString("password");
        return "{\"id\":\"" + name + "\",\"title\":\"" + password + "\"}";
    }

    /* @RequestMapping(value = "/log", method = RequestMethod.GET)
    public String loginGet() {

        return "{\"id\":\"2\",\"title\":\"Gigel\"}";
    }*/
}
