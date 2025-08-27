package VehiclePackage;

import strategy.NormalDS;

public class NormalVehicle extends Vehicle{

    public NormalVehicle(){
        super(new NormalDS());
    }
}
