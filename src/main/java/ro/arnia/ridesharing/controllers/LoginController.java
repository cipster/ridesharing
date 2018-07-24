package ro.arnia.ridesharing.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping(value="/log", method=RequestMethod.POST)
    public int sum(@RequestParam("num1") int number1,
                       @RequestParam("num2") int number2) {

        return number1+number2;
    }
    @RequestMapping(value = "/log", method = RequestMethod.GET)
    public int sum2(@RequestParam("num1") int number1,
                   @RequestParam("num2") int number2) {

        return number1+number2+1;
    }
}
