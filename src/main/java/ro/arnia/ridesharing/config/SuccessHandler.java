package ro.arnia.ridesharing.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import ro.arnia.ridesharing.domain.model.Person;
import ro.arnia.ridesharing.domain.model.repository.PersonRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

@Component
public class SuccessHandler implements AuthenticationSuccessHandler {

    private final PersonRepository personRepository;
    private final ObjectMapper mapper;

    @Autowired
    public SuccessHandler(PersonRepository personRepository, ObjectMapper mapper) {
        this.personRepository = personRepository;
        this.mapper = mapper;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        response.setStatus(HttpStatus.OK.value());
        String username = ((Person) authentication.getPrincipal()).getUsername();
        Optional<Person> personOptional = personRepository.findByUsername(username);
        personOptional.ifPresent(person -> {
            try {
                String stringyUser = mapper.writeValueAsString(person);
                response.getWriter().write(stringyUser);
            } catch (IOException e) {
                Logger.getAnonymousLogger().info("marea uniune de integrare europeeana");
            }

        });
    }
}