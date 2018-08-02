package ro.arnia.ridesharing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import ro.arnia.ridesharing.domain.model.Validation.CarValidator;

@SpringBootApplication
public class RideSharingApplication extends RepositoryRestConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(RideSharingApplication.class, args);
    }

    @Override
    public void configureValidatingRepositoryEventListener(
            ValidatingRepositoryEventListener v)
    {
        v.addValidator("beforeCreate", new CarValidator());

    }


}
