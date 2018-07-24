package ro.arnia.ridesharing.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping(value="/log", method=RequestMethod.POST)
    public String sum() {


        return "{\"id\":\"2\",\"title\":\"Gigel\"}";
    }

    @RequestMapping(value = "/log", method = RequestMethod.GET)
    public String sum2() {

        return "{\"id\":\"2\",\"title\":\"Gigel\"}";
    }
}
