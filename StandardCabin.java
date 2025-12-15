package task2;

// Represent a standard cabin with fixed capacity and may have sea view
public class StandardCabin extends Cabin {

    private boolean hasSeaView;

    public StandardCabin(int cabinNumber, boolean hasSeaView) {
        super(cabinNumber);
        this.hasSeaView = hasSeaView;
    }

    @Override
    public int getCapacity() {
        return 6;
    }

    @Override
    public String getType() {
        return hasSeaView ? "Standard (Sea View)" : "Standard";
    }
}
