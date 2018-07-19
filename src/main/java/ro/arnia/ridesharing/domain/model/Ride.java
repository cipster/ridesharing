package ro.arnia.ridesharing.domain.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Ride extends BaseEntity{

    private Car usedCar;
    private Set<User> passengers;
    private Location startPoint;
    private Location endPoint;
    private List<Location> stops;
    private Date startDate;

}
