package ro.arnia.ridesharing.domain.model.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.validation.annotation.Validated;
import ro.arnia.ridesharing.domain.model.Car;
import javax.validation.Valid;

@RepositoryRestResource
@Validated
public interface CarRepository  extends MongoRepository<@Valid Car, String> {

}
