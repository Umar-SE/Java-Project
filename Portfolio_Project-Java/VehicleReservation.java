import java.util.Date;
class VehicleReservation {
    private String reservationNo, vehID, customerID;
    private Date startDate;
    private int noOfDays;
    
    public VehicleReservation(String reservationNo, String vehID, String customerID, String startDate, int noOfDays) {
        this.reservationNo = reservationNo;
        this.vehID = vehID;
        this.customerID = customerID;
        this.startDate = DateUtil.convertStringToDate(startDate);
        this.noOfDays = noOfDays;
    }

    public String getReservationNo() { 
        return reservationNo; 
    }
    
    public void setReservationNo(String reservationNo) {
        this.reservationNo = reservationNo;
    }
    
    public String getVehID() { 
        return vehID; 
    }
    
    public void setVehID(String vehID) {
        this.vehID = vehID;
    }
    
    public String getCustomerID() { 
        return customerID; 
    }
    
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
    
    public Date getStartDate() { 
        return startDate; 
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    public int getNoOfDays() { 
        return noOfDays; 
    }
    
    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }
    
    public void printDetails() {
        System.out.println("Reservation No: " + reservationNo);
        System.out.println("Customer ID: " + customerID);
        System.out.println("Vehicle ID: " + vehID);
        System.out.println("Start Date: " + DateUtil.convertDateToShortString(startDate));
        System.out.println("Duration: " + noOfDays + " days");
    }
}