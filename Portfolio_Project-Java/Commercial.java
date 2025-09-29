import java.util.Scanner;
class Commercial extends Vehicle {
    protected int payload;

    public void readData(Scanner scanner) {
        super.readData(scanner);
        if (scanner.hasNextInt()) this.payload = scanner.nextInt();
    }
    
    public int getPayload() {
        return payload;
    }
    
    public void setPayload(int payload) {
        this.payload = payload;
    }
    
    public void printDetails() {
        super.printDetails();
        System.out.println("Payload: " + payload);
    }
}
