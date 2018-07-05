package ro.arnia.ridesharing.domain.model;

import lombok.Data;

@Data
public abstract class Person extends BaseEntity {
    private String firstName;
    private String lastName;
    private Set<Rating>
}
