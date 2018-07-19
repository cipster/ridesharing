package ro.arnia.ridesharing.domain.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.Set;

@Data
public class User extends BaseEntity {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private List<GrantedAuthority> grantedAuthorities;
    private Set<Rating> ratings;
    private Set<Car> ownedCars;
    private Set<Ride> rideHistory;

    private enum type {
        DRIVER,
        PASSENGER
    }

}
