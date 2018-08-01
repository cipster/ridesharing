package ro.arnia.ridesharing.domain.model.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ro.arnia.ridesharing.domain.model.Car;
import ro.arnia.ridesharing.domain.model.repository.CarRepository;


@Component
public class CarValidator implements Validator {
    private CarRepository carRepository;

    @Autowired
    public CarValidator(CarRepository carRepo) {
        this.carRepository = carRepo;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        
        return false;
    }

    @Override
    public void validate(Object obj, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "brand", "car.brand.required");

        Car car = (Car) obj;
        String brand = car.getBrand();
        if( brand == null || brand.equals(""))
        {
            errors.rejectValue("brand", "not is", new Object[]{"'brand'"}, "id can't be negative");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "role.required");
    }
}
