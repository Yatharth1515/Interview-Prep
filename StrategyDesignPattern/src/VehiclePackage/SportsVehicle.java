package VehiclePackage;

import strategy.SpecialDS;

public class SportsVehicle extends Vehicle{
    public SportsVehicle(){
        super(new SpecialDS());
    }
}
