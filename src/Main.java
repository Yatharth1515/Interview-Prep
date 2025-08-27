import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car());
        vehicles.add(new MotorCycle());
        vehicles.add(new Bicycle());
        // here since bicycle obj changes the capability  of its superclass -- to solve this problem methods like hasEngine() should be used in another interface

        for (Vehicle veh : vehicles){
            System.out.println(veh.hasEngine());
        }
    }
}