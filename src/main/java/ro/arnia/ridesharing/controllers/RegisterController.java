package ro.arnia.ridesharing.controllers;

import org.json.JSONException;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.arnia.ridesharing.domain.model.Person;
import ro.arnia.ridesharing.domain.model.repository.CarRepository;
import ro.arnia.ridesharing.domain.model.repository.PersonRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RegisterController {
    private CarRepository repo;

    RegisterController(CarRepository carRepository) {
        repo = carRepository;
    }


     @RequestMapping(value = "/deletecars", method = RequestMethod.GET)
    public String loginGet() {
         this.repo.deleteAll();
        return "{\"id\":\"Delete Ok \"}";
    }
}
