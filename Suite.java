package task2;

// Represent a suite cabin with a fixed capacity and may include balcony
public class Suite extends Cabin {

    private boolean hasBalcony;

    public Suite(int cabinNumber, boolean hasBalcony) {
        super(cabinNumber);
        this.hasBalcony = hasBalcony;
    }

    @Override
    public int getCapacity() {
        return 4;
    }

    @Override
    public String getType() {
        return hasBalcony ? "Suite (Balcony)" : "Suite";
    }
}
