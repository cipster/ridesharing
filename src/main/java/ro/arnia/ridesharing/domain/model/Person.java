package ro.arnia.ridesharing.domain.model;

import lombok.Data;

import java.util.Set;


@Data
public abstract class Person extends BaseEntity {
    private String firstName;
    private String lastName;


    private Set<Rating> ratings;

    private Location currentLocation;
    private Location destination;
    private Car carDetails;

}