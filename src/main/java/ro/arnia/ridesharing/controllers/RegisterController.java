package ro.arnia.ridesharing.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.arnia.ridesharing.domain.model.repository.CarRepository;
import ro.arnia.ridesharing.domain.model.repository.PersonRepository;

@RestController
public class RegisterController {
    private PersonRepository repo;

    RegisterController(PersonRepository carRepository) {
        repo = carRepository;
    }


    @RequestMapping(value = "/deletecars", method = RequestMethod.GET)
    public String loginGet() {
        this.repo.deleteAll();
        return "{\"id\":\"Delete Ok \"}";
    }
}
