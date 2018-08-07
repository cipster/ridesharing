package ro.arnia.ridesharing.domain.model.Validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ro.arnia.ridesharing.domain.model.*;
import ro.arnia.ridesharing.domain.model.repository.PersonRepository;

import java.awt.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;

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
        startPoint = new Location(la,lo);
        finishPoint = new Location(la,lo);
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
        

        //assertEquals(42, 43);


        //this.personRepository.save(hhh)
    }


    private enum typeUser {
        DRIVER, PASSENGER;
    }


}

