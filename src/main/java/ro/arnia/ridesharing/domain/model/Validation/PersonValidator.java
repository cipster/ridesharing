package ro.arnia.ridesharing.domain.model.Validation;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ro.arnia.ridesharing.domain.model.Person;
import ro.arnia.ridesharing.domain.model.repository.PersonRepository;

import java.util.Optional;

@Component
public class PersonValidator implements Validator {

    private final PersonRepository personRepository;

    PersonValidator(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        Person person = (Person) object;
        Optional<Person> optPerson;
        boolean valid;

        ValidationUtils.rejectIfEmpty(errors, "userName", "person.userName.notNull", "NULL");
        ValidationUtils.rejectIfEmpty(errors, "firstName", "person.firstName.notNull", "NULL");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "person.lastName.notNull", "NULL");
        ValidationUtils.rejectIfEmpty(errors, "password", "person.password.notNull", "NULL");
        ValidationUtils.rejectIfEmpty(errors, "phone", "person.phone.notNull", "NULL");
        ValidationUtils.rejectIfEmpty(errors, "email", "person.email.notNull", "NULL");


        valid = EmailValidator.getInstance().isValid(person.getEmail());
        if (!valid)
            errors.rejectValue("email", "person.email.invalid", "Invalid Email");

        if (person.getEmail() != null && person.getPhone() != null && person.getUserName() != null) {

            optPerson = personRepository.findByUserName(person.getUserName());


            if (optPerson.isPresent())
                errors.rejectValue("userName", "person.userName.exist", "Exist UserName");

            optPerson = personRepository.findByEmail(person.getEmail());
            if (optPerson.isPresent())
                errors.rejectValue("email", "person.email.exist", "Exist Email");

            optPerson = personRepository.findByPhone(person.getPhone());
            if (optPerson.isPresent())
                errors.rejectValue("phone", "person.phone.exist", "Exist Phone");

        }

    }

}
