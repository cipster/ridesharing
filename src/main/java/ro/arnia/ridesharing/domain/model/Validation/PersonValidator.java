package ro.arnia.ridesharing.domain.model.Validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ro.arnia.ridesharing.domain.model.Person;
import ro.arnia.ridesharing.domain.model.repository.PersonRepository;

import java.util.List;

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
        List<Person> listPerson;


        ValidationUtils.rejectIfEmpty(errors, "userName", "person.userName.notNull", "NULL");
        ValidationUtils.rejectIfEmpty(errors, "firstName", "person.firstName.notNull", "NULL");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "person.lastName.notNull", "NULL");
        ValidationUtils.rejectIfEmpty(errors, "password", "person.password.notNull", "NULL");
        ValidationUtils.rejectIfEmpty(errors, "phone", "person.phone.notNull", "NULL");
        ValidationUtils.rejectIfEmpty(errors, "email", "person.email.notNull", "NULL");

        



        if (person.getEmail() != null && person.getPhone() != null && person.getUserName() != null) {


            listPerson = personRepository.findByUserName(person.getUserName());
            if (listPerson.size() != 0) {
                errors.rejectValue("userName", "person.userName.exist", "Exists UserName");

            }


            listPerson = personRepository.findByEmail(person.getEmail());
            if (listPerson.size() != 0) {
                errors.rejectValue("email", "person.email.exist", "Exists Email");

            }

            listPerson = personRepository.findByPhone(person.getPhone());
            if (listPerson.size() != 0) {
                errors.rejectValue("phone", "person.phone.exist", "Exists Phone");

            }

        }

    }
}
