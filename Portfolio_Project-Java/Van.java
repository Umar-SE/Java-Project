import java.util.Scanner;
class Van extends Commercial {
    private int loadVolume;
    private boolean slidingSideDoor;

    public void readData(Scanner scanner) {
        super.readData(scanner);
        if (scanner.hasNextInt()) this.loadVolume = scanner.nextInt();
        if (scanner.hasNextBoolean()) this.slidingSideDoor = scanner.nextBoolean();
    }
    
    public int getLoadVolume() {
        return loadVolume;
    }
    
    public void setLoadVolume(int loadVolume) {
        this.loadVolume = loadVolume;
    }
    
    public Boolean getSlidingSideDoor() {
        return slidingSideDoor;
    }
    
    public void setSlidingSideDoor(Boolean slidingSideDoor) {
        this.slidingSideDoor = slidingSideDoor;
    }
    
    public void printDetails() {
        super.printDetails();
        System.out.println("Load Volume: " + loadVolume + "  Sliding Side Door: " + slidingSideDoor);
    }
}