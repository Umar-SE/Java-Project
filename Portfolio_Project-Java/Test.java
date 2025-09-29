import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class Test {
    public Test() throws IOException {
        ReservationSystem reservationSys = new ReservationSystem();
        
        reservationSys.readVehicleData();
        reservationSys.printAllVehicles();
        reservationSys.readCustomerData();
        reservationSys.printAllCustomers();
        reservationSys.writeCustomerData("textFile");
        
        Date date1 = DateUtil.convertStringToDate("03-09-2022");
        Date date2 = DateUtil.convertStringToDate("06-04-2023");
        System.out.println("Days between: " + DateUtil.daysBetween(date1, date2));
        
        reservationSys.makeVehicleReservation(reservationSys.getCustomerMap().keySet().toArray()[0].toString(), "TF-65118", "01-04-2025", 7);
        
        reservationSys.printAllVehicleReservations();
        
        reservationSys.printDiaryEntries("01-04-2025", "10-04-2025");
    }
}