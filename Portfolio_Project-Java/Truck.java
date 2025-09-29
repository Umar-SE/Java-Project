import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Truck extends Commercial {
    private ArrayList<String> attributes;
    
    public Truck(){
        attributes = new ArrayList<String>();
    }

    public void readData(Scanner scanner) {
        super.readData(scanner);
        while (scanner.hasNextLine()) {
            attributes.add(scanner.next().trim());
        }
    }
    
    public ArrayList<String> getAttributes() {
        return attributes;
    }
    
    public void setAttributes(ArrayList<String> attributes) {
        this.attributes = attributes;
    }
    
    public void printDetails() {
        super.printDetails();
        System.out.println("Attributes: " + String.join(", ", attributes));
    }
}