package task2;

import java.util.ArrayList;
import java.util.List;

// Represent an excursion on a ship, tracking and limiting passenger bookings
public class Excursion {

    private String port;
    private String day;
    private int limit;
    private List<Passenger> passengers = new ArrayList<>();

    public Excursion(String port, String day, int limit) {
        this.port = port;
        this.day = day;
        this.limit = limit;
    }

    public String getPort() {
        return port;
    }

    public String getDay() {
        return day;
    }

    public int getSpacesLeft() {
        return limit - passengers.size();
    }

    public boolean isFull() {
        return passengers.size() >= limit;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public boolean addPassenger(Passenger p) {
        if (isFull()) return false;
        passengers.add(p);
        return true;
    }
}
