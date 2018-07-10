package ro.arnia.ridesharing.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ro.arnia.ridesharing.domain.model.Person;

@RepositoryRestResource
public interface PersonRepository extends MongoRepository<Person, String> {

}
