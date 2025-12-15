package task2;

// Abstract class representing a cabin on a ship and defining cabin number
public abstract class Cabin {

    private int cabinNumber;

    public Cabin(int cabinNumber) {
        this.cabinNumber = cabinNumber;
    }

    public int getCabinNumber() {
        return cabinNumber;
    }

    public abstract int getCapacity();
    public abstract String getType();

    @Override
    public String toString() {
        return getType() + " Cabin " + cabinNumber;
    }
}
