import VehiclePackage.SportsVehicle;
import VehiclePackage.SuvVehicle;
import VehiclePackage.Vehicle;
import strategy.NormalDS;
import strategy.OffRoadDS;
import strategy.SpecialDS;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

//        Vehicle vehicle = new Vehicle(new SpecialDS());
//        vehicle.drive();

        Vehicle vc = new SportsVehicle();
        vc.drive();

        Vehicle vc2 = new SuvVehicle(new OffRoadDS());
        vc2.drive();

        Vehicle vc3 = new Vehicle(new NormalDS());
        vc3.drive();

    }
}