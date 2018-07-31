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

    public Set<Person> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Person> passengers) {
        this.passengers = passengers;
    }

    public Location getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Location startPoint) {
        this.startPoint = startPoint;
    }

    public Location getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Location endPoint) {
        this.endPoint = endPoint;
    }

    public List<Location> getStops() {
        return stops;
    }

    public void setStops(List<Location> stops) {
        this.stops = stops;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

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
