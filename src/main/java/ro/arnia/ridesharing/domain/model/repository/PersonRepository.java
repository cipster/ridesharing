package ro.arnia.ridesharing.domain.model.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ro.arnia.ridesharing.domain.model.Person;

import java.util.Optional;

@RepositoryRestResource
public interface PersonRepository extends MongoRepository<Person, String> {

    @RestResource(exported = false)
    Optional<Person> findByUsername(String user);
}