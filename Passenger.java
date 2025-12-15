package task2;

import java.util.ArrayList;
import java.util.List;

// Represent a passenger on a ship, storing their cabin and excursions
public class Passenger {

    private String name;
    private Cabin cabin;
    private List<Excursion> excursions = new ArrayList<>();

    public Passenger(String name, Cabin cabin) {
        this.name = name;
        this.cabin = cabin;
    }

    public String getName() {
        return name;
    }

    public Cabin getCabin() {
        return cabin;
    }

    public void setCabin(Cabin newCabin) {
        this.cabin = newCabin;
    }

    public List<Excursion> getExcursions() {
        return excursions;
    }

    public void addExcursion(Excursion ex) {
        excursions.add(ex);
    }

    @Override
    public String toString() {
        return name;
    }
}
