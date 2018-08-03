package ro.arnia.ridesharing.domain.model.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.validation.annotation.Validated;
import ro.arnia.ridesharing.domain.model.Person;

import javax.validation.Valid;

@RepositoryRestResource
public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findByUserName(@Param("userName") String userName);
    List<Person> findByEmail(@Param("email") String email);
    List<Person> findByPhone(@Param("phone") String phone);

}