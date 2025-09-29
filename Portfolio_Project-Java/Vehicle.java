import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
class Vehicle {
    protected String group, vehID, regNo, make, model, fuelType, gearbox, transmission, dateFirstRegistered;
    protected boolean airCon;
    protected double engineSize;
    protected int mileage;
    public Vehicle() {}
    
    public String getVehID() {
        return vehID; 
    }
    
    public void readData(Scanner scanner) {
        scanner.useDelimiter("\s*,\s*");
        if (scanner.hasNext()) this.group = scanner.next().trim();
        if (scanner.hasNext()) this.vehID = scanner.next().trim();
        if (scanner.hasNext()) this.regNo = scanner.next().trim();
        if (scanner.hasNext()) this.make = scanner.next().trim();
        if (scanner.hasNext()) this.model = scanner.next().trim();
        if (scanner.hasNext()) this.airCon = scanner.next().equalsIgnoreCase("Yes");
        if (scanner.hasNextDouble()) this.engineSize = scanner.nextDouble();
        if (scanner.hasNext()) this.fuelType = scanner.next().trim();
        if (scanner.hasNext()) this.gearbox = scanner.next().trim();
        if (scanner.hasNext()) this.transmission = scanner.next().trim();
        if (scanner.hasNextInt()) this.mileage = scanner.nextInt();
        if (scanner.hasNext()) this.dateFirstRegistered = scanner.next().trim();
    }
    
    public String getGroup() {
        return group;
    }
    
    public void setGroup(String group) {
        this.group = group;
    }
    
    public String getvehID() {
        return vehID;
    }
    
    public void setVehID(String vehID) {
        this.vehID = vehID;
    }
    
    public String getRegNo() {
        return regNo;
    }
    
    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }
    
    public String getMake() {
        return make;
    }
    
    public void setMake(String make) {
        this.make = make;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public String getFuelType() {
        return fuelType;
    }
    
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
    
    public String getGearBox() {
        return gearbox;
    }
    
    public void setGearBox() {
        this.gearbox = gearbox;
    }
    
    public String getTransmission() {
        return transmission;
    }
    
    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
    
    public String getDateFirstRegistered() {
        return dateFirstRegistered;
    }
    
    public void setDateFirstRegistered(String dateFirstRegistered) {
        this.dateFirstRegistered = dateFirstRegistered;
    }
    
    public Boolean getAirCon() {
        return airCon;
    }
    
    public void setAirCon(Boolean airCon) {
        this.airCon = airCon;
    }
    
    public Double getEngineSize() {
        return engineSize;
    }
    
    public void setEngineSize(Double engineSize) {
        this.engineSize = engineSize;
    }
    
    public int getMileage() {
        return mileage;
    }
    
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    
    public void printDetails() {
        System.out.println(make + " " + model + "   Group: " + group + "   Vehicle ID: " + vehID);
        System.out.println("Air conditioning/Climate Control: " + (airCon ? "Yes" : "No"));
        System.out.println("Engine Size: " + engineSize + "   Fuel: " + fuelType);
        System.out.println("Gearbox: " + gearbox + "   Transmission: " + transmission);
        System.out.println("Mileage: " + mileage + "   Date first registered: " + dateFirstRegistered);
    }
}