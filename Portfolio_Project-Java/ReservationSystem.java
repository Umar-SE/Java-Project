import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.awt.FileDialog;
import java.awt.Frame;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;
import java.io.PrintWriter;

public class ReservationSystem {
    private Map<String, Vehicle> vehicleMap;
    private Map<String, Customer> customerMap;
    private Map<String, VehicleReservation> vehicleReservationMap;
    private Random randomGenerator;
    private Diary diary;
    private int reservationCounter;
    public ReservationSystem() {
        vehicleMap = new HashMap<String, Vehicle>();
        customerMap = new HashMap<String, Customer>();
        vehicleReservationMap = new HashMap<String, VehicleReservation>();
        randomGenerator = new Random();
        diary = new Diary();
        reservationCounter = 0;
    }
    
    public void storeVehicleReservation(VehicleReservation reservation) {
        vehicleReservationMap.put(reservation.getReservationNo(), reservation);
        diary.addReservation(reservation);
    }
    
     public String generateReservationNo() {
        reservationCounter++;
        return String.format("%06d", reservationCounter);
    }
    
    public VehicleReservation getVehicleReservation(String reservationNo) {
        return vehicleReservationMap.get(reservationNo);
    }
    
    public boolean makeVehicleReservation(String customerID, String vehID, String startDate, int noOfDays) {
        if (!customerMap.containsKey(customerID) || !vehicleMap.containsKey(vehID)) {
            System.out.println("An Invalid Customer or Vehicle ID has been entered.");
            return false;
        }
        
        String reservationNo = generateReservationNo();
        VehicleReservation reservation = new VehicleReservation(reservationNo, vehID, customerID, startDate, noOfDays);
        storeVehicleReservation(reservation);
        return true;
    }
    
    public void printAllVehicleReservations() {
        for (VehicleReservation reservation : vehicleReservationMap.values()) {
            reservation.printDetails();
            System.out.println();
        }
    }
    
    public void deleteVehicleReservation(String reservationNo) {
        VehicleReservation reservation = vehicleReservationMap.remove(reservationNo);
        if (reservation != null) {
            diary.deleteReservation(reservation);
        }
    }
    
    public void printDiaryEntries(String startDate, String endDate) {
        Date start = DateUtil.convertStringToDate(startDate);
        Date end = DateUtil.convertStringToDate(endDate);
        diary.printEntries(start, end);
    }

    public void resetCustomerMap() {
        customerMap = new HashMap();
        System.out.println("The following customer map has been reset");
    }
    
    public Map<String, Customer> getCustomerMap() {
        return customerMap;
    }
    
    public void storeVehicle(Vehicle vehicle) {
        vehicleMap.put(vehicle.vehID, vehicle);
    }
    
    public void storeCustomer(Customer customer) {
        if (customer.customerID.equals("unknown,")) {
            customer.customerID = generateCustomerID("Customer - ", 6);
        }
        customerMap.put(customer.customerID, customer);
    }
    
    public void printAllVehicles() {
        for (Vehicle vehicle : vehicleMap.values()) {
            vehicle.printDetails();
            System.out.println();
        }
    }
    
    public void printAllCustomers() {
        for (Customer customer : customerMap.values()) {
            customer.printDetails();
            System.out.println();
        }
    }
    
    public String generateCustomerID(String prefix, int length) {
        int number = randomGenerator.nextInt((int) Math.pow(10, length));
        return prefix + String.format("%0" + length + "d", number);
    }
    
    public void readCustomerData() {
        FileDialog fileDialog = new FileDialog((Frame) null, "Select a Customer Data File.", FileDialog.LOAD);
        fileDialog.setVisible(true);
        String directory = fileDialog.getDirectory();
        String filename = fileDialog.getFile();
        
        if (filename == null) {
            System.out.println("No file selected.");
            return;
        }
        
        File file = new File(directory + filename);
        
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String lineOfText = fileScanner.nextLine().trim();
                if (lineOfText.isEmpty() || lineOfText.startsWith("//")) {
                    continue;
                }
                System.out.println(lineOfText);
                Scanner lineScanner = new Scanner(lineOfText);
                Customer customer = new Customer();
                customer.readData(lineScanner);
                storeCustomer(customer);
                lineScanner.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
    
     public void writeCustomerData(String filename) {
        try (PrintWriter writer = new PrintWriter(filename + ".txt")) {
            
            Customer customerObject = new Customer();
            customerObject.writeData(writer, customerMap);
            
            writer.close();
            
            System.out.println("Customer data successfull and is in: " + filename);
        } catch (FileNotFoundException e) {
            System.err.println("There was an error writing to file: " + e.getMessage());
        }
    }
    
    public void readVehicleData() {
        FileDialog fileDialog = new FileDialog((Frame) null, "Select Vehicle Data File", FileDialog.LOAD);
        fileDialog.setVisible(true);
        String directory = fileDialog.getDirectory();
        String filename = fileDialog.getFile();
        
        if (filename == null) {
            System.out.println("No file selected.");
            return;
        }
        
        File file = new File(directory + filename);
        
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String lineOfText = fileScanner.nextLine().trim();
                if (lineOfText.isEmpty() || lineOfText.startsWith("//")) {
                    continue;
                }
                
                Scanner lineScanner = new Scanner(lineOfText);
                Vehicle vehicle = new Vehicle();
                vehicle.readData(lineScanner);
                storeVehicle(vehicle);
                lineScanner.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }
}