package ro.arnia.ridesharing.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogControler {
    @RequestMapping("/start")
    public String index() {
        return "{\"id\":\"2\",\"title\":\"ALin\"}";
    }

}
