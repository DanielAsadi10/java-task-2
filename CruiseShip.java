package task2;

import java.util.ArrayList;
import java.util.List;

// Represent a ship, storing cabins, passengers, and excursions
public class CruiseShip {

    private String name;
    private List<Cabin> cabins = new ArrayList<>();
    private List<Passenger> passengers = new ArrayList<>();
    private List<Excursion> excursions = new ArrayList<>();

    public CruiseShip(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Cabin> getCabins() {
        return cabins;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public List<Excursion> getExcursions() {
        return excursions;
    }

    public void addCabin(Cabin c) {
        cabins.add(c);
    }

    public void addPassenger(Passenger p) {
        passengers.add(p);
    }

    public void addExcursion(Excursion ex) {
        excursions.add(ex);
    }

    // Return all available excursions
    public List<Excursion> getAvailableExcursions(Passenger p) {
        List<Excursion> available = new ArrayList<>();
        for (Excursion e : excursions) {
            if (!p.getExcursions().contains(e) && !e.isFull()) {
                available.add(e);
            }
        }
        return available;
    }
}
