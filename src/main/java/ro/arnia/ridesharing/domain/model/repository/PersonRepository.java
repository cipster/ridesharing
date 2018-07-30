package ro.arnia.ridesharing.domain.model.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ro.arnia.ridesharing.domain.model.Person;

@RepositoryRestResource
public interface PersonRepository extends MongoRepository<Person, String> {

    Person findByLastName(@Param("name") String name);
    Person findByUser(@Param("user") String user);
    Person findByEmail(String email);

}