package ro.arnia.ridesharing.domain.model.Validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.security.core.parameters.P;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ro.arnia.ridesharing.domain.model.*;
import ro.arnia.ridesharing.domain.model.repository.PersonRepository;

import javax.validation.constraints.Null;
import java.awt.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class MongoDbSpringIntegrationTest {

    @Autowired
    PersonRepository personRepository;

    @DisplayName("Test Person Repository")
    @Test
    void testPersonRepositoryTest() {

        List<Location> listLocation = new ArrayList<Location>();
        Location startPoint, finishPoint;
        BigDecimal la = new BigDecimal(500);
        BigDecimal lo = new BigDecimal(500);
        startPoint = new Location();
        finishPoint = new Location();

        startPoint.setLatitude(la);
        startPoint.setLongitude(lo);
        finishPoint.setLongitude(lo);
        finishPoint.setLatitude(la);

        listLocation.add(startPoint);
        listLocation.add(finishPoint);


        Rating rate = new Rating();
        rate.setStars(3);
        rate.setComment("Something");


        Car car = new Car();
        car.setYear(1994);
        car.setModel("X1");
        car.setAvailableSeats(3);
        car.setBrand("BMW");
        car.setLicensePlate("GL-08-TRO");

        Ride ride = new Ride();
        Date date = new Date(2018, 7, 7, 12, 15, 12);
        ride.setDate(date);


        ride.setEndPoint(finishPoint);
        ride.setStartPoint(startPoint);
        ride.setStops(listLocation);
        //ride.setPassengers();


        Set<Rating> rates = new HashSet<Rating>();
        Set<Car> ownedCars = new HashSet<Car>();
        Set<Ride> rideHistory = new HashSet<Ride>();

        rates.add(rate);
        ownedCars.add(car);
        rideHistory.add(ride);

        Person person = new Person();
        person.setUserName("PaiuOvidiu");
        person.setFirstName("Paiu");
        person.setLastName("Ovidiu");
        person.setPhone("0744611102");
        person.setEmail("ovidiu_george_paiu@yahoo.ro");
        person.setPassword("student170034");
        //person.setType();
        person.setRatings(rates);
        person.setOwnedCars(ownedCars);
        person.setRideHistory(rideHistory);


        personRepository.save(person);
        Optional<Person>  findPerson =  personRepository.findByUserName("PaiuOvidiu");

        if (!findPerson.isPresent()) {
            assertEquals(findPerson.get().getUserName(),"");
        } else {
            /*assertEquals(findPerson.get().getFirstName(),person.getFirstName());
            assertEquals(findPerson.get().getLastName(),person.getLastName());
            assertEquals(findPerson.get().getPhone(),person.getPhone());
            assertEquals(findPerson.get().getPassword(),person.getPassword());
            assertEquals(findPerson.get().getEmail(),person.getEmail());
            assertEquals(findPerson.get().getOwnedCars().size(),1);
            assertEquals(findPerson.get().getOwnedCars().equals(ownedCars),true);*/
            assertEquals(findPerson.get(), person);
        }

        personRepository.delete(person);

    }


    private enum typeUser {
        DRIVER, PASSENGER;
    }


}

