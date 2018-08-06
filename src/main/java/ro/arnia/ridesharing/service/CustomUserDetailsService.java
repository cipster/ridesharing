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
import java.util.List;
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
        Optional<Person> optPerson = personRepository.findByUserName(username);

        if (!optPerson.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }
        else {
            Person person = optPerson.get();
            GrantedAuthority authority = new SimpleGrantedAuthority(person.getRole());
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(person.getUserName(), person.getPassword(), Arrays.asList(authority));

            return userDetails;
        }
    }

}
