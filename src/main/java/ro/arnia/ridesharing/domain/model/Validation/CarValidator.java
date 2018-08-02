package ro.arnia.ridesharing.domain.model.Validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ro.arnia.ridesharing.domain.model.Car;


@Component
public class CarValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Car.class.equals(clazz);
    }


    //  FE send String => errors in spring.

    @Override
    public void validate(Object obj, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors, "brand", "car.brand.notNull", "NULL");
        ValidationUtils.rejectIfEmpty(errors, "model", "car.model.notNull", "NULL");
        ValidationUtils.rejectIfEmpty(errors, "licensePlate", "car.licensePlate.notNull", "NULL");
        ValidationUtils.rejectIfEmpty(errors, "year", "car.year.notNull", "NULL");
        ValidationUtils.rejectIfEmpty(errors, "availableSeats", "car.availableSeats.notNull", "NULL");

        Car car = (Car) obj;
        if (car.getYear() <= 0) {
            errors.rejectValue("year", "car.year", "greater than 0");
        }

        if (car.getAvailableSeats() <= 0) {
            errors.rejectValue("availableSeats", "car.availableSeats", "greater than 0");
        }

        String model = car.getModel();
        if (model != null && (model.length() < 2 || model.length() > 100)) {
            errors.rejectValue("model", "car.model", "greater than 2 and smaller than 100");
        }

        String brand = car.getBrand();
        if (model != null && (brand.length() < 2 || brand.length() > 100)) {
            errors.rejectValue("brand", "car.brand", "greater than 2 and smaller than 100");
        }

    }

}
