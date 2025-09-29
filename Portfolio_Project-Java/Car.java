import java.util.Scanner;
class Car extends Vehicle {
    private String bodyType;
    private int noOfDoors, noOfSeats;

    public void readData(Scanner scanner) {
        super.readData(scanner);
        if (scanner.hasNext()) this.bodyType = scanner.next().trim();
        if (scanner.hasNextInt()) this.noOfDoors = scanner.nextInt();
        if (scanner.hasNextInt()) this.noOfSeats = scanner.nextInt();
    }
    
    public String getBodyType() {
        return bodyType;
    }
    
    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }
    
    public int getNoOfDoors() {
        return noOfDoors;
    }
    
    public void setNoOfDoors(int noOfDoors) {
        this.noOfDoors = noOfDoors;
    }
    
    public void printDetails() {
        super.printDetails();
        System.out.println("Body Type: " + bodyType + "   Doors: " + noOfDoors + "   Seats: " + noOfSeats);
    }
}