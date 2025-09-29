import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Map;

public class Customer extends ReservationSystem{
    public String customerID, surname, firstName, otherInitials, title;
    
    public Customer() {
        this.customerID = "unkown";
    }
    
    public Customer(String surname, String firstName, String otherInitials, String title) {
        this.customerID = "unkown";
        this.surname = surname;
        this.firstName = firstName;
        this.otherInitials = otherInitials;
        this.title = title;
    }
    
       public void writeData(PrintWriter writer, Map<String,Customer> customerMap) {
        for(Customer x : customerMap.values()) {
            String output = x.getCustomerID() + x.getSurname() + x.getFirstName() + x.getOtherInitials() + x.getTitle();
            writer.println(output);
        }
    }
    
    public String getCustomerID() {
        return customerID;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getOtherInitials() {
        return otherInitials;
    }
    
    public void setOtherInitials(String otherInitials) {
        this.otherInitials = otherInitials;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void readData(Scanner scanner) {
        if (scanner.hasNext()) this.customerID = scanner.next().trim();
        if (scanner.hasNext()) this.surname = scanner.next().trim();
        if (scanner.hasNext()) this.firstName = scanner.next().trim();
        if (scanner.hasNext()) this.otherInitials = scanner.next().trim();
        if (scanner.hasNext()) this.title = scanner.next().trim();
    }
    
    public void printDetails() {
        System.out.println("Customer ID: " + customerID);
        System.out.println("Name: " + title + " " + firstName + " " + otherInitials + " " + surname);
    }
}