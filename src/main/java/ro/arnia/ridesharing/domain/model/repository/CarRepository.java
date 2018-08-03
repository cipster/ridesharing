package ro.arnia.ridesharing.domain.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ro.arnia.ridesharing.domain.model.Car;


@RepositoryRestResource
public interface CarRepository extends MongoRepository<Car, String> {


}
