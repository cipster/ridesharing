package ro.arnia.ridesharing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.arnia.ridesharing.domain.model.Person;
import ro.arnia.ridesharing.domain.model.repository.PersonRepository;

import java.util.Arrays;
import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final PersonRepository personRepository;

    @Autowired
    public CustomUserDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Person> personOptional = personRepository.findByUsername(username);
        if (!personOptional.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }

        return personOptional.get();
    }
}