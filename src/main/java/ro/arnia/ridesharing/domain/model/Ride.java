package ro.arnia.ridesharing.domain.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Ride {
    private Set<Person> passengers;
    private Location startPoint;
    private Location endPoint;
    private List<Location> stops;
    private Date date;

    public Ride start() {

        Ride r =  new Ride();
        return r;
    }

    public Ride add() {
        Ride r =  new Ride();
        return r;
    }

    public Ride accept() {
        Ride r =  new Ride();
        return r;
    }

    public Ride refuse() {
        Ride r =  new Ride();
        return r;
    }


    public Ride search() {
        Ride r =  new Ride();
        return r;
    }


    public Ride cancel() {
        Ride r =  new Ride();
        return r;
    }

}
