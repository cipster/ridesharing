package ro.arnia.ridesharing.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import ro.arnia.ridesharing.domain.model.Validation.CarValidator;
import ro.arnia.ridesharing.domain.model.Validation.PersonValidator;

@Configuration
public class RestConfig extends RepositoryRestConfigurerAdapter {
    private final CarValidator carValidator;
    private final PersonValidator personValidator;

    @Autowired
    public RestConfig(CarValidator carValidator, PersonValidator personValidator) {
        this.carValidator = carValidator;
        this.personValidator = personValidator;
    }


    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
        validatingListener.addValidator("beforeCreate", carValidator);
        validatingListener.addValidator("beforeCreate", personValidator);
    }

}

