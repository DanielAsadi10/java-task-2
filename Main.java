package task2;

import java.util.*;

public class Main {

    private static List<CruiseShip> ships = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadData(); // Load all information including ships, cabins, excursions, and passengers
        runMenu(); // Start user interface
    }

    // Load all information including ships, cabins, excursions, and passengers
    private static void loadData() {

    ships = new ArrayList<>();

    // SHIP 1 — “Tris Nisis” 
    CruiseShip s1 = new CruiseShip("Tris Nisis");

    // Cabins
    Cabin s1c1 = new Suite(101, true);
    Cabin s1c2 = new Suite(102, false);
    Cabin s1c3 = new StandardCabin(201, true);
    Cabin s1c4 = new StandardCabin(202, false);

    s1.addCabin(s1c1);
    s1.addCabin(s1c2);
    s1.addCabin(s1c3);
    s1.addCabin(s1c4);

    // Excursions
    Excursion s1e1 = new Excursion("Kos", "Monday", 5);
    Excursion s1e2 = new Excursion("Pserimos", "Wednesday", 2);
    Excursion s1e3 = new Excursion("Kalimnos", "Friday", 6);

    s1.addExcursion(s1e1);
    s1.addExcursion(s1e2);
    s1.addExcursion(s1e3);

    // Passengers
    Passenger s1p1 = new Passenger("Alex", s1c1);
    Passenger s1p2 = new Passenger("Bob", s1c1);
    Passenger s1p3 = new Passenger("Charlie", s1c3);

    s1.addPassenger(s1p1);
    s1.addPassenger(s1p2);
    s1.addPassenger(s1p3);

    // Make Pserimos excursion full
    s1e2.addPassenger(s1p1);
    s1p1.addExcursion(s1e2);

    s1e2.addPassenger(s1p2);
    s1p2.addExcursion(s1e2);

    ships.add(s1);


    // SHIP 2 — “Ta Trianisia”
    CruiseShip s2 = new CruiseShip("Ta Trianisia");

    Cabin s2c1 = new Suite(301, true);
    Cabin s2c2 = new StandardCabin(302, true);

    s2.addCabin(s2c1);
    s2.addCabin(s2c2);

    // Excursions
    Excursion s2e1 = new Excursion("Santorini", "Tuesday", 3);
    Excursion s2e2 = new Excursion("Mykonos", "Thursday", 3);
    Excursion s2e3 = new Excursion("Rhodes", "Saturday", 3);

    s2.addExcursion(s2e1);
    s2.addExcursion(s2e2);
    s2.addExcursion(s2e3);

    // Passengers filling cabins completely
    Passenger s2p1 = new Passenger("Daniel", s2c1);
    Passenger s2p2 = new Passenger("Emma", s2c1);
    Passenger s2p3 = new Passenger("Fatima", s2c2);
    Passenger s2p4 = new Passenger("George", s2c2);

    s2.addPassenger(s2p1);
    s2.addPassenger(s2p2);
    s2.addPassenger(s2p3);
    s2.addPassenger(s2p4);

    // Daniel books all excursions (no available left)
    for (Excursion ex : s2.getExcursions()) {
        ex.addPassenger(s2p1);
        s2p1.addExcursion(ex);
    }

    ships.add(s2);

    
    // SHIP 3 — “Tria Nisia” 
    CruiseShip s3 = new CruiseShip("Tria Nisia");

    Cabin s3c1 = new Suite(401, true);
    Cabin s3c2 = new StandardCabin(402, false);
    Cabin s3c3 = new StandardCabin(403, true);

    s3.addCabin(s3c1);
    s3.addCabin(s3c2);
    s3.addCabin(s3c3);

    // Excursions
    Excursion s3e1 = new Excursion("Corfu", "Monday", 10);
    Excursion s3e2 = new Excursion("Zakynthos", "Wednesday", 8);
    Excursion s3e3 = new Excursion("Crete", "Friday", 12);

    s3.addExcursion(s3e1);
    s3.addExcursion(s3e2);
    s3.addExcursion(s3e3);

    // Passengers
    Passenger s3p1 = new Passenger("Hassan", s3c1);
    Passenger s3p2 = new Passenger("Irene", s3c2);

    s3.addPassenger(s3p1);
    s3.addPassenger(s3p2);

    ships.add(s3);
}

    // User interface menu
    private static void runMenu() {
        int choice;
        
        // Stays in the loop until user inputs 0
        do {
            System.out.println("\n----------------------------");
            System.out.println(" Cruise Ship Admin System");
            System.out.println("----------------------------");
            System.out.println("1. Display Cruise Information");
            System.out.println("2. Display Excursion Information");
            System.out.println("3. Display Passenger Information");
            System.out.println("4. Book Excursion");
            System.out.println("5. Change Passenger Cabin");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = readInt();
            switch (choice) {
                case 1: displayCruiseInfo(); break;
                case 2: displayExcursionInfo(); break;
                case 3: displayPassengerInfo(); break;
                case 4: bookExcursion(); break;
                case 5: changeCabin(); break;
                case 0: System.out.println("Goodbye."); break;
                default: System.out.println("Invalid choice."); 
            }
        } while (choice != 0);
    }

        // Loops until valid integer is inputted by the user
        private static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }
    
    // Display ship info including name, number of passengers, and excursion availability
    private static void displayCruiseInfo() {
    CruiseShip ship = chooseShip();
    if (ship == null) return;

    System.out.println("\n-------------------------------------");
    System.out.println(" Cruise Ship: " + ship.getName());
    System.out.println("-------------------------------------");

    System.out.println("Number of Passengers: " + ship.getPassengers().size());
    System.out.println("\nExcursions:");

    // Loop through excuersions and show remaining space
    for (Excursion ex : ship.getExcursions()) {
        String status = ex.isFull()
                ? "FULLY BOOKED"
                : (ex.getSpacesLeft() + " spaces left");

        System.out.println("  - " + ex.getPort() + " (" + ex.getDay() + ") : " + status);
    }

    System.out.println("-------------------------------------\n");
}

    // Allow user to select a ship
    private static CruiseShip chooseShip() {
    System.out.println("\nSelect a cruise ship:");

    // Displays ships name and number
    for (int i = 0; i < ships.size(); i++) {
        System.out.println((i + 1) + ". " + ships.get(i).getName());
    }

    System.out.print("Enter choice: ");
    int choice = readInt();

    if (choice < 1 || choice > ships.size()) {
        System.out.println("Invalid selection.");
        return null;
    }

    return ships.get(choice - 1);
}

    // Allow user to select excursion from selected ship
    private static Excursion chooseExcursion(CruiseShip ship) {
    System.out.println("\nSelect an excursion:");

    // Display excursions
    for (int i = 0; i < ship.getExcursions().size(); i++) {
        Excursion ex = ship.getExcursions().get(i);
        System.out.println((i + 1) + ". " + ex.getPort() + " (" + ex.getDay() + ")");
    }

    System.out.print("Enter choice: ");
    int choice = readInt();

    if (choice < 1 || choice > ship.getExcursions().size()) {
        System.out.println("Invalid selection.");
        return null;
    }

    return ship.getExcursions().get(choice - 1);
}

    // Display list of passengers for selected excursion
    private static void displayExcursionInfo() {
    CruiseShip ship = chooseShip();
    if (ship == null) return;

    Excursion ex = chooseExcursion(ship);
    if (ex == null) return;

    System.out.println("\n-------------------------------------");
    System.out.println(" Excursion: " + ex.getPort());
    System.out.println(" Day: " + ex.getDay());
    System.out.println("-------------------------------------");

    List<Passenger> pax = ex.getPassengers();
    pax.sort(Comparator.comparing(Passenger::getName));

    if (pax.isEmpty()) {
        System.out.println("No passengers booked yet.");
    } else {
        System.out.println("Passengers booked:");
        for (Passenger p : pax) {
            System.out.println(" - " + p.getName());
        }
    }

    System.out.println("-------------------------------------\n");
}

    // Allow user to choose passenger from the selectd ship
    private static Passenger choosePassenger(CruiseShip ship) {

    List<Passenger> pax = new ArrayList<>(ship.getPassengers());
    pax.sort(Comparator.comparing(Passenger::getName));

    System.out.println("\nSelect a passenger:");

    // Display passengers
    for (int i = 0; i < pax.size(); i++) {
        System.out.println((i + 1) + ". " + pax.get(i).getName());
    }

    System.out.print("Enter choice: ");
    int choice = readInt();

    if (choice < 1 || choice > pax.size()) {
        System.out.println("Invalid selection.");
        return null;
    }

    return pax.get(choice - 1);
}

    // Display details for selected passenger including cabin, cabin mates, and booked excursions
    private static void displayPassengerInfo() {
    CruiseShip ship = chooseShip();
    if (ship == null) return;

    Passenger p = choosePassenger(ship);
    if (p == null) return;

    System.out.println("\n-------------------------------------");
    System.out.println(" Passenger: " + p.getName());
    System.out.println("-------------------------------------");

    Cabin c = p.getCabin();
    System.out.println("Cabin: " + c.getCabinNumber() + " (" + c.getType() + ")");

    // Find cabin mates
    List<Passenger> mates = new ArrayList<>();
    for (Passenger other : ship.getPassengers()) {
        if (other != p && other.getCabin().equals(c)) {
            mates.add(other);
        }
    }

    mates.sort(Comparator.comparing(Passenger::getName));

    if (mates.isEmpty()) {
        System.out.println("Cabin mates: none");
    } else {
        System.out.println("Cabin mates:");
        for (Passenger m : mates) {
            System.out.println(" - " + m.getName());
        }
    }

    // Display excursions
    List<Excursion> ex = p.getExcursions();
    if (ex.isEmpty()) {
        System.out.println("Excursions: none booked");
    } else {
        System.out.println("Excursions booked:");
        ex.sort(Comparator.comparing(Excursion::getDay));
        for (Excursion e : ex) {
            System.out.println(" - " + e.getPort() + " (" + e.getDay() + ")");
        }
    }

    System.out.println("-------------------------------------\n");
}

    // Allow passenger to book excursion
    private static void bookExcursion() {
    CruiseShip ship = chooseShip();
    if (ship == null) return;

    Passenger p = choosePassenger(ship);
    if (p == null) return;

    // Get all available excursions for passenger
    List<Excursion> available = ship.getAvailableExcursions(p);

    if (available.isEmpty()) {
        System.out.println("No excursions available to book for this passenger.");
        return;
    }

    System.out.println("\nAvailable excursions:");

    // Display available excursions with remaining space
    for (int i = 0; i < available.size(); i++) {
        Excursion ex = available.get(i);
        System.out.println((i + 1) + ". " + ex.getPort() +
                " (" + ex.getDay() + ") - Spaces left: " + ex.getSpacesLeft());
    }

    System.out.print("Enter choice (0 to cancel): ");
    int choice = readInt();

    if (choice == 0) {
        System.out.println("Booking cancelled.");
        return;
    }

    if (choice < 1 || choice > available.size()) {
        System.out.println("Invalid choice.");
        return;
    }

    Excursion ex = available.get(choice - 1);

    // Book excursion
    if (ex.addPassenger(p)) {
        p.addExcursion(ex);
        System.out.println("\nBooking confirmed! ✔");
        System.out.println(p.getName() + " is now booked for " + ex.getPort() + " (" + ex.getDay() + ")");
    } else {
        System.out.println("Booking failed (excursion full).");
    }
}

    // Return all empty cabins on a ship
    private static List<Cabin> getVacantCabins(CruiseShip ship) {
    List<Cabin> vacant = new ArrayList<>();

    // Loop every cabin and check if occupied
    for (Cabin c : ship.getCabins()) {
        boolean occupied = false;
        for (Passenger p : ship.getPassengers()) {
            if (p.getCabin().equals(c)) {
                occupied = true;
                break;
            }
        }
        if (!occupied) vacant.add(c);
    }

    return vacant;
}

    // Allow user to move passengers and cabin mates into different cabin
    private static void changeCabin() {
    CruiseShip ship = chooseShip();
    if (ship == null) return;

    // Find all completely empty cabins
    List<Cabin> vacant = getVacantCabins(ship);

    if (vacant.isEmpty()) {
        System.out.println("No vacant cabins available.");
        return;
    }

    System.out.println("\nVacant Cabins:");
    for (int i = 0; i < vacant.size(); i++) {
        Cabin c = vacant.get(i);
        System.out.println((i + 1) + ". Cabin " + c.getCabinNumber() + " (" + c.getType() + ")");
    }

    System.out.println("\nDo you want to continue? (1 = yes, 0 = cancel)");
    if (readInt() == 0) return;

    // Select target passenger
    Passenger target = choosePassenger(ship);
    if (target == null) return;

    System.out.print("Select a cabin: ");
    int choice = readInt();

    if (choice < 1 || choice > vacant.size()) {
        System.out.println("Invalid cabin.");
        return;
    }

    Cabin newCabin = vacant.get(choice - 1);
    Cabin oldCabin = target.getCabin();

    // Collect all passengers sharing the same cabin
    List<Passenger> moving = new ArrayList<>();
    for (Passenger p : ship.getPassengers()) {
        if (p.getCabin().equals(oldCabin)) moving.add(p);
    }

    // Move all passengers
    for (Passenger p : moving) p.setCabin(newCabin);

    System.out.println("\n✔ Cabin transfer successful.");
    System.out.println("Moved " + moving.size() + " passenger(s) to Cabin " + newCabin.getCabinNumber());
}
}