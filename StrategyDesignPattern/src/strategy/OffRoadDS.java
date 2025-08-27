package strategy;

public class OffRoadDS implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("OffRoad Mode activated");
    }
}
