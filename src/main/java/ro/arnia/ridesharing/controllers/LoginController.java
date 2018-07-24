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
    public JSONObject sum(@RequestParam("num1") int number1,
                          @RequestParam("num2") int number2) throws JSONException {

        int rez = number1+number2;
        JSONObject result = null;
        try {
            result = new JSONObject("{'aa':'3'}");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new JSONObject(result.toString());
    }

    @RequestMapping(value = "/log", method = RequestMethod.GET)
    public JSONObject sum2(@RequestParam("num1") int number1,
                   @RequestParam("num2") int number2) throws JSONException {
        int rez = number1+number2;
        JSONObject result = null;
        try {
            result = new JSONObject("{'aa':'3'}");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new JSONObject(result.toString());
    }
}
