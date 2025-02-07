
import java.util.*;

// ParkingOperations Interface
interface ParkingOperations {
    void parkVehicle(String vehicleNumber);
    void removeVehicle(String vehicleNumber);
    void viewParkedVehicles();
    boolean checkAvailability();
    int availableSpots();
}

// Abstract Class ParkingSpot
abstract class ParkingSpot {
    protected int spotID;
    protected boolean isOccupied;
    protected String vehicleDetails;

    public ParkingSpot(int spotID) {
        this.spotID = spotID;
        this.isOccupied = false;
        this.vehicleDetails = null;
    }

    public int getSpotID() { return spotID; }
    public boolean isOccupied() { return isOccupied; }
    public String getVehicleDetails() { return vehicleDetails; }

    public void occupySpot(String vehicleDetails) {
        this.isOccupied = true;
        this.vehicleDetails = vehicleDetails;
    }

    public void vacateSpot() {
        this.isOccupied = false;
        this.vehicleDetails = null;
    }
}

// Concrete Class for Standard Parking Spot
class StandardParkingSpot extends ParkingSpot {
    public StandardParkingSpot(int spotID) {
        super(spotID);
    }
}

// Concrete Class ParkingLot
class ParkingLot implements ParkingOperations {
    private List<ParkingSpot> spots;
    private int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        spots = new ArrayList<>();
        for (int i = 1; i <= capacity; i++) {
            spots.add(new StandardParkingSpot(i)); // Fix: Use Concrete Class
        }
    }

    public void parkVehicle(String vehicleNumber) {
        for (ParkingSpot spot : spots) {
            if (spot.isOccupied() && vehicleNumber.equals(spot.getVehicleDetails())) {
                System.out.println("Vehicle " + vehicleNumber + " is already parked!");
                return;
            }
        }
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) {
                spot.occupySpot(vehicleNumber);
                System.out.println("Vehicle " + vehicleNumber + " parked at spot " + spot.getSpotID());
                return;
            }
        }
        System.out.println("No available spots!");
    }

    public void removeVehicle(String vehicleNumber) {
        for (ParkingSpot spot : spots) {
            if (spot.isOccupied() && vehicleNumber.equals(spot.getVehicleDetails())) {
                spot.vacateSpot();
                System.out.println("Vehicle " + vehicleNumber + " removed from spot " + spot.getSpotID());
                return;
            }
        }
        System.out.println("Vehicle not found!");
    }

    public void viewParkedVehicles() {
        System.out.println("Currently parked vehicles:");
        boolean found = false;
        for (ParkingSpot spot : spots) {
            if (spot.isOccupied()) {
                System.out.println("Spot " + spot.getSpotID() + ": " + spot.getVehicleDetails());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles parked.");
        }
    }

    public boolean checkAvailability() {
        return availableSpots() > 0;
    }

    public int availableSpots() {
        int count = 0;
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) count++;
        }
        return count;
    }
}

public class ParkingLotManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter parking lot capacity: ");
        int capacity = scanner.nextInt();
        ParkingLot parkingLot = new ParkingLot(capacity);

        while (true) {
            System.out.println("\n1. Park Vehicle\n2. Remove Vehicle\n3. View Parked Vehicles\n4. Check Availability\n5. Available Spots\n6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter vehicle number: ");
                    String vehicle = scanner.nextLine();
                    parkingLot.parkVehicle(vehicle);
                    break;
                case 2:
                    System.out.print("Enter vehicle number to remove: ");
                    String removeVehicle = scanner.nextLine();
                    parkingLot.removeVehicle(removeVehicle);
                    break;
                case 3:
                    parkingLot.viewParkedVehicles();
                    break;
                case 4:
                    System.out.println(parkingLot.checkAvailability() ? "Spots Available" : "Parking Lot Full");
                    break;
                case 5:
                    System.out.println("Available Spots: " + parkingLot.availableSpots());
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
